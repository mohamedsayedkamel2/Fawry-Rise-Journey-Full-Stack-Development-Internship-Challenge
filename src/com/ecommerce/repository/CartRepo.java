package com.ecommerce.repository;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Customer;

public interface CartRepo {
    Cart getCustomerCart(Customer customer, Cart cart);
    void saveCart(Customer customer, Cart cart);
}
