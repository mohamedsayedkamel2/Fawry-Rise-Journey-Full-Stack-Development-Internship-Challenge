package com.ecommerce;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepo;
import com.ecommerce.repository.impl.ProductRepoImpl;
import com.ecommerce.service.CheckoutProcessor;

import java.time.LocalDate;

public class Client {
    public static void main(String[] args) {
       Client client = new Client();
       
       client.testCase_cartQntNegative();
       client.testCase_unacceptableCartQuantity();
       client.testCase_unsufficientBalance();
       client.testCase_generalCaseWithoutShippment();
       client.testCase_generalCaseWithShippment();
       client.testCase_emptyCart();
       client.testCase_expiredProduct();
    }

    void testCase_emptyCart(){
        Product product = new Product("iPhone", 10, 10, LocalDate.of(2025, 8, 1), 1000);
        Customer customer = new Customer("Mohamed", 10);

        try {
            Cart cart = new Cart();
            CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
            checkoutProcessor.processCheckout();
        }
        catch(RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    void testCase_unsufficientBalance() {
        Product product = new Product("iPhone", 10, 100, LocalDate.of(2025, 8, 1), 1000);
        Customer customer = new Customer("Mohamed", 10);

        try {
            Cart cart = new Cart();
            cart.addProduct(product, 1);

            CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
            checkoutProcessor.processCheckout();
        }
        catch(RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    void testCase_expiredProduct() {
        Product product = new Product("Nokia", 10, 100, LocalDate.of(2008, 8, 1), 1000);
        Customer customer = new Customer("Mohamed", 10);

        try {
            Cart cart = new Cart();
            cart.addProduct(product, 1);

            CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
            checkoutProcessor.processCheckout();
        }
        catch(RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    void testCase_generalCaseWithShippment() {
        Product product = new Product("DC Comic Book", 10, 3, LocalDate.of(2025, 8, 1), 10);
        Customer customer = new Customer("Mohamed", 10);

        try {
            Cart cart = new Cart();
            cart.addProduct(product, 1);

            CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
            checkoutProcessor.processCheckout();
        }
        catch(RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    void testCase_generalCaseWithoutShippment() {
        Product product = new Product("Apple Digital Card", 10, 3, Product.NON_EXPIREABLE_PRODUCT, Product.NON_SHIPPABLE_PRODUCT);
        Customer customer = new Customer("Mohamed", 10);

        try {
            Cart cart = new Cart();
            cart.addProduct(product, 1);

            CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
            checkoutProcessor.processCheckout();
        }
        catch(RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    void testCase_cartQntNegative() {
        Product product = new Product("Apple Digital Card", 10, 3, Product.NON_EXPIREABLE_PRODUCT, Product.NON_SHIPPABLE_PRODUCT);
        Customer customer = new Customer("Mohamed", 10);

        try {
            Cart cart = new Cart();
            cart.addProduct(product, -1);

            CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
            checkoutProcessor.processCheckout();
        }
        catch(RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    void testCase_unacceptableCartQuantity() {
        Product product = new Product("Apple Digital Card", 10, 3, Product.NON_EXPIREABLE_PRODUCT, Product.NON_SHIPPABLE_PRODUCT);
        Customer customer = new Customer("Mohamed", 10);

        try {
            Cart cart = new Cart();
            cart.addProduct(product, 1000);

            CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
            checkoutProcessor.processCheckout();
        }
        catch(RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

}
