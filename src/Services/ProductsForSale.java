package Services;

import ProductType.ExpirableAndShippableProduct;
import ProductType.Product;
import ProductType.ShippableProduct;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ProductsForSale {
    Map<String, Pair<Integer, String>> products ;
    public ProductsForSale() {
        products = new HashMap<>();
        ExpirableAndShippableProduct cheese=
                new ExpirableAndShippableProduct("Cheese",6);
        products.put(cheese.getName(), new Pair<>(cheese.getQuantity(),"ExpirableAndShippableProduct"));
        ExpirableAndShippableProduct biscuit=
                new ExpirableAndShippableProduct("Biscuit",8);
        products.put(biscuit.getName(), new Pair<>(biscuit.getQuantity(),"ExpirableAndShippableProduct"));
        ShippableProduct tv=
                new ShippableProduct("TV",7);
        products.put(tv.getName(), new Pair<>(tv.getQuantity(),"ShippableProduct"));
        ShippableProduct mobile=
                new ShippableProduct("Mobile",9);
        products.put(mobile.getName(), new Pair<>(mobile.getQuantity(), "ShippableProduct"));
        Product scratchmobile= new Product("MobileScratchCard",1);
        products.put(scratchmobile.getName(), new Pair<>(scratchmobile.getQuantity(),"Product"));
    }
    public Map<String, Pair<Integer, String>> getProducts() {
        return products;
    }
}
