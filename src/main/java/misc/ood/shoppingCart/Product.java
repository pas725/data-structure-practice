package misc.ood.shoppingCart;

/**
 * Created by psagar on 1/28/2018.
 */
public class Product {
    private long id;
    private String name;
    private ProductCategory category;
    private double price;
    private int availableCount;

    public Product(String name, ProductCategory category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.availableCount = 50;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }
}
