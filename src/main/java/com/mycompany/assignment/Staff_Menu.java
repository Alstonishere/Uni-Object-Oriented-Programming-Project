package com.mycompany.assignment;

import java.awt.Color;

public class Staff_Menu extends javax.swing.JFrame {
    private String staffId;
    private boolean isAdmin;

    // Constructor
    public Staff_Menu(String staffId, boolean isAdmin) {
        this.staffId = staffId;
        this.isAdmin = isAdmin;
        initComponents();
        
        welcome_text.setText("Welcome, " + staffId);
        
        // Check admin status and update button
        if (isAdmin) {
            RegisterStaff.setBackground(Color.GREEN);
        } else {
            RegisterStaff.setBackground(Color.RED);
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
        CheckCustomerInfo = new javax.swing.JButton();
        RegisterStaff = new javax.swing.JButton();
        logout_button = new javax.swing.JButton();
        report_button = new javax.swing.JButton();

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

        CheckCustomerInfo.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        CheckCustomerInfo.setText("Customer Info");
        CheckCustomerInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 10, true));
        CheckCustomerInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CheckCustomerInfo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CheckCustomerInfoStateChanged(evt);
            }
        });
        CheckCustomerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckCustomerInfoActionPerformed(evt);
            }
        });

        RegisterStaff.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        RegisterStaff.setText("Create Staff Acc");
        RegisterStaff.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 10, true));
        RegisterStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RegisterStaff.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RegisterStaffStateChanged(evt);
            }
        });
        RegisterStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterStaffActionPerformed(evt);
            }
        });

        logout_button.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        logout_button.setText("Logout");
        logout_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 10, true));
        logout_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout_button.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                logout_buttonStateChanged(evt);
            }
        });
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_buttonActionPerformed(evt);
            }
        });

        report_button.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        report_button.setText("Report");
        report_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 10, true));
        report_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        report_button.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                report_buttonStateChanged(evt);
            }
        });
        report_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                report_buttonActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegisterStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout_button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckCustomerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcome_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckCustomerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegisterStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout_button, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(516, 473));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void CheckCustomerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckCustomerInfoActionPerformed
		new IdentifyCustomer(staffId, isAdmin).setVisible(true); //Go to Customer Information Page by passing staffId and isAdmin
		this.dispose();
    }//GEN-LAST:event_CheckCustomerInfoActionPerformed

    private void CheckCustomerInfoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CheckCustomerInfoStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckCustomerInfoStateChanged

    private void RegisterStaffStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RegisterStaffStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterStaffStateChanged

    private void RegisterStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterStaffActionPerformed
        // TODO add your handling code here:
		if (isAdmin == true) { //Verify admin for permission
			new Staff_Register(staffId, isAdmin).setVisible(true);
			this.dispose();
		} else {
                    javax.swing.JOptionPane.showMessageDialog(this, "You don't have permission to create staff account", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_RegisterStaffActionPerformed

    private void logout_buttonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_logout_buttonStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_logout_buttonStateChanged

    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_buttonActionPerformed
        this.dispose();
        new Main_Page().setVisible(true);
    }//GEN-LAST:event_logout_buttonActionPerformed

    private void report_buttonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_report_buttonStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_report_buttonStateChanged

    private void report_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_report_buttonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Staff_Report(staffId, isAdmin).setVisible(true);
    }//GEN-LAST:event_report_buttonActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Staff_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Staff_Menu("DefaultUser", false).setVisible(true); // Default values for testing
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckCustomerInfo;
    private javax.swing.JButton RegisterStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton logout_button;
    private javax.swing.JButton report_button;
    private javax.swing.JLabel welcome_text;
    // End of variables declaration//GEN-END:variables
}
