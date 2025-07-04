package ProductType;

import java.time.LocalDate;

public class ExpirableProdect extends Product{
    private LocalDate expiryDate;
    LocalDate currentDate = LocalDate.now();
    public ExpirableProdect(String productName,int thequantity) {
        expiryDate=LocalDate.of(2026,8,15);
        this.setPrice(5);
        this.setName(productName);
        this.setQuantity(thequantity);
    }
    public Boolean isExpired() {
        if (expiryDate.isBefore(currentDate)) {
            return true;
        } else {
            return false;
        }
    }

}
