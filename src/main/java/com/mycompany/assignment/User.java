package com.mycompany.assignment;

public class User {
    private static String username;
    private static String encryptedPassword;	
    private static String gender;
    private static final int KEY = 701;

    // getters
    public static String getUsername() {
        return username;
    }
    public static String getEncryptedPassword() {
        return encryptedPassword;
    }
    public static String getGender() {
        return gender;
    }

    // setters
    public static void setUsername(String username) {
        User.username = username;
    }
    
    public static void setEncryptedPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        
        for (char c : password.toCharArray()){
            encrypted.append((char)(c ^ KEY));
        }
        
        User.encryptedPassword = encrypted.toString();
    }
    
    public static void setGender(String gender) {
        User.gender = gender;
    }

    // Validate login credentials
    public static boolean validateLogin(String password) {
		StringBuilder encrypted = new StringBuilder();
                
		for (char c : password.toCharArray()) {
			encrypted.append((char) (c ^ KEY)); // XOR operation
		} 

        return User.getEncryptedPassword().equals(encrypted.toString());
    }
    
    public static void loadEncryptedPassword(String encryptedPassword) {
		User.encryptedPassword = encryptedPassword;
	}
}
