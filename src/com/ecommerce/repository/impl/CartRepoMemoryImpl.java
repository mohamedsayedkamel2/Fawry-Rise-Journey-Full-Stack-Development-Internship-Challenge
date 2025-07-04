package com.ecommerce.repository.impl;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.CartRepo;

import java.util.HashMap;
import java.util.Map;

public class CartRepoMemoryImpl implements CartRepo {
    private Map<Customer, Cart> customerCartMap = new HashMap<>();

    @Override
    public Cart getCustomerCart(Customer customer, Cart cart) {
        return customerCartMap.get(customer);
    }

    @Override
    public void saveCart(Customer customer, Cart cart) {
        customerCartMap.put(customer, cart);
    }
}
