/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution.db.helpers;

import modules.common.Common_Tasks;
import modules.db.DB_Common;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Asus-win7
 */
public class Purchase_Bill_DB {

    static String Table_name = "purchase_bill";

    public static String insert_values(String[] Values, int[] Varchar_positions, JTable jt) {

        String result = DB_Common.insert_values(Table_name, Values, Varchar_positions);
        if (result.equals("true")) {
            for (int i = 0; i < jt.getRowCount(); i++) {
                String Purchase_Item_DB_next_insert_serial_number = Purchase_Item_DB.return_maximum_value_of_purchase_item_serial_number_plus("serial_number");
                result = Purchase_Item_DB.insert_values(new String[]{Purchase_Item_DB_next_insert_serial_number, Values[0], jt.getValueAt(i, 2).toString(), jt.getValueAt(i, 4).toString(), jt.getValueAt(i, 5).toString(), jt.getValueAt(i, 6).toString()}, new int[]{});
                if (!result.equals("true")) {
                    return result;
                } else {
                    result = Stock_DB.update_values(new String[]{"stock_item_quantity", "stock_item_remarks"}, new String[]{String.valueOf(Integer.parseInt(Stock_DB.return_value_of_stock_item_table_column("stock_item_quantity", true, "stock_item_id", false, jt.getValueAt(i, 2).toString(), "0")) + Integer.parseInt(jt.getValueAt(i, 4).toString())), Stock_DB.return_value_of_stock_item_table_column("stock_item_remarks", true, "stock_item_id", false, jt.getValueAt(i, 2).toString(), "") + "-p" + Purchase_Item_DB_next_insert_serial_number + ""}, new int[]{2}, jt.getValueAt(i, 2).toString());
                    if (!result.equals("true")) {
                        return result;
                    }
                }
            }

            return "true";
        } else {
            return result;
        }

    }

    public static String return_maximum_value_of_purchase_bill_number_plus(String Column) {

        return DB_Common.return_maximum_value_of_a_column_plus(Table_name, Column);

    }

    public static Vector return_credit_purchase_bill_numbers() {
        return Common_Tasks.Resultset_to_vector(DB_Common.get_column_specific_values(Table_name, new String[]{"purchase_bill_number"}, true, "purchase_bill_type", true, "Credit"));
    }

    public static Vector return_credit_purchase_bill_numbers_for_a_supplier(String supplier) {
        Vector v = null;
        try {
            v = Common_Tasks.Resultset_to_vector(DB_Common.s.executeQuery("SELECT `purchase_bill_number`FROM `purchase_bill` WHERE `purchase_bill_type`='Credit' AND `supplier_id`=" + supplier + ""));
        } catch (SQLException ex) {
            Logger.getLogger(Purchase_Bill_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public static String return_suppliers_having_unresolved_balance() {

        String result = "";
        Vector r = return_credit_purchase_bill_numbers();
        for (int i = 0; i < r.size(); i++) {
            try {
                ResultSet r2 = DB_Common.s.executeQuery("SELECT purchase_bill.supplier_id,`supplier_name`,(( `purchase_bill_amount` - `purchase_bill_payed_amount`) - SUM(purchase_bill_credit.purchase_bill_credit_payed_amount)) FROM `purchase_bill`,purchase_bill_credit,supplier WHERE purchase_bill.purchase_bill_number = purchase_bill_credit.purchase_bill_number AND purchase_bill.supplier_id=supplier.supplier_id AND purchase_bill.`purchase_bill_number` = " + r.elementAt(i).toString() + "");
                r2.next();

                Common_Tasks.debug_display(r2.getDouble(3));
                Common_Tasks.debug_display(r2.getObject(3));
                if ((r2.getDouble(3) != 0.0) || (r2.getObject(3) == null)) {

                    result = result + "-" + r2.getString(1) + ":" + r2.getString(2);

                    Common_Tasks.debug_display(result);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Purchase_Bill_DB.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        Common_Tasks.debug_display(result);
        return result;
    }

    public static String return_purchase_bill_numbers_having_unresolved_balance_for_a_supplier(String supplier) {

        String result = "";
        Vector r = return_credit_purchase_bill_numbers_for_a_supplier(supplier);
        for (int i = 0; i < r.size(); i++) {
            try {
                ResultSet r2 = DB_Common.s.executeQuery("SELECT purchase_bill.`purchase_bill_number`,`purchase_bill_date`,(( `purchase_bill_amount` - `purchase_bill_payed_amount`) - SUM(purchase_bill_credit.purchase_bill_credit_payed_amount)),( `purchase_bill_amount` - `purchase_bill_payed_amount`) FROM `purchase_bill`,purchase_bill_credit WHERE purchase_bill.purchase_bill_number = purchase_bill_credit.purchase_bill_number AND purchase_bill.`purchase_bill_number` = " + r.elementAt(i).toString() + "");
                r2.next();
//                Common_Tasks.debug_display(r2.getString(3));
//                Common_Tasks.debug_display(r2.getDouble(3));

                String balance;
                if ((r2.getString(3) == null) || (r2.getString(3).trim().isEmpty())) {
                    Common_Tasks.debug_display("Null");
                    balance = r2.getString(4);

                } else {

                    balance = r2.getString(3);
                }
                Common_Tasks.debug_display(balance);

                result = result + "~" + r2.getString(1) + "  " + r2.getString(2) + "  " + balance;

            } catch (SQLException ex) {
                Logger.getLogger(Purchase_Bill_DB.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        Common_Tasks.debug_display(result);
        return result;
    }

    public static String populate_purchase_numbers_having_unresolved_balance(JComboBox purchase_numbers, String supplier) {

        Common_Tasks.populate_combobox_by_parsing_string_with_symbol(purchase_numbers, Purchase_Bill_DB.return_purchase_bill_numbers_having_unresolved_balance_for_a_supplier(supplier), "~");

        return Common_Tasks.return_sum_of_a_part_from_combo_box_collection_items_seperated_by_a_symbol(purchase_numbers, " ", 4);

    }

    public static String return_balance_of_a_credit_bill(String credit_bill_details, String symbol, int position) {

        return Common_Tasks.return_part_of_a_string_seperated_by_a_symbol(credit_bill_details, symbol, position);
    }

}
