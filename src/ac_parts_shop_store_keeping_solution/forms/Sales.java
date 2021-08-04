/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution.forms;

import ac_parts_shop_store_keeping_solution.db.helpers.Customer_DB;
import ac_parts_shop_store_keeping_solution.db.helpers.Sales_Bill_DB;
import ac_parts_shop_store_keeping_solution.db.helpers.Stock_DB;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import modules.common.Common_Tasks;

/**
 *
 * @author Asus-win7
 */
public class Sales extends javax.swing.JFrame {

    /**
     * Creates new form Sales
     */
    public Sales() {
        initComponents();
        Common_Tasks.display_frame(this);
        jLabel_sales_bill_no.setText(Sales_Bill_DB.return_maximum_value_of_sales_bill_number_plus("sales_bill_number"));
        Customer_DB.populate_customer(jCombobox_customer, new String[]{"customer_id", "customer_name"});
        Stock_DB.populate_item(jCombobox_item, new String[]{"stock_item_id", "stock_item_name"});
        jLabel_date.setText(Common_Tasks.return_current_date_time());
        Common_Tasks.hide_components(new JComponent[]{jLabel_pay_amount_text, jTextField_pay_amount, jLabel_balance_text, jLabel_balance});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jCombobox_item = new javax.swing.JComboBox<>();
        jLabel_item_amount = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_sale_bill = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel_total = new javax.swing.JLabel();
        jLabel_date = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCombobox_Payment_Type = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel_pay_amount_text = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel_balance_text = new javax.swing.JLabel();
        jTextbox_item_unit_price = new javax.swing.JTextField();
        jTextField_pay_amount = new javax.swing.JTextField();
        jLabel_sales_bill_no = new javax.swing.JLabel();
        jLabel_balance = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextbox_item_quantity = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jCombobox_customer = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel9.setText("Item Name");

        jCombobox_item.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCombobox_itemItemStateChanged(evt);
            }
        });

        jLabel_item_amount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_item_amount.setText("0.0");

        jTable_sale_bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sl. No.", "Customer Name", "Item ID", "Item Name", "Item Quantity", "Item Unit Price", "Item Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_sale_bill);

        jLabel10.setText("Total Amount");

        jLabel_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_total.setText("0.0");

        jLabel_date.setText("Supplier ID");

        jLabel11.setText("Payment Type");

        jCombobox_Payment_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ready", "Credit" }));
        jCombobox_Payment_Type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCombobox_Payment_TypeItemStateChanged(evt);
            }
        });

        jLabel7.setText("Item Unit Price");

        jLabel_pay_amount_text.setText("Pay Amount");

        jLabel8.setText("Item Amount");

        jLabel_balance_text.setText("Balance");

        jTextbox_item_unit_price.setMinimumSize(new java.awt.Dimension(63, 14));
        jTextbox_item_unit_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextbox_item_unit_priceKeyPressed(evt);
            }
        });

        jTextField_pay_amount.setMinimumSize(new java.awt.Dimension(63, 14));
        jTextField_pay_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_pay_amountKeyPressed(evt);
            }
        });

        jLabel_sales_bill_no.setText("Supplier ID");

        jLabel_balance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_balance.setText("0.0");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("AC Parts Shop Keeping Solution");

        jButton6.setText("Submit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setText("Customer Name");

        jButton7.setText("Remove From SalesBill");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel4.setText("Item Quantity");

        jButton8.setText("Add Customer");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel5.setText("Sales Bill No.");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Sales");

        jTextbox_item_quantity.setMinimumSize(new java.awt.Dimension(63, 14));

        jButton5.setText("Add To Sales Bill");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jCombobox_customer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCombobox_customerItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_sales_bill_no, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextbox_item_unit_price, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCombobox_item, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCombobox_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextbox_item_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_item_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_date, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel_pay_amount_text, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_pay_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_balance_text, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_total, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCombobox_Payment_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(467, 467, 467)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_sales_bill_no, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombobox_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombobox_item, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextbox_item_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_item_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextbox_item_unit_price, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCombobox_Payment_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_pay_amount_text, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_balance_text, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pay_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCombobox_itemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCombobox_itemItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCombobox_itemItemStateChanged

    private void jCombobox_Payment_TypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCombobox_Payment_TypeItemStateChanged
        if (jCombobox_Payment_Type.getSelectedIndex() == 0) {
            Common_Tasks.hide_components(new JComponent[]{jLabel_pay_amount_text, jTextField_pay_amount, jLabel_balance_text, jLabel_balance});
        } else {
            Common_Tasks.show_components(new JComponent[]{jLabel_pay_amount_text, jTextField_pay_amount, jLabel_balance_text, jLabel_balance});
        }// TODO add your handling code here:
    }//GEN-LAST:event_jCombobox_Payment_TypeItemStateChanged

    private void jTextbox_item_unit_priceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextbox_item_unit_priceKeyPressed
        // TODO add your handling code here:
        if (!jTextbox_item_unit_price.getText().isEmpty()) {
            if (jTextbox_item_quantity.getText().isEmpty()) {
                jTextbox_item_quantity.requestFocus();
            } else {
                jLabel_item_amount.setText(String.valueOf(Common_Tasks.round_double(Integer.parseInt(jTextbox_item_quantity.getText()) * Double.parseDouble(jTextbox_item_unit_price.getText()), 2)));
            }
        }
    }//GEN-LAST:event_jTextbox_item_unit_priceKeyPressed

    private void jTextField_pay_amountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_pay_amountKeyPressed
        // TODO add your handling code here:
        if (!jTextField_pay_amount.getText().isEmpty()) {
            jLabel_balance.setText(String.valueOf(Common_Tasks.round_double(Double.parseDouble(jLabel_total.getText()) - Double.parseDouble(jTextField_pay_amount.getText()), 2)));

        }
    }//GEN-LAST:event_jTextField_pay_amountKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String result;
        if (jCombobox_Payment_Type.getSelectedIndex() == 0) {
            result = Sales_Bill_DB.insert_values(new String[]{jLabel_sales_bill_no.getText(), Common_Tasks.date_from_date_time_seperated_by_space(jLabel_date.getText()), Common_Tasks.parse_string_seperated_by_full_column(jCombobox_customer.getSelectedItem().toString()).elementAt(0).toString(), jLabel_total.getText(), jCombobox_Payment_Type.getSelectedItem().toString(), jLabel_total.getText()}, new int[]{2, 5}, jTable_sale_bill);

        } else {
            result = Sales_Bill_DB.insert_values(new String[]{jLabel_sales_bill_no.getText(), Common_Tasks.date_from_date_time_seperated_by_space(jLabel_date.getText()), Common_Tasks.parse_string_seperated_by_full_column(jCombobox_customer.getSelectedItem().toString()).elementAt(0).toString(), jLabel_total.getText(), jCombobox_Payment_Type.getSelectedItem().toString(), jTextField_pay_amount.getText()}, new int[]{2, 5}, jTable_sale_bill);
        }
        if (result.equals("true")) {

            JOptionPane.showMessageDialog(rootPane, "Sale Inserted Successfully");

        } else {
            JOptionPane.showMessageDialog(rootPane, "Sale Insertion Failed, Reason : " + result);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (jTable_sale_bill.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please Select a Row");
        } else {

            Common_Tasks.remove_row_from_table_and_index_continues_column_excluding_serial_number(jTable_sale_bill, jTable_sale_bill.getSelectedRow(), 6);
            jLabel_total.setText(Common_Tasks.return_total_of_a_column_from_jTable(jTable_sale_bill, 6));
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new Customer().setVisible(true);
        Customer_DB.populate_customer(jCombobox_customer, new String[]{"customer_id", "customer_name"});
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        Common_Tasks.add_single_row_to_table(jTable_sale_bill, new String[]{Common_Tasks.return_next_serial_number(jTable_sale_bill), Common_Tasks.parse_string_seperated_by_full_column(jCombobox_customer.getSelectedItem().toString().replace(" ", "")).elementAt(1).toString(), Common_Tasks.parse_string_seperated_by_full_column(jCombobox_item.getSelectedItem().toString().replace(" ", "")).elementAt(0).toString(), Common_Tasks.parse_string_seperated_by_full_column(jCombobox_item.getSelectedItem().toString().replace(" ", "")).elementAt(1).toString(), jTextbox_item_quantity.getText(), jTextbox_item_unit_price.getText(), jLabel_item_amount.getText()});

        jLabel_total.setText(Common_Tasks.return_total_of_a_column_from_jTable(jTable_sale_bill, 6));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jCombobox_customerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCombobox_customerItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jCombobox_customerItemStateChanged

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
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jCombobox_Payment_Type;
    private javax.swing.JComboBox<String> jCombobox_customer;
    private javax.swing.JComboBox<String> jCombobox_item;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_balance;
    private javax.swing.JLabel jLabel_balance_text;
    private javax.swing.JLabel jLabel_date;
    private javax.swing.JLabel jLabel_item_amount;
    private javax.swing.JLabel jLabel_pay_amount_text;
    private javax.swing.JLabel jLabel_sales_bill_no;
    private javax.swing.JLabel jLabel_total;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_sale_bill;
    private javax.swing.JTextField jTextField_pay_amount;
    private javax.swing.JTextField jTextbox_item_quantity;
    private javax.swing.JTextField jTextbox_item_unit_price;
    // End of variables declaration//GEN-END:variables
}
