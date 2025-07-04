package ProductType;

public class Product {
    private String Name;
    private int price;
    private int quantity;
    public Product() {
        price=8;
    }
    public Product(String name, int quantity) {
        price=8;
        this.Name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
