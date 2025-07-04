package Services;

import java.util.ArrayList;

public class Cart {
     private int Size;
     private ArrayList<Item> items;
     public Cart() {
         Size = 0;
         items = new ArrayList<>();
     }
     public void add(String TheItem, int quantity) {
         Item item=new Item(TheItem,quantity);
         items.add(item);
         Size++;
     }

    public ArrayList<Item> getItems() {
        return items;
    }
}
