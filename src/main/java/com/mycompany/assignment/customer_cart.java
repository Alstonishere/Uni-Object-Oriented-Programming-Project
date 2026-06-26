package com.mycompany.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import javax.swing.JOptionPane;


public class customer_cart extends javax.swing.JFrame {
    private ArrayList<Item> cartItems = new ArrayList<>();
       
    public customer_cart() {
        initComponents();
        Select_Quan1.addChangeListener(e -> ItemQuan1.setText(String.valueOf(Select_Quan1.getValue())));
        Select_Quan2.addChangeListener(e -> ItemQuan2.setText(String.valueOf(Select_Quan2.getValue())));
        Select_Quan3.addChangeListener(e -> ItemQuan3.setText(String.valueOf(Select_Quan3.getValue())));
        Select_Quan4.addChangeListener(e -> ItemQuan4.setText(String.valueOf(Select_Quan4.getValue())));
    }
    
    
    private void updateTable() {
        String[] columnNames = {"Product Name", "Price", "Quantity"};
        Object[][] data = new Object[cartItems.size()][3];

        for (int i = 0; i < cartItems.size(); i++) {
            Item item = cartItems.get(i);
            data[i][0] = item.getName();
            data[i][1] = item.getPrice();
            data[i][2] = item.getBuyingAmount();
        }

        cart_table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        add_item = new javax.swing.JButton();
        remove_item = new javax.swing.JButton();
        save_button = new javax.swing.JButton();
        load_button = new javax.swing.JButton();
        itemSelection_1 = new javax.swing.JComboBox<>();
        ItemQuan1 = new javax.swing.JLabel();
        Select_Quan1 = new javax.swing.JSlider();
        ItemQuan2 = new javax.swing.JLabel();
        Select_Quan2 = new javax.swing.JSlider();
        itemSelection_2 = new javax.swing.JComboBox<>();
        itemSelection_3 = new javax.swing.JComboBox<>();
        Select_Quan3 = new javax.swing.JSlider();
        ItemQuan3 = new javax.swing.JLabel();
        Select_Quan4 = new javax.swing.JSlider();
        ItemQuan4 = new javax.swing.JLabel();
        itemSelection_4 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        cart_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BingoCart");

        jLabel2.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add/Remove Item from Cart");

        add_item.setBackground(new java.awt.Color(51, 255, 204));
        add_item.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        add_item.setText("Add Item");
        add_item.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 10, true));
        add_item.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_itemActionPerformed(evt);
            }
        });

        remove_item.setBackground(new java.awt.Color(51, 255, 204));
        remove_item.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        remove_item.setText("Remove Item");
        remove_item.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 10, true));
        remove_item.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        remove_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_itemActionPerformed(evt);
            }
        });

        save_button.setBackground(new java.awt.Color(51, 255, 204));
        save_button.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        save_button.setText("Save (Back)");
        save_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 10, true));
        save_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        load_button.setBackground(new java.awt.Color(51, 255, 204));
        load_button.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        load_button.setText("Load");
        load_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 10, true));
        load_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        load_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_buttonActionPerformed(evt);
            }
        });

        itemSelection_1.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        itemSelection_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Razar Keyboard", "Razar Mouse", "Cooler Faster Keyboard", "Cooler Faster Mouse", "Dill Monitor", "ABC Monitor" }));

        ItemQuan1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ItemQuan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemQuan1.setText("0");

        Select_Quan1.setValue(0);

        ItemQuan2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ItemQuan2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemQuan2.setText("0");

        Select_Quan2.setValue(0);

        itemSelection_2.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        itemSelection_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Razar Keyboard", "Razar Mouse", "Cooler Faster Keyboard", "Cooler Faster Mouse", "Dill Monitor", "ABC Monitor" }));

        itemSelection_3.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        itemSelection_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Razar Keyboard", "Razar Mouse", "Cooler Faster Keyboard", "Cooler Faster Mouse", "Dill Monitor", "ABC Monitor" }));

        Select_Quan3.setValue(0);

        ItemQuan3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ItemQuan3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemQuan3.setText("0");

        Select_Quan4.setValue(0);

        ItemQuan4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ItemQuan4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemQuan4.setText("0");

        itemSelection_4.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        itemSelection_4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Razar Keyboard", "Razar Mouse", "Cooler Faster Keyboard", "Cooler Faster Mouse", "Dill Monitor", "ABC Monitor" }));
        itemSelection_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSelection_4ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(cart_table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(add_item, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(remove_item, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(load_button, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(itemSelection_4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ItemQuan4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Select_Quan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(itemSelection_1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ItemQuan1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Select_Quan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(itemSelection_2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ItemQuan2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Select_Quan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(itemSelection_3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ItemQuan3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Select_Quan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_item, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remove_item, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(load_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(itemSelection_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemQuan1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Select_Quan1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(itemSelection_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemQuan2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Select_Quan2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(itemSelection_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemQuan3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Select_Quan3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(itemSelection_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemQuan4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Select_Quan4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 70, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(910, 488));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addItemToCart(String selectedItem, int quantity) {
    // Skip if no item is selected or quantity is 0
    if (selectedItem.equals("-") || quantity <= 0) {
        return;
    }

    // Create an Item object based on the selection
    Item item = null;
    switch (selectedItem) {
        case "Razar Keyboard":
            item = new Keyboard("Razar Keyboard", 400, "This keyboard uses Cherry MX red switch", quantity, 400, 75, "Red switch", "Wireless");
            break;
        case "Razar Mouse":
            item = new Mouse("Razar Mouse", 200, "Built to last, for gamers", quantity, 750, "Wireless", 180, 4000);
            break;
        case "Cooler Faster Keyboard":
            item = new Keyboard("Cooler Faster Keyboard", 349, "Compact keyboard and built is Cooler Faster special technology", quantity, 200, 60, "Blue switch", "Wired");
            break;
        case "Cooler Faster Mouse":
            item = new Mouse("Cooler Faster Mouse", 80, "Lightweight and high response time", quantity, 699, "Wired", 110, 1000);
            break;
        case "Dill Monitor":
            item = new Monitor("Dill Monitor", 15.00, "Best monitor evern!", quantity, 184, "IPS", 1000);
            break;
        case "ABC Monitor":
            item = new Monitor("ABC Monitor", 30.00, "High resolution with industry grade color reproduction", quantity, 349, "OLED", 750);
            break;
    }

    // Add the item to the cart
    if (item != null) {
        cartItems.add(item);
    }
}
    
    private void add_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_itemActionPerformed
        // Loop through all item selection components and sliders
        addItemToCart((String) itemSelection_1.getSelectedItem(), Select_Quan1.getValue());
        addItemToCart((String) itemSelection_2.getSelectedItem(), Select_Quan2.getValue());
        addItemToCart((String) itemSelection_3.getSelectedItem(), Select_Quan3.getValue());
        addItemToCart((String) itemSelection_4.getSelectedItem(), Select_Quan4.getValue());

        // Update the table to reflect the new cart state
        updateTable();

        // Show success message
        javax.swing.JOptionPane.showMessageDialog(this, "All selected items have been added to the cart!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_add_itemActionPerformed

    private void remove_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_itemActionPerformed
        int selectedRow = cart_table.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select an item to remove.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Remove the selected item from the cart
        cartItems.remove(selectedRow);

        // Update the table
        updateTable();

        // Show success message
        javax.swing.JOptionPane.showMessageDialog(this, "Item removed from cart successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_remove_itemActionPerformed

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
		
        Cart.saveItem(cartItems);
        String username = Customer.getUsername(); // Get the current user's name

        try {
            // Read existing data from the file
            File file = new File("cart_items.dat");
            StringBuilder updatedData = new StringBuilder();
            boolean userExists = false;

            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Check if the line belongs to the current user
                        if (line.startsWith(username + ",")) {
                            userExists = true;
                            // Replace the user's cart information with the updated data
                            StringBuilder userCartData = new StringBuilder();
                            for (Item item : cartItems) {
                                userCartData.append(String.format(
                                    "%s,Item Name: %s|Price: %.2f|Quantity: %d|Description: %s;",
									username,
                                    item.getName(),
                                    item.getPrice(),
                                    item.getBuyingAmount(),
                                    item.getDescription()
                                ));
                            }
                            updatedData.append(userCartData).append("\n");
                        } else {
                            // Keep other users' data intact
                            updatedData.append(line).append("\n");
                        }
                    }
                }
            }

            // If the user doesn't exist in the file, append their data
            if (!userExists) {
                StringBuilder newUserCartData = new StringBuilder();
                for (Item item : cartItems) {
                    newUserCartData.append(String.format(
                        "%s,Item Name: %s|Price: %.2f|Quantity: %d|Description: %s;",
			username,
                        item.getName(),
                        item.getPrice(),
                        item.getBuyingAmount(),
                        item.getDescription()
                    ));
                }
                updatedData.append(newUserCartData).append("\n");
            }

            // Write the updated data back to the file
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(updatedData.toString());
            }

            JOptionPane.showMessageDialog(this, "Cart saved successfully for user: " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new Customer_Menu().setVisible(true);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving cart: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_buttonActionPerformed

    private void load_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_buttonActionPerformed
        String username = Customer.getUsername(); // Get the current user's name

        try (BufferedReader reader = new BufferedReader(new FileReader("cart_items.dat"))) {
            cartItems.clear(); // Clear the existing cart
            String line;

            while ((line = reader.readLine()) != null) {
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
                    }
                    break; // Exit the loop once the user's data is found
                }
            }

            JOptionPane.showMessageDialog(this, "Cart loaded successfully for user: " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
            updateTable(); // Update the table with the loaded cart

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading cart: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_load_buttonActionPerformed

    private void itemSelection_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSelection_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemSelection_4ActionPerformed

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
            java.util.logging.Logger.getLogger(customer_cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customer_cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customer_cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customer_cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ItemQuan1;
    private javax.swing.JLabel ItemQuan2;
    private javax.swing.JLabel ItemQuan3;
    private javax.swing.JLabel ItemQuan4;
    private javax.swing.JSlider Select_Quan1;
    private javax.swing.JSlider Select_Quan2;
    private javax.swing.JSlider Select_Quan3;
    private javax.swing.JSlider Select_Quan4;
    private javax.swing.JButton add_item;
    private javax.swing.JTable cart_table;
    private javax.swing.JComboBox<String> itemSelection_1;
    private javax.swing.JComboBox<String> itemSelection_2;
    private javax.swing.JComboBox<String> itemSelection_3;
    private javax.swing.JComboBox<String> itemSelection_4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton load_button;
    private javax.swing.JButton remove_item;
    private javax.swing.JButton save_button;
    // End of variables declaration//GEN-END:variables
}
