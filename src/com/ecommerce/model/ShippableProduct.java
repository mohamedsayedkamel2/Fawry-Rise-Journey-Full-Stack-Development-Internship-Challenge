package com.ecommerce.model;

public class ShippableProduct implements Shippable {
    private String name;
    private double weight;

    public ShippableProduct(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
