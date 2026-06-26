package com.mycompany.assignment;

public class Mouse extends Peripheral {
    private String connectionType; // e.g., "Wired", "Wireless"
    private int weight; // e.g., in grams
    private int pollingRate; // e.g., in Hz

    public Mouse(String name, double price, String description, int buyingAmount, int stockAmount, String connectionType, int weight, int pollingRate) {
        // Calls the Peripheral constructor, which in turn calls the Item constructor
        super(name, price, description, buyingAmount, stockAmount);
        this.connectionType = connectionType;
        this.weight = weight;
        this.pollingRate = pollingRate;
    }

    // Getters
    public String getConnectionType() { return connectionType; }
    public int getWeight() { return weight; }
    public int getPollingRate() { return pollingRate; }

    // Setters
    public void setConnectionType(String connectionType) { this.connectionType = connectionType; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setPollingRate(int pollingRate) { this.pollingRate = pollingRate; }

    @Override
    public String toString() {
        // Append Mouse-specific details to the Peripheral (and Item) details
        return super.toString() + // Gets info from Peripheral (which gets from Item)
               String.format("Connection Type: %s\nWeight: %d g\nPolling Rate: %d Hz\n",
                             connectionType, weight, pollingRate);
    }
}
