package misc.ood.shoppingCart;

/**
 * Created by psagar on 1/28/2018.
 */
public class ProductOrder {
    private Product product;
    private int quantity;
    private double totalPrice;

    public ProductOrder(Product product, int quantity) {
        this.product = product;
        setQuantity(quantity);
    }

    private void calculatePrice(int quantity) {
        this.totalPrice = this.product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculatePrice(quantity);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
