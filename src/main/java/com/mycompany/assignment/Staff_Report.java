package com.mycompany.assignment;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Staff_Report extends javax.swing.JFrame {
        private String StaffId;
        private boolean isAdmin;
        // Add these class variables
        private DefaultMutableTreeNode rootNode;
        private DefaultTreeModel treeModel;

        // Store customer data for filtering
        private Map<String, ArrayList<String>> customerData = new HashMap<>();
        private Map<String, Double> customerTotals = new HashMap<>();

        // Track current filter and search state
        private String currentFilterType = "name";
        private String currentSearchText = "";

        public Staff_Report(String staffId, boolean isAdmin) {
            initComponents();
            this.StaffId = staffId;
            this.isAdmin = isAdmin;

            // Setup the tree
            rootNode = new DefaultMutableTreeNode("Customers");
            treeModel = new DefaultTreeModel(rootNode);
            jTree2.setModel(treeModel);

            // Add action listeners for radio buttons
            azRadioButton.addActionListener(e -> {
                currentFilterType = "name";
                updateTree();
            });

            amountOrder.addActionListener(e -> {
                currentFilterType = "amount";
                updateTree();
            });

            qtyNumberOrder.addActionListener(e -> {
                currentFilterType = "quantity";
                updateTree();
            });

            // Add action listener for find button
            find_button.addActionListener(e -> {
                currentSearchText = search_text_field.getText().toLowerCase();
                updateTree();
            });

            // Add action listener for search field (search when Enter is pressed)
            search_text_field.addActionListener(e -> {
                currentSearchText = search_text_field.getText().toLowerCase();
                updateTree();
            });

            // Load data initially
            loadDataFromFile();
            updateTree(); // Apply default filter (name) with no search
        }

        // Simple method to load data from file
        private void loadDataFromFile() {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("payment_history.txt"));
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] records = line.split(";");
                    for (String record : records) {
                        if (record.trim().isEmpty()) continue;

                        String[] parts = record.split(",", 3);
                        if (parts.length < 3) continue;

                        String customer = parts[1];
                        String productInfo = parts[2];

                        // Extract product details
                        String itemName = extractValue(productInfo, "Item Name:");
                        double price = Double.parseDouble(extractValue(productInfo, "Price:"));
                        int quantity = Integer.parseInt(extractValue(productInfo, "Quantity:"));
                        double total = price * quantity;

                        // Format product display string in table-like format
                        String productDisplay = String.format("%-30s %5d %10.2f", itemName, quantity, total);

                        // Add to customer's product list
                        if (!customerData.containsKey(customer)) {
                            customerData.put(customer, new ArrayList<>());
                            customerTotals.put(customer, 0.0);
                        }
                        customerData.get(customer).add(productDisplay);

                        // Update customer total
                        customerTotals.put(customer, customerTotals.get(customer) + total);
                    }
                }
                reader.close();

            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }

        // Helper method to extract values from product info string
        private String extractValue(String info, String prefix) {
            int start = info.indexOf(prefix);
            if (start == -1) return "";

            start += prefix.length();
            int end = info.indexOf("|", start);
            if (end == -1) end = info.length();

            return info.substring(start, end).trim();
        }

        // Get entries filtered and sorted according to current filter
        private ArrayList<Map.Entry<String, ArrayList<String>>> getFilteredEntries() {
            ArrayList<Map.Entry<String, ArrayList<String>>> entries = new ArrayList<>();

            // If searching by customer name, filter first
            if (!currentSearchText.isEmpty()) {
                for (Map.Entry<String, ArrayList<String>> entry : customerData.entrySet()) {
                    String customer = entry.getKey();
                    ArrayList<String> products = entry.getValue();

                    // Check if customer matches search
                    boolean customerMatches = customer.toLowerCase().contains(currentSearchText);

                    // Check if any product matches search
                    boolean anyProductMatches = false;
                    for (String product : products) {
                        if (product.toLowerCase().contains(currentSearchText)) {
                            anyProductMatches = true;
                            break;
                        }
                    }

                    // Add to filtered entries if customer or any product matches
                    if (customerMatches || anyProductMatches) {
                        entries.add(entry);
                    }
                }
            } else {
                // No search, include all entries
                entries.addAll(customerData.entrySet());
            }

            // Sort based on filter type
            if ("name".equals(currentFilterType)) {
                // Sort alphabetically by customer name
                Collections.sort(entries, new Comparator<Map.Entry<String, ArrayList<String>>>() {
                    @Override
                    public int compare(Map.Entry<String, ArrayList<String>> e1, Map.Entry<String, ArrayList<String>> e2) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                });
            } 
            else if ("amount".equals(currentFilterType)) {
                // Sort by total amount
                Collections.sort(entries, new Comparator<Map.Entry<String, ArrayList<String>>>() {
                    @Override
                    public int compare(Map.Entry<String, ArrayList<String>> e1, Map.Entry<String, ArrayList<String>> e2) {
                        double total1 = customerTotals.get(e1.getKey());
                        double total2 = customerTotals.get(e2.getKey());
                        return Double.compare(total1, total2);
                    }
                });
            } 
            else if ("quantity".equals(currentFilterType)) {
                // Sort by total quantity
                Collections.sort(entries, new Comparator<Map.Entry<String, ArrayList<String>>>() {
                    @Override
                    public int compare(Map.Entry<String, ArrayList<String>> e1, Map.Entry<String, ArrayList<String>> e2) {
                        int qty1 = calculateQuantity(e1.getValue());
                        int qty2 = calculateQuantity(e2.getValue());
                        return Integer.compare(qty1, qty2);
                    }
                });
            }

            return entries;
        }

        // Helper method to calculate total quantity from product strings
        private int calculateQuantity(ArrayList<String> products) {
            int total = 0;
            for (String product : products) {
                String trimmed = product.trim();
                // Extract quantity from the middle of the formatted string
                String[] parts = trimmed.split("\\s+");
                if (parts.length >= 2) {
                    try {
                        total += Integer.parseInt(parts[parts.length - 2]);
                    } catch (NumberFormatException e) {
                        // Skip if not a number
                    }
                }
            }
            return total;
        }
        
        // Add this method to update the grand total display
private void updateGrandTotal() {
    double grandTotal = 0.0;

    // If we have filtered entries, calculate total from those
    ArrayList<Map.Entry<String, ArrayList<String>>> filteredEntries = getFilteredEntries();

    for (Map.Entry<String, ArrayList<String>> entry : filteredEntries) {
        String customer = entry.getKey();

        // If searching, only include matching products in total
        if (!currentSearchText.isEmpty()) {
            ArrayList<String> products = entry.getValue();
            double customerTotal = 0.0;

            // Check if customer name matches
            boolean customerMatches = customer.toLowerCase().contains(currentSearchText);

            if (customerMatches) {
                // If customer matches, add their total
                customerTotal = customerTotals.get(customer);
            } else {
                // Otherwise, only add totals for matching products
                for (String product : products) {
                    if (product.toLowerCase().contains(currentSearchText)) {
                        // Extract amount from product string
                        String[] parts = product.trim().split("\\s+");
                        if (parts.length >= 3) {
                            try {
                                customerTotal += Double.parseDouble(parts[parts.length - 1]);
                            } catch (NumberFormatException e) {
                                // Skip if not a number
                            }
                        }
                    }
                }
            }

            grandTotal += customerTotal;
        } else {
            // No search, add full customer total
            grandTotal += customerTotals.get(customer);
        }
    }

    // Update the total_amount label
    total_amount.setText(String.format("%.2f", grandTotal));
}

// Modify the updateTree method to call updateGrandTotal
private void updateTree() {
    // Clear the tree
    rootNode.removeAllChildren();

    // Get filtered and searched entries
    ArrayList<Map.Entry<String, ArrayList<String>>> filteredEntries = getFilteredEntries();

    // Add table header node
    DefaultMutableTreeNode headerNode = new DefaultMutableTreeNode("Product Name                     Qty     Amount");
    rootNode.add(headerNode);

    // Add filtered entries to tree
    for (Map.Entry<String, ArrayList<String>> entry : filteredEntries) {
        String customer = entry.getKey();
        ArrayList<String> products = entry.getValue();
        double total = customerTotals.get(customer);

        // Format customer node to show total
        String customerDisplay = String.format("%s (Total: RM%.2f)", customer, total);
        DefaultMutableTreeNode customerNode = new DefaultMutableTreeNode(customerDisplay);

        // If we're searching, only add matching products
        if (!currentSearchText.isEmpty()) {
            boolean hasMatchingProducts = false;

            for (String product : products) {
                if (product.toLowerCase().contains(currentSearchText)) {
                    customerNode.add(new DefaultMutableTreeNode(product));
                    hasMatchingProducts = true;
                }
            }

            // Only add customer if it has matching products or its name matches
            if (hasMatchingProducts || customer.toLowerCase().contains(currentSearchText)) {
                rootNode.add(customerNode);
            }
        } else {
            // No search, add all products
            for (String product : products) {
                customerNode.add(new DefaultMutableTreeNode(product));
            }
            rootNode.add(customerNode);
        }
    }

    // Update the tree
    treeModel.reload();

    // Only expand the header node
    jTree2.expandRow(0);

    // Update the grand total
    updateGrandTotal();
}    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filter = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        azRadioButton = new javax.swing.JRadioButton();
        amountOrder = new javax.swing.JRadioButton();
        qtyNumberOrder = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        search_text_field = new javax.swing.JTextField();
        find_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree2 = new javax.swing.JTree();
        print_report_button = new java.awt.Button();
        back_button = new java.awt.Button();
        jLabel4 = new javax.swing.JLabel();
        total_amount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BingoCart");

        jLabel2.setFont(new java.awt.Font("Ravie", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Filter");

        filter.add(azRadioButton);
        azRadioButton.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        azRadioButton.setText("Alphabetical Order (A to Z)");

        filter.add(amountOrder);
        amountOrder.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        amountOrder.setText("Amt Incrceasing Order");

        filter.add(qtyNumberOrder);
        qtyNumberOrder.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        qtyNumberOrder.setText("Qty Increasing Order");
        qtyNumberOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyNumberOrderActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Search: ");

        search_text_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_text_fieldActionPerformed(evt);
            }
        });

        find_button.setText("Find");

        jTree2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTree2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Customer Name");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Customer 1");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Product - Quantity - Total");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Customer 2");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Product 1 - Quantity - Total");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Product 2 - Quantity - Total");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Customer 3");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Product 1 - Quantity - Total");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Product 2 - Quantity - Total");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Product 3 - Quantity - Total");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Product 4 - Quantity - Total");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree2.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree2.setName(""); // NOI18N
        jTree2.setRootVisible(false);
        jTree2.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jTree2);

        print_report_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print_report_button.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        print_report_button.setLabel("Print Report");
        print_report_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_report_buttonActionPerformed(evt);
            }
        });

        back_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_button.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        back_button.setLabel("Go Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setText("Grand Total: RM");

        total_amount.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        total_amount.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(find_button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(qtyNumberOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(amountOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(azRadioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(print_report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(find_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(azRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(amountOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtyNumberOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(print_report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(total_amount))
                .addContainerGap(49, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(692, 473));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void search_text_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_text_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_text_fieldActionPerformed

    private void qtyNumberOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyNumberOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyNumberOrderActionPerformed

    private void print_report_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_report_buttonActionPerformed
            try {
            // Create a temporary file for the report
            java.io.File tempFile = java.io.File.createTempFile("BingoCart_Report_", ".txt");
            java.io.PrintWriter writer = new java.io.PrintWriter(tempFile);

            // Write report header
            writer.println("=======================================================");
            writer.println("                    BINGOCART REPORT                   ");
            writer.println("=======================================================");
            writer.println("Date: " + new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
            writer.println("Time: " + new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));
            writer.println("=======================================================");
            writer.println();

            // Write table header
            writer.println("Product Name                     Qty     Amount");
            writer.println("-------------------------------------------------------");

            // Get filtered entries
            ArrayList<Map.Entry<String, ArrayList<String>>> filteredEntries = getFilteredEntries();

            // Write customer data
            for (Map.Entry<String, ArrayList<String>> entry : filteredEntries) {
                String customer = entry.getKey();
                ArrayList<String> products = entry.getValue();
                double total = customerTotals.get(customer);

                // Write customer name and total
                writer.println();
                writer.println(customer + " (Total: $" + String.format("%.2f", total) + ")");
                writer.println("-------------------------------------------------------");

                // Write products
                boolean hasMatchingProducts = false;
                for (String product : products) {
                    // If searching, only include matching products
                    if (!currentSearchText.isEmpty()) {
                        if (product.toLowerCase().contains(currentSearchText) || 
                            customer.toLowerCase().contains(currentSearchText)) {
                            writer.println(product);
                            hasMatchingProducts = true;
                        }
                    } else {
                        writer.println(product);
                        hasMatchingProducts = true;
                    }
                }

                // If no products were written for this customer, skip the customer
                if (!hasMatchingProducts) {
                    writer.println("No matching products found.");
                }
            }

            // Write grand total
            writer.println();
            writer.println("=======================================================");
            writer.println("GRAND TOTAL: RM " + total_amount.getText());
            writer.println("=======================================================");

            writer.close();

            // Open the report file with the default text editor
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(tempFile);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Report saved to: " + tempFile.getAbsolutePath(), 
                    "Report Generated", 
                    JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error generating report: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_print_report_buttonActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        this.dispose();
        new Staff_Menu(StaffId, isAdmin).setVisible(true); 
    }//GEN-LAST:event_back_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(Staff_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Staff_Report("Default", false).setVisible(true); // Default values for testing
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton amountOrder;
    private javax.swing.JRadioButton azRadioButton;
    private java.awt.Button back_button;
    private javax.swing.ButtonGroup filter;
    private javax.swing.JButton find_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree2;
    private java.awt.Button print_report_button;
    private javax.swing.JRadioButton qtyNumberOrder;
    private javax.swing.JTextField search_text_field;
    private javax.swing.JLabel total_amount;
    // End of variables declaration//GEN-END:variables

}