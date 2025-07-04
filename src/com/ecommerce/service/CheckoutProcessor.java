package com.ecommerce.service;

import com.ecommerce.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckoutProcessor {

    private static final int SHIPPING_FEE_PER_KG = 10;
    private Customer customer;
    private Cart cart;

    public CheckoutProcessor(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
    }

    public void processCheckout() {
        if (cart.isEmpty())
            throw new RuntimeException("Sorry, the cart is empty. Please add some products to the cart.");

        for (Product product : cart.getAllProducts()) {
            if (product.isExpired())
                throw new RuntimeException("The product: " + product.name() + ", is expired!");
        }

        long subtotal = 0l;
        double totalWeightInGM = 0.0d;

        System.out.println("** Checkout receipt **");
        System.out.println("Qty -- Product Name -- Price per unit");

        for (Product product : cart.getAllProducts()) {
            long productQnt = cart.getProductQnt(product);

            System.out.println(productQnt + "x " + product.name() + " " + product.price() + " L.E");

            subtotal += (product.price() * productQnt);
            totalWeightInGM += product.weight() * productQnt;
        }

        System.out.println();

        List<Shippable> shippableList = new ArrayList<>();
        for (Product product : cart.getAllProducts()) {
            if (product.isShippable()) {
                shippableList.add(new ShippableProduct(product.name(), product.weight()));
            }
        }

        if (!shippableList.isEmpty()) {
            ShippingService shippingService = new ShippingService(Collections.unmodifiableList(shippableList));
            shippingService.ship();
        }

        System.out.println("----------------------");

        double totalWeightInKG = convertGMtoKG(totalWeightInGM);

        long shippingFees = (long) Math.ceil(totalWeightInKG * SHIPPING_FEE_PER_KG);
        long amount = subtotal + shippingFees;

        System.out.println("Subtotal: " + subtotal + " L.E");
        System.out.println("Shipping: " + shippingFees + " L.E");
        System.out.println("Amount: " + amount + " L.E");


        if (amount > customer.balance())
            throw new RuntimeException("Sorry, insufficient funds. Your balance is: " + customer.balance());

    }

    private double convertGMtoKG(double gm) {
        return gm / 1000;
    }
}
