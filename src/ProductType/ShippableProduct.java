package ProductType;

import java.time.LocalDate;

public class ShippableProduct extends Product implements Shippable{
    private double weight;
    public ShippableProduct(String productName, int theQuantity) {
        this.setPrice(3);
        weight=1634.8;
        this.setName(productName);
        this.setQuantity(theQuantity);
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
