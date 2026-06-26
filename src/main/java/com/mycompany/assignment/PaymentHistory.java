package com.mycompany.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PaymentHistory extends javax.swing.JFrame {
    ArrayList<Item> cartItems; // Retrieve cart items from Cart_Information
	String username;
	String description = "";

    // Constructor to accept customer details and cart items
    public PaymentHistory() {	
        cartItems = Cart.getCartItems();
	username = Customer.getUsername();
        initComponents();
        loadReceiptTable(); // Load the receipt details into the table
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        receipt_table = new javax.swing.JTable();
        menu_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BingoCart");

        jLabel2.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Payment History");

        receipt_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product Name", "Quantity", "Price Per Unit", "Amount(RM)"
            }
        ));
        jScrollPane1.setViewportView(receipt_table);

        menu_button.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        menu_button.setText("Back To Menu Page");
        menu_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.gray, null, null));
        menu_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 114, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menu_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu_button)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(861, 473));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_buttonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Customer_Menu().setVisible(true);
    }//GEN-LAST:event_menu_buttonActionPerformed

    private void updateTable() {
        String[] columnNames = {"Product Name", "Price", "Quantity"};
        Object[][] data = new Object[cartItems.size()][3];

        for (int i = 0; i < cartItems.size(); i++) {
            Item item = cartItems.get(i);
            data[i][0] = item.getName();
            data[i][1] = item.getPrice();
            data[i][2] = item.getBuyingAmount();
        }

        receipt_table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private void loadReceiptTable() {

        try (BufferedReader reader = new BufferedReader(new FileReader("payment_history.txt"))) {
            cartItems.clear(); // Clear the existing cart
            String line;

            while ((line = reader.readLine()) != null) {
				line = line.split(",", 2)[1];
                // Check if the line belongs to the current user
                if (line.startsWith(username + ",")) {
                    String[] parts = line.split(",", 2); // Split into username and cart data
                    if (parts.length > 1) {
                        String cartData = parts[1]; // Get the cart information
                        String[] items = cartData.split(";"); // Split each item by semicolon

                        for (String itemData : items) {
                            if (!itemData.isEmpty()) {
                                String[] itemParts = itemData.split("\\|"); // Split item details by pipe
                                String name = itemParts[0].split(": ")[1];
                                double price = Double.parseDouble(itemParts[1].split(": ")[1]);
                                int quantity = Integer.parseInt(itemParts[2].split(": ")[1]);

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
                    }
                }
            }

            JOptionPane.showMessageDialog(this, "Cart loaded successfully for user: " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
            updateTable(); // Update the table with the loaded cart

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading cart: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        DefaultTableModel model = (DefaultTableModel) receipt_table.getModel();
        model.setRowCount(0); // Clear existing rows
        for (Item item : cartItems) {
            model.addRow(new Object[]{
                item.getName(),
                String.format("%.2f", item.getPrice()),
                item.getBuyingAmount(),
                String.format("%.2f", item.getPrice() * item.getBuyingAmount())
            });
        }
    }
    
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
            java.util.logging.Logger.getLogger(PaymentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menu_button;
    private javax.swing.JTable receipt_table;
    // End of variables declaration//GEN-END:variables
}
