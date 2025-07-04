import Clients.Customer;
import ProductType.*;
import Services.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    public static void main(String[] args) {
        String cheese="Cheese",tv="TV",scratchCard="MobileScratchCard";
        Cart cart = new Cart();
        Customer customer = new Customer("mohamed",390);
        cart.add(cheese, 2);
        cart.add(tv, 3);
        cart.add(scratchCard, 1);
        checkout(customer, cart);
    }

    public static void checkout(Customer customer, Cart cart){
        int TotalSum=0;
        ArrayList<Pair<String,Pair<Integer,Integer>>> all=new ArrayList<>();
        int totalshipp=30;
        ShippingService shippingService=new ShippingService();
        ProductsForSale productsForSale=new ProductsForSale();
        Map<String, Pair<Integer, String>> products=productsForSale.getProducts();
        ArrayList<Item> items=cart.getItems();
        if (items.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        for (Item item : items) {
            String itemName=item.getName();
            int itemQuantity=item.getQuantity();
            if(!products.containsKey(itemName)){
                System.out.println("this product not included in our menu !");
                return;
            }
            else{
                Pair<Integer, String> pair=products.get(itemName);
                int AvailableQuantity= pair.getKey();
                String productType=pair.getValue();
                if (itemQuantity<0){
                    System.out.println("please enter positive amount !");
                    return;
                }
                if (AvailableQuantity<itemQuantity){
                    System.out.println("sorry this amount of "+itemName+" more than available");
                    return;
                }
                else{
                    Product product;
                    if(productType.equals("ExpirableAndShippableProduct")){
                         product=new ExpirableAndShippableProduct(itemName,AvailableQuantity);
                         if ( ((ExpirableAndShippableProduct) product).isExpired()){
                             System.out.println("this product has expired !");
                             return;
                         }
                        shippingService.AddShipping(new Pair<>((Shippable) product,itemQuantity));
                    } else if (productType.equals("ShippableProduct")) {
                         product=new ShippableProduct(itemName,AvailableQuantity);
                        shippingService.AddShipping(new Pair<>((Shippable) product,itemQuantity));
                    } else if (productType.equals("ExpirableProduct")) {
                         product=new ExpirableProdect(itemName,AvailableQuantity);
                        if ( ((ExpirableProdect) product).isExpired()){
                            System.out.println("this product has expired !");
                            return;
                        }
                    }
                    else{
                         product=new Product(itemName,AvailableQuantity);
                    }
                    product.setQuantity(AvailableQuantity-itemQuantity);
                    pair.setKey(AvailableQuantity - itemQuantity);
                    TotalSum+=(product.getPrice() * itemQuantity);
                    all.add(new Pair<>(itemName, new Pair<>(itemQuantity,product.getPrice())));
                }
            }
        }
        int totalAmount = TotalSum + totalshipp;
        if (customer.getMoney() < totalAmount) {
            System.out.println("Insufficient balance!");
            return;
        }
        System.out.println("** Shipment notice **");
        ArrayList<Pair<Shippable, Integer>> ship=shippingService.getShipping();
        double totalWeight=0;
        for (Pair<Shippable, Integer> pair : ship) {
            totalWeight+= pair.getKey().getWeight();
            System.out.println(pair.getValue() + "x" + ((Product) pair.getKey()).getName() + "         " + pair.getKey().getWeight() + "g");

        }

        double roundedWeight = Math.round(totalWeight/10.0)/100.0;
        System.out.println("Total package weight       " + roundedWeight + "kg");
        System.out.println();
        System.out.println("** Checkout receipt **");
        for (Pair<String,Pair<Integer,Integer>> pair : all) {
            int price=pair.getValue().getValue();
            int quantity=pair.getValue().getKey();
            String name=pair.getKey();
            System.out.println(quantity + "x"+name+"         "+quantity*price );
        }
        System.out.println("----------------------");
        System.out.println("Subtotal              " +TotalSum);
        System.out.println("Shipping              " +totalshipp);
        System.out.println("Amount              " +(TotalSum+totalshipp));
        customer.setMoney(customer.getMoney() - (TotalSum+totalshipp));
        System.out.println("Remaining customer money         " + customer.getMoney());
    }
}