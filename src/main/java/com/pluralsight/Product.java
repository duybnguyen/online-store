package com.pluralsight;

public class Product {
    String sku;
    String productName;
    double price;
    String department;

    public Product(String sku, String productName, double price, String department) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.department = department;

    }

    @Override
    public String toString() {
        return (sku + "|" + productName + "|$" + price + "|" + department);
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
