package com.mycompany.assignment;

public class Staff extends User {
    private static String role; // "admin" or "staff"

    // getters
    public static String getRole() {
        return role;
    }

    // setters
    public static void setRole(String role) {
	Staff.role = role;
    }

    public static String accountStorageStringFormat() {
        return String.format("\n%s,%s,%s", getUsername(), getEncryptedPassword(), role);
    }

    @Override
    public String toString() {
	return String.format("Staff Username: %s\nEncrypted Password: %s\nRole: %s\n", getUsername(), getEncryptedPassword(), role);
    }
}
