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

Output:
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
```

Test Case: General Case Without Shipment
```java
Product product = new Product(
    "Apple Digital Card", 
    10, 
    3, 
    Product.NON_EXPIREABLE_PRODUCT, 
    Product.NON_SHIPPABLE_PRODUCT
);
Customer customer = new Customer("Mohamed", 10);

Cart cart = new Cart();
cart.addProduct(product, 1);

CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
checkoutProcessor.processCheckout();
```
Console Output
```
** Checkout receipt **
Qty -- Product Name -- Price per unit
1x Apple Digital Card 3 L.E

----------------------
Subtotal: 3 L.E
Shipping: 0 L.E
Amount: 3 L.E
```

Test Case: Empty Cart Checkout
```java
Product product = new Product(
    "iPhone", 
    10, 
    10, 
    LocalDate.of(2025, 8, 1), 
    1000
);
Customer customer = new Customer("Mohamed", 10);

Cart cart = new Cart();

CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
checkoutProcessor.processCheckout();
```


Console Output:
``` 
Sorry, the cart is empty. Please add some products to the cart.
```

Test Case: Expired Product in Cart
```java
Product product = new Product(
    "Nokia", 
    10, 
    100, 
    LocalDate.of(2008, 8, 1), 
    1000
);
Customer customer = new Customer("Mohamed", 10);

Cart cart = new Cart();
cart.addProduct(product, 1);

CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
checkoutProcessor.processCheckout();
```

Console Output:
```
Product: Nokia, is expired! You cannot add it to the cart.
```

Test Case: Insufficient Balance
```java
Product product = new Product(
    "iPhone",
    10,
    100,
    LocalDate.of(2025, 8, 1),
    1000
);
Customer customer = new Customer("Mohamed", 10);

Cart cart = new Cart();
cart.addProduct(product, 1);

CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
checkoutProcessor.processCheckout();

```

Console Output:
```
** Checkout receipt **
Qty -- Product Name -- Price per unit
1x iPhone 100 L.E

** Shipment notice **
PLEASE NOTE THAT THE SHIPPING FEE IS 10 L.E PER KG

iPhone 1000.0gm
Total package weight: 1.00kg
----------------------
Subtotal: 100 L.E
Shipping: 10 L.E
Amount: 110 L.E
Sorry, insufficient funds. Your balance is: 10
```

Test Case: Unacceptable Cart Quantity

```java
Product product = new Product(
    "Apple Digital Card",
    10,
    3,
    Product.NON_EXPIREABLE_PRODUCT,
    Product.NON_SHIPPABLE_PRODUCT
);
Customer customer = new Customer("Mohamed", 10);

Cart cart = new Cart();
cart.addProduct(product, 1000);

CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
checkoutProcessor.processCheckout();
```

Console Output:
```
The ordered amount is greater than the available quantity
```

Test Case: Negative Quantity Added to Cart

```java
Product product = new Product(
    "Apple Digital Card",
    10,
    3,
    Product.NON_EXPIREABLE_PRODUCT,
    Product.NON_SHIPPABLE_PRODUCT
);
Customer customer = new Customer("Mohamed", 10);

Cart cart = new Cart();
cart.addProduct(product, -1);

CheckoutProcessor checkoutProcessor = new CheckoutProcessor(customer, cart);
checkoutProcessor.processCheckout();
```

Console Output:
```
You can't add a non-positive quantity value!
```
