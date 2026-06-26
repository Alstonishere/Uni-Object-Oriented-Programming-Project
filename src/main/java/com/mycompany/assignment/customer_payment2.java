package com.mycompany.assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class customer_payment2 extends javax.swing.JFrame {
    private String customerName;
    private double totalAmount;   
    private ArrayList<Item> cartItems = new ArrayList<>();
    
    public customer_payment2(String customerName, double totalAmount) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        initComponents();
        jLabel3.setText(String.format("%.2f", totalAmount)); // Display total amount
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        paid_button = new java.awt.Button();
        progress = new javax.swing.JProgressBar();
        paymentMethodComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BingoCart");

        jLabel2.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Make Payment");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("00.00");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total Amount: RM");

        paid_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paid_button.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        paid_button.setLabel("Pay Now!");
        paid_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paid_buttonActionPerformed(evt);
            }
        });

        progress.setBackground(new java.awt.Color(51, 255, 255));
        progress.setForeground(new java.awt.Color(153, 255, 102));
        progress.setToolTipText("");
        progress.setValue(66);
        progress.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Progress", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("SimSun-ExtG", 1, 18))); // NOI18N

        paymentMethodComboBox.setBackground(new java.awt.Color(153, 255, 255));
        paymentMethodComboBox.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        paymentMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Apple Pay", "Online Banking", "E-Wallet", "Visa", "Credit Card", "Mastercard", "Alipay", "Wechat Pay" }));
        paymentMethodComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Method", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Fusion Pixel 10px Monospaced ja", 1, 36))); // NOI18N
        paymentMethodComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(paymentMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(paid_button, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(paymentMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paid_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(645, 392));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void paid_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paid_buttonActionPerformed
		int transactionID = 0;
		// load to file
        try (BufferedReader reader = new BufferedReader(new FileReader("cart_items.dat"))) {
            cartItems.clear(); // Clear the existing cart
            String line;

            while ((line = reader.readLine()) != null) {
                // Check if the line belongs to the current user
                    String[] parts = line.split(",", 2); // Split into username and cart data
                    if (parts.length > 1) {
                        String username = parts[0];
                        String cartData = parts[1]; // Get the cart information
                        String[] items = cartData.split(";"); // Split each item by semicolon

						// load from cart_items.dat to CartInformation object
                        for (String itemData : items) {
                            if (!itemData.isEmpty()) {
                                String[] itemParts = itemData.split("\\|"); // Split item details by pipe
                                String name = itemParts[0].split(": ")[1];
                                double price = Double.parseDouble(itemParts[1].split(": ")[1]);
                                int quantity = Integer.parseInt(itemParts[2].split(": ")[1]);
                                String description = itemParts[3].split(": ")[1];

                                // Add the item to the cart based on its name
                                if (name.contains("Keyboard")) {
                                    cartItems.add(new Item(name, price, quantity, description));
                                } else if (name.contains("Mouse")) {
                                    cartItems.add(new Item(name, price, quantity, description));
                                } else if (name.contains("Monitor")) {
                                    cartItems.add(new Item(name, price, quantity, description));
                                }
                            }
						
                        }
                        
                        try (BufferedReader PHReader = new BufferedReader(new FileReader("payment_history.txt"))) {
                            while ((line = PHReader.readLine()) != null) {
                                // Check if the line belongs to the current user
				String[] PHparts = line.split(",", 2); // Split into username and cart data
				if (PHparts.length > 1) {
                                    String PHTransactionID = PHparts[0];
                                    transactionID = Integer.parseInt(PHTransactionID.substring(2));
                                    }
				}
                            } 
                        catch (IOException e) {
                                JOptionPane.showMessageDialog(this, "Error loading cart: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        };
                        
                        // store CartInformation items into payment_history.txt
                        transactionID += 1;
                        StringBuilder userCartData = new StringBuilder();
                        for (Item item : cartItems) {
                                userCartData.append(String.format(
                                        "PH%03d,%s,Item Name: %s|Price: %.2f|Quantity: %d|Description: %s;",
                                        transactionID,
                                        username,
                                        item.getName(),
                                        item.getPrice(),
                                        item.getBuyingAmount(),
                                        item.getDescription()
                                ));
                        }

                        // Add a newline at the end of the user's data
                        userCartData.append("\n");

                        // Write the current user's data to the file, overwriting existing content
                        File file = new File("payment_history.txt");
                        try (FileWriter writer = new FileWriter(file, true)) { // FileWriter without 'true' in constructor overwrites
                                writer.write(userCartData.toString());
                        }
					
                    }
                }
            } catch (FileNotFoundException ex) {
			Logger.getLogger(customer_payment2.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(customer_payment2.class.getName()).log(Level.SEVERE, null, ex);
		}


		// self note: this is not transfered to customer_payment3, only to clear existing CartInformation file
		Cart.saveItem(new ArrayList<Item>());

		// remove original cart items
		File file = new File("cart_items.dat");
                if (file.exists()) {
                    file.delete();
                }

                String selectedPaymentMethod = (String) paymentMethodComboBox.getSelectedItem();

                // Update the file with the paid status
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("payment_status.txt", true))) {
                    writer.write("Customer Name: " + customerName + "\n");
                    writer.write("Total Amount: RM" + totalAmount + "\n");
                    writer.write("Payment Method: " + selectedPaymentMethod + "\n");
                    writer.write("Payment Status: PAID\n");
                    writer.write("-----------------------------\n");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

        // Show a confirmation message
        JOptionPane.showMessageDialog(this, "Payment Successful!\nPayment Method: " + selectedPaymentMethod + "\nTotal Amount: RM" + totalAmount, "Success", JOptionPane.INFORMATION_MESSAGE);

        // Redirect to customer_page3 (receipt page)
        
        new customer_payment3(customerName, totalAmount, selectedPaymentMethod, cartItems).setVisible(true);
        this.dispose(); // Close the payment frame
    }//GEN-LAST:event_paid_buttonActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(customer_payment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customer_payment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customer_payment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customer_payment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private java.awt.Button paid_button;
    private javax.swing.JComboBox<String> paymentMethodComboBox;
    private javax.swing.JProgressBar progress;
    // End of variables declaration//GEN-END:variables
}
