package misc.ood.shoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by psagar on 1/28/2018.
 */
public class ShoppingCart {
    private List<ProductOrder> productOrders;
    private double totalPrice;
    private double discountAmount;
    private double discount;

    public ShoppingCart() {
        productOrders = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        ProductOrder productOrder = findProductOrder(product);
        if (productOrder == null) {
            productOrder = new ProductOrder(product, quantity);
            productOrders.add(productOrder);
        } else {
            int oldQuantity = productOrder.getQuantity();
            productOrder.setQuantity(oldQuantity+quantity);
        }
        calculateTotalPrice();
    }

    private ProductOrder findProductOrder(Product product) {
        Optional<ProductOrder> optional = productOrders.stream().filter(p -> p.getProduct().equals(product)).findFirst();
        return optional.isPresent() ? optional.get() : null;
    }

    public void removeProduct(Product product, int quantity) {
        ProductOrder productOrder = findProductOrder(product);
        if (productOrder != null) {
            int oldQuantity = productOrder.getQuantity();
            if (oldQuantity > quantity) {
                productOrder.setQuantity(oldQuantity-quantity);
            } else {
                productOrders.remove(productOrder);
            }
        }
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        double price = 0;
        for (ProductOrder p : productOrders) {
            price += p.getTotalPrice();
        }
        this.totalPrice = price;
    }

    public void applyDiscount(double discountPercentage) {
        if (discountPercentage < 100) {
            this.discount = discountPercentage;
            this.discountAmount = this.totalPrice * (discountPercentage/100);
        }
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }
}
