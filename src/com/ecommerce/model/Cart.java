package com.ecommerce.model;

import java.util.*;

public class Cart {
    private Map<Product, Long> productQuantitiyMap = new HashMap<>();

    public void addProduct(Product product, long quantity) {
        if (!isValid(product, quantity)) return;

        if (!productQuantitiyMap.containsKey(product)) {
            productQuantitiyMap.put(product, quantity);
        }
        else {
            productQuantitiyMap.put(product, productQuantitiyMap.get(product) + quantity);
        }
    }

    public void removeProduct(Product product) {
        if (productQuantitiyMap.containsKey(product))
            productQuantitiyMap.remove(product);
        else
            throw new RuntimeException("Product: " + product.name() + ", does not exist in the cart!");
    }

    public void changeProductQnt(Product product, long quantity) {
        if (!productQuantitiyMap.containsKey(product))
            throw new RuntimeException("The product does not exist in the cart!");

        if (quantity < 0)
            throw new RuntimeException("You can't enter a negative quantity!");


        if (quantity <= product.avaliableQuantity())
            productQuantitiyMap.put(product, quantity);
    }

    public Set<Product> getAllProducts() {
        return productQuantitiyMap.keySet();
    }

    public long getProductQnt(Product product) {
        Long qnt = productQuantitiyMap.get(product);
        if (qnt == null) {
            throw new RuntimeException("The product does not exist!");
        }

        return qnt;
    }

    public long cartSize() {
        return productQuantitiyMap.size();
    }

    public boolean isEmpty() {
        return productQuantitiyMap.isEmpty();
    }
    private boolean isValid(Product product, long quantity) {
        if (quantity <= 0)
            throw new RuntimeException("You can't add a non-positive quantity value!");

        if (product.isExpired())
            throw new RuntimeException("Product: " + product.name() + ", is expired! You cannot add it to the cart.");

        if (quantity > product.avaliableQuantity())
            throw new RuntimeException("The ordered amount is greater than the available quantity");

        if (productQuantitiyMap.getOrDefault(product, 0l) + quantity > product.avaliableQuantity())
            throw new RuntimeException("You can't order products than the available amount");

        return true;
    }
}
