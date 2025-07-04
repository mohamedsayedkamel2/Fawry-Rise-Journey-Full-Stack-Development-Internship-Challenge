package com.ecommerce.repository;

import com.ecommerce.model.Product;

import java.util.List;

public interface ProductRepo {
    void createProduct(Product product);
    Product findProductByName(String name);
    List<Product> getAllProducts();
}
