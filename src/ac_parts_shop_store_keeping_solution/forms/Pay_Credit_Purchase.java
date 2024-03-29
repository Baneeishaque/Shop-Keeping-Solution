/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution.forms;

import ac_parts_shop_store_keeping_solution.db.helpers.Purchase_Bill_Credit_DB;
import modules.common.Common_Tasks;
import ac_parts_shop_store_keeping_solution.db.helpers.Purchase_Bill_DB;
import ac_parts_shop_store_keeping_solution.db.helpers.Supplier_DB;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus-win7
 */
public class Pay_Credit_Purchase extends javax.swing.JFrame {

    private int supplier_combo_flag = 0;
    private int purchase_bill_no_flag = 0;

    /**
     * Creates new form Pay_Credit_Purchase
     */
    public Pay_Credit_Purchase() {
        initComponents();
        Common_Tasks.display_frame(this);
        jLabel_date.setText(Common_Tasks.return_current_date_time());
        Supplier_DB.populate_suppliers_having_unresolved_balance(jCombobox_supplier);
        supplier_combo_flag = 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCombobox_supplier = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jCombobox_purchase_bill_no = new javax.swing.JComboBox<>();
        jLabel_total_credit = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_pay_amount_text = new javax.swing.JLabel();
        jTextField_pay_amount = new javax.swing.JTextField();
        jLabel_balance_text = new javax.swing.JLabel();
        jLabel_balance = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel_balance_text1 = new javax.swing.JLabel();
        jLabel_credit_amount = new javax.swing.JLabel();
        jLabel_date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("AC Parts Shop Keeping Solution");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Pay Purchase Credit");

        jCombobox_supplier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCombobox_supplierItemStateChanged(evt);
            }
        });
        jCombobox_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCombobox_supplierActionPerformed(evt);
            }
        });

        jLabel3.setText("Supplier Name");

        jCombobox_purchase_bill_no.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCombobox_purchase_bill_noItemStateChanged(evt);
            }
        });
        jCombobox_purchase_bill_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCombobox_purchase_bill_noActionPerformed(evt);
            }
        });

        jLabel_total_credit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_total_credit.setText("0.0");

        jLabel5.setText("Purchase Bill No.");

        jLabel_pay_amount_text.setText("Pay Amount");

        jTextField_pay_amount.setMinimumSize(new java.awt.Dimension(63, 14));
        jTextField_pay_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_pay_amountKeyPressed(evt);
            }
        });

        jLabel_balance_text.setText("Balance");

        jLabel_balance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_balance.setText("0.0");

        jButton6.setText("Submit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel_balance_text1.setText("Credit Amount");

        jLabel_credit_amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_credit_amount.setText("0.0");

        jLabel_date.setText("Supplier ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(131, 131, 131)
                                            .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(185, 185, 185)
                                            .addComponent(jLabel6)))
                                    .addGap(176, 176, 176))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCombobox_purchase_bill_no, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCombobox_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel_total_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_balance_text, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_pay_amount_text, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_balance_text1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_credit_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_pay_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel_date, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombobox_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_total_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombobox_purchase_bill_no, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_balance_text1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_credit_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_pay_amount_text, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pay_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_balance_text, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCombobox_supplierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCombobox_supplierItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jCombobox_supplierItemStateChanged

    private void jCombobox_purchase_bill_noItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCombobox_purchase_bill_noItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCombobox_purchase_bill_noItemStateChanged

    private void jCombobox_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCombobox_supplierActionPerformed
        // TODO add your handling code here:
        if (supplier_combo_flag == 1) {
            Common_Tasks.debug_display(Common_Tasks.parse_string_seperated_by_symbol(jCombobox_supplier.getSelectedItem().toString(), ":").elementAt(0).toString());
            purchase_bill_no_flag = 0;
            jLabel_total_credit.setText(Purchase_Bill_DB.populate_purchase_numbers_having_unresolved_balance(jCombobox_purchase_bill_no, Common_Tasks.parse_string_seperated_by_symbol(jCombobox_supplier.getSelectedItem().toString(), ":").elementAt(0).toString()));
            purchase_bill_no_flag = 1;

        }
    }//GEN-LAST:event_jCombobox_supplierActionPerformed

    private void jTextField_pay_amountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_pay_amountKeyPressed
        // TODO add your handling code here:
        if (!jTextField_pay_amount.getText().isEmpty()) {
            jLabel_balance.setText(String.valueOf(Common_Tasks.round_double(Double.parseDouble(jLabel_credit_amount.getText()) - Double.parseDouble(jTextField_pay_amount.getText()), 2)));

        }
    }//GEN-LAST:event_jTextField_pay_amountKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String result;

        result = Purchase_Bill_Credit_DB.insert_values(new String[]{Purchase_Bill_Credit_DB.return_maximum_value_of_purchase_bill_credit_serial_number_plus("serial_number"), Common_Tasks.return_part_of_a_string_seperated_by_a_symbol(jCombobox_purchase_bill_no.getSelectedItem().toString(), " ", 0), "NOW()", jTextField_pay_amount.getText()}, new int[]{});

        if (result.equals("true")) {

            JOptionPane.showMessageDialog(rootPane, "Purchase Credit Pay Inserted Successfully");

        } else {
            JOptionPane.showMessageDialog(rootPane, "Purchase Credit Pay Insertion Failed, Reason : " + result);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jCombobox_purchase_bill_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCombobox_purchase_bill_noActionPerformed
        // TODO add your handling code here:
        if (purchase_bill_no_flag == 1) {
            jLabel_credit_amount.setText(Purchase_Bill_DB.return_balance_of_a_credit_bill(jCombobox_purchase_bill_no.getSelectedItem().toString(), " ", 4));
        }

    }//GEN-LAST:event_jCombobox_purchase_bill_noActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Pay_Credit_Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pay_Credit_Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pay_Credit_Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pay_Credit_Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pay_Credit_Purchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jCombobox_purchase_bill_no;
    private javax.swing.JComboBox<String> jCombobox_supplier;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_balance;
    private javax.swing.JLabel jLabel_balance_text;
    private javax.swing.JLabel jLabel_balance_text1;
    private javax.swing.JLabel jLabel_credit_amount;
    private javax.swing.JLabel jLabel_date;
    private javax.swing.JLabel jLabel_pay_amount_text;
    private javax.swing.JLabel jLabel_total_credit;
    private javax.swing.JTextField jTextField_pay_amount;
    // End of variables declaration//GEN-END:variables
}
