package com.mycompany.assignment;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private double price;
    private String description;
    private int buyingAmount; // Quantity the user intends to buy in a transaction
    private int stockAmount;  // Quantity available in inventory

    // Constructor for general item creation (e.g., adding to inventory)
    public Item(String name, double price, String description, int buyingAmount, int stockAmount) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.buyingAmount = buyingAmount; // Often initialized to 0 or 1 when creating inventory
        this.stockAmount = stockAmount;
    }

    // Constructor potentially for payment history or cart items
    // Note: The meaning of 'buyingAmount' might differ here (quantity in cart/purchased)
    public Item(String name, double price, int buyingAmount, String description) {
        this.name = name;
        this.price = price;
        this.buyingAmount = buyingAmount; // Represents quantity purchased/in cart
        this.description = description;
        this.stockAmount = 0; // Stock amount might not be relevant for history/cart view
    }

    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public int getBuyingAmount() { return buyingAmount; }
    public int getStockAmount() { return stockAmount; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setBuyingAmount(int buyingAmount) { this.buyingAmount = buyingAmount; }
    public void setStockAmount(int stockAmount) { this.stockAmount = stockAmount; }

    @Override
    public String toString() {
        // Using %.2f for currency format
        return String.format("Name: %s\nPrice: %.2f\nDescription: %s\n", name, price, description);
    }
}
