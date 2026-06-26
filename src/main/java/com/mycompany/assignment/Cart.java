package com.mycompany.assignment;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Cart {

	private static ArrayList<Item> cartItems = new ArrayList<>();

	public static void saveItem(ArrayList<Item> newCartItems) {
		try (FileOutputStream fos = new FileOutputStream("items.dat"); 
			ObjectOutputStream oos = new ObjectOutputStream(fos)) { 
			oos.writeObject(newCartItems);
		} catch (IOException e) {
			System.out.println("IO error: " + e.getMessage());
		}
	}

	public static void loadItem() {
		File file = new File("items.dat");
		if (file.exists()) {
			try (FileInputStream fis = new FileInputStream("items.dat"); ObjectInputStream ois = new ObjectInputStream(fis)) {
                            // Cast to the specific array type
                            cartItems = (ArrayList<Item>) ois.readObject();

			} catch (ClassNotFoundException e) {
				System.out.println("Class not found: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("IO error: " + e.getMessage());
			}
		}
	}

	public static ArrayList<Item> getCartItems() {
		return cartItems;
	}

	public static void addItemToCart(Item item) {
		cartItems.add(item);
	}

	public static void clearCart() {
		cartItems.clear();
	}

	public static boolean isCartEmpty() {
		return cartItems.isEmpty();
	}
}
