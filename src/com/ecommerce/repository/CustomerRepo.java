package com.ecommerce.repository;

import com.ecommerce.model.Customer;

public interface CustomerRepo {
    Customer findByName(String name);
    void createCustomer(Customer customer);
}
