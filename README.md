# Fawry-Rise-Journey-Full-Stack-Development-Internship-Challenge
Test Case: General Case with Shipment
```java
Product product = new Product("DC Comic Book", 10, 3, LocalDate.of(2025, 8, 1), 10);
Customer customer = new Customer("Mohamed", 10);

Cart cart = new Cart();
cart.addProduct(product, 1);

CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
checkoutProcessor.processCheckout();
```

** Checkout receipt **
Qty -- Product Name -- Price per unit
1x DC Comic Book 3 L.E

** Shipment notice **
PLEASE NOTE THAT THE SHIPPING FEE IS 10 L.E PER KG

DC Comic Book 10.0gm
Total package weight: 0.01kg
----------------------
Subtotal: 3 L.E
Shipping: 1 L.E
Amount: 4 L.E
