package com.ecommerce.model;

public class Customer {
    private final String name;
    private final long balance;

    public Customer(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public String name() {
        return this.name;
    }

    public long balance() {
        return this.balance;
    }

}
