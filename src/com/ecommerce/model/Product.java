package com.ecommerce.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

public class Product {
    public static final LocalDate NON_EXPIREABLE_PRODUCT = null;
    public static final double NON_SHIPPABLE_PRODUCT = 0.0d;
    private String name;
    private long quanitity;
    private long price;
    private LocalDate expiryDate;
    private double weight;

    public Product(String name, long quanitity, long price, LocalDate expiryDate, double weight) {
        this.name = name;
        this.quanitity = quanitity;
        this.price = price;
        this.expiryDate = expiryDate;
        // Rounds the weight to two digits
        this.weight = new BigDecimal(weight).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public boolean isShippable() {
        return weight != NON_SHIPPABLE_PRODUCT;
    }

    public boolean isExpireable() {
        return expiryDate != null;
    }

    public boolean isExpired() {
        if (!isExpireable())
            return false;

        return LocalDate.now().isAfter(expiryDate) || LocalDate.now().isEqual(expiryDate);
    }

    public String name() {
        return this.name;
    }

    public long avaliableQuantity() {
        return this.quanitity;
    }

    public double weight() {
        return this.weight;
    }

    public long price() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.weight, weight) == 0 && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(expiryDate, product.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quanitity, price, expiryDate, weight);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quanitity=" + quanitity +
                ", price=" + price +
                ", expiryDate=" + expiryDate +
                ", weight=" + weight +
                '}';
    }
}
