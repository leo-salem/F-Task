package ProductType;

import java.time.LocalDate;

public class ExpirableAndShippableProduct extends Product implements Shippable {
    private double weight;
    private LocalDate expiryDate;
    LocalDate currentDate = LocalDate.now();
    public ExpirableAndShippableProduct(String productName, int theQuantity) {
        expiryDate=LocalDate.of(2026,8,15);
        this.setPrice(8);
        weight=125.9;
        this.setName(productName);
        this.setQuantity(theQuantity);
    }
    public Boolean isExpired() {
        if (expiryDate.isBefore(currentDate)) {
            return true;
        } else {
            return false;
        }
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
