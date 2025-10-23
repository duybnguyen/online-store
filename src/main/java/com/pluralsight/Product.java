package com.pluralsight;

public class Product {
    String sku;
    String productName;
    double price;
    String department;

    public Product(String department, double price, String productName, String sku) {
        this.department = department;
        this.price = price;
        this.productName = productName;
        this.sku = sku;
    }

    public String getDepartment() {
        return department;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public String getSku() {
        return sku;
    }
}
