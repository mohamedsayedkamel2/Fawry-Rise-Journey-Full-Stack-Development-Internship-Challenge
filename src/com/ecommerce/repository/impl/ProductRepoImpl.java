package com.ecommerce.repository.impl;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepoImpl implements ProductRepo {
    private Map<String, Product> productMap = new HashMap<>();

    @Override
    public void createProduct(Product product) {
        productMap.put(product.name(), product);
    }

    @Override
    public Product findProductByName(String name) {
        return productMap.get(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productMap.values();
    }
}
