package com.mycompany.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Customer_Menu extends javax.swing.JFrame {

    public Customer_Menu() {
        initComponents();
        loadCartFromFile();
        String name = Customer.getUsername();
        String gender = Customer.getGender();

        if (gender.equals("Male")) {
            welcome_text.setText("Hi, Mr. " + name);
        } else if (gender.equals("Female")) {
            welcome_text.setText("Hi, Ms. " + name);
        } else {
            welcome_text.setText("Hi, " + name);
        }       
    }
    
    private void loadCartFromFile() {
        File cartFile = new File("cart_items.txt");
        if (!cartFile.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(cartFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse each item line (format: "Name: X|Price: X|Quantity: X|Description: X")
                String[] parts = line.split("\\|");
                String name = parts[0].substring(parts[0].indexOf(": ") + 2);
                double price = Double.parseDouble(parts[1].substring(parts[1].indexOf(": ") + 2));
                int quantity = Integer.parseInt(parts[2].substring(parts[2].indexOf(": ") + 2));
                String description = parts[3].substring(parts[3].indexOf(": ") + 2);

                // Item is parsed but not used in the original code
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        welcome_text = new javax.swing.JLabel();
        cart_button = new javax.swing.JButton();
        history_page = new javax.swing.JButton();
        payment_button = new javax.swing.JButton();
        logout_button = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BingoCart");

        welcome_text.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        welcome_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome_text.setText("Hi, Mr/Ms <Customer Name>");

        cart_button.setBackground(new java.awt.Color(102, 255, 255));
        cart_button.setFont(new java.awt.Font("Fusion Pixel 10px Monospaced ja", 1, 18)); // NOI18N
        cart_button.setText("Add / Remove");
        cart_button.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cart", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 0, 24))); // NOI18N
        cart_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cart_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart_buttonActionPerformed(evt);
            }
        });

        history_page.setBackground(new java.awt.Color(102, 255, 255));
        history_page.setFont(new java.awt.Font("Fusion Pixel 10px Monospaced ja", 1, 18)); // NOI18N
        history_page.setText("Payment History");
        history_page.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 0, 24))); // NOI18N
        history_page.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        history_page.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                history_pageActionPerformed(evt);
            }
        });

        payment_button.setBackground(new java.awt.Color(102, 255, 255));
        payment_button.setFont(new java.awt.Font("Fusion Pixel 10px Monospaced ja", 1, 18)); // NOI18N
        payment_button.setText("Make Payment");
        payment_button.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Checkout", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 0, 24))); // NOI18N
        payment_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_buttonActionPerformed(evt);
            }
        });

        logout_button.setBackground(new java.awt.Color(102, 255, 255));
        logout_button.setFont(new java.awt.Font("Fusion Pixel 10px Monospaced ja", 1, 18)); // NOI18N
        logout_button.setText("Log Out");
        logout_button.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exit", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 0, 24))); // NOI18N
        logout_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cart_button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(payment_button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(history_page, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(logout_button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcome_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cart_button, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payment_button, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout_button, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(history_page, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(486, 443));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cart_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart_buttonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new customer_cart().setVisible(true);
    }//GEN-LAST:event_cart_buttonActionPerformed

    private void history_pageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_history_pageActionPerformed
        // TODO add your handling code here:
        this.dispose();
	new PaymentHistory().setVisible(true);
    }//GEN-LAST:event_history_pageActionPerformed

    private void payment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_buttonActionPerformed
        // Retrieve the cart items
	Cart.loadItem();
        ArrayList<Item> cartItems = Cart.getCartItems();

        // Check if the cart is empty
        if (Cart.isCartEmpty()) {
            JOptionPane.showMessageDialog(this, "Your cart is empty! Please add items to your cart before proceeding to payment.", "Empty Cart", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Proceed to payment
        String customerName = Customer.getUsername();
        new customer_payment(customerName, cartItems).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_payment_buttonActionPerformed

    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_buttonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Main_Page().setVisible(true);
    }//GEN-LAST:event_logout_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(Customer_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cart_button;
    private javax.swing.JButton history_page;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton logout_button;
    private javax.swing.JButton payment_button;
    private javax.swing.JLabel welcome_text;
    // End of variables declaration//GEN-END:variables
}
