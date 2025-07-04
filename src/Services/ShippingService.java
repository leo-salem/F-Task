package Services;

import ProductType.Product;
import ProductType.Shippable;

import java.util.ArrayList;

public class ShippingService {
    private ArrayList<Pair<Shippable, Integer>> shipping;

    public ShippingService() {
        shipping = new ArrayList<>();
    }

    public void AddShipping(Pair<Shippable, Integer> shippablePair) {
        shipping.add(shippablePair);
    }

    public ArrayList<Pair<Shippable, Integer>> getShipping() {
        return shipping;
    }
}
