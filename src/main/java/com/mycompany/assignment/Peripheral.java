package com.mycompany.assignment;

// Represents a general computer peripheral, inheriting basic item properties.
public class Peripheral extends Item {

    // Constructor passes arguments up to the Item constructor
    public Peripheral(String name, double price, String description, int buyingAmount, int stockAmount) {
        super(name, price, description, buyingAmount, stockAmount);
        // No additional fields specific to all peripherals in this example
    }

    // Constructor for payment history/cart view
     public Peripheral(String name, double price, int buyingAmount, String description) {
        super(name, price, buyingAmount, description);
         // No additional fields specific to all peripherals in this example
    }


    // You could add methods or fields common to all peripherals here if needed later.

    @Override
    public String toString() {
        // Simply returns the string representation from the Item class
        return super.toString();
    }
}
