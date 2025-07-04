package com.ecommerce.service;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.model.Shippable;

import java.util.List;

public class ShippingService {
    private final List<Shippable> shippableList;

    public ShippingService(List<Shippable> shippableList) {
        this.shippableList = shippableList;
    }
    void ship() {
        System.out.println("** Shipment notice **");
        System.out.println("PLEASE NOTE THAT THE SHIPPING FEE IS 10 L.E PER KG");
        System.out.println();
        double totalWeight = 0;

        for (Shippable shippableProduct : shippableList) {
            System.out.println(shippableProduct.getName() + " " + shippableProduct.getWeight() + "gm");

            totalWeight += shippableProduct.getWeight();
        }

        // Convert gm to kg
        totalWeight /= 1000;

        System.out.printf("Total package weight: %.2fkg%n", totalWeight);
    }
}
