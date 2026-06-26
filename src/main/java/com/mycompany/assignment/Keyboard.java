package com.mycompany.assignment;

public class Keyboard extends Peripheral {
    private int keyboardSize; // e.g., 104 (Full), 87 (TKL), 61 (60%)
    private String switchType; // e.g., "Mechanical", "Membrane"
    private String connectionType; // e.g., "Wired", "Wireless", "Bluetooth"

    public Keyboard(String name, double price, String description, int buyingAmount, int stockAmount, int keyboardSize, String switchType, String connectionType) {
        super(name, price, description, buyingAmount, stockAmount);
        this.keyboardSize = keyboardSize;
        this.switchType = switchType;
        this.connectionType = connectionType;
    }

    // Getters
    public int getKeyboardSize() { return keyboardSize; }
    public String getSwitchType() { return switchType; }
    public String getConnectionType() { return connectionType; }

    // Setters
    public void setKeyboardSize(int keyboardSize) { this.keyboardSize = keyboardSize; }
    public void setSwitchType(String switchType) { this.switchType = switchType; }
    public void setConnectionType(String connectionType) { this.connectionType = connectionType; }

    @Override
    public String toString() {
        // Append Keyboard-specific details
        return super.toString() +
               String.format("Keyboard Size: %d keys\nSwitch Type: %s\nConnection Type: %s\n",
                             keyboardSize, switchType, connectionType);
    }
}
