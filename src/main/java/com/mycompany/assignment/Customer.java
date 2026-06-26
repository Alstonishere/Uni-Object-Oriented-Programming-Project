package com.mycompany.assignment;

public class Customer extends User {
    private static String name;

    // getters
    public static String getName() {
            return name;
    }

    // setters
    public static void setName(String name) {
            Customer.name = name;
    }

    public static String accountStorageStringFormat() {
		return String.format("\n%s,%s,%s,%s", getUsername(), getEncryptedPassword(), getName(), getGender());
    }

    @Override
    public String toString() {
		return String.format("Customer Username: %s\nEncrypted Password: %s\nGender: %s\nName: %s\n", getUsername(), getEncryptedPassword(), getGender(), name);
    }
}
