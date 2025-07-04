package com.ecommerce.repository.impl;

import com.ecommerce.model.Customer;
import com.ecommerce.repository.CustomerRepo;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepoImpl implements CustomerRepo {
    private Map<String, Customer> customerMap = new HashMap<>();

    @Override
    public Customer findByName(String name) {
        return customerMap.get(name);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerMap.put(customer.name(), customer);
    }
}
