package com.mycompany.assignment;

public class Monitor extends Peripheral {
    private String screenType;
    private int screenSize;

    public Monitor(String name, double price, String description, int buyingAmount, int stockAmount, String screenType, int screenSize) {
        super(name, price, description, buyingAmount, stockAmount);
        this.screenType = screenType;
        this.screenSize = screenSize;
    }

    // Getters
    public String getScreenType() { return screenType; }
    public int getScreenSize() { return screenSize; }

    // Setters
    public void setScreenType(String screenType) { this.screenType = screenType; }
    public void setScreenSize(int screenSize) { this.screenSize = screenSize; }

    @Override
    public String toString() {
        // Append Monitor-specific details. Corrected format string.
        return super.toString() +
               String.format("Screen Type: %s\nScreen Size: %d inches\n", // Changed "Weight" to "Screen Size" and %s to %d
                             screenType, screenSize);
    }
}
