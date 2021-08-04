/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution.db.helpers;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import modules.common.Common_Tasks;

import modules.db.DB_Common;
import static modules.db.DB_Common.s;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Asus-win7
 */
public class Expense_Ledger_Helper {

    public static Vector Resultset_to_customized_expense_ledger_vector_for_purchase(ResultSet rs) {
        Vector v = new Vector();
        try {
            while (rs.next()) {

                v.add(rs.getString(1) + "~" + "P-" + rs.getString(2) + ", S-" + rs.getString(3) + ", " + rs.getString(4) + "-" + rs.getString(5) + "~" + rs.getString(6));
                Common_Tasks.debug_display(v.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Common_Tasks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public static Vector Resultset_to_customized_expense_ledger_vector_for_purchase_credit(ResultSet rs) {
        Vector v = new Vector();
        try {
            while (rs.next()) {

                v.add(rs.getString(1) + "~" + "PC-" + rs.getString(2) + "~" + rs.getString(3));
                Common_Tasks.debug_display(v.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Common_Tasks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public static void init_expense_ledger(JTable jt) {
        jt.setModel(DbUtils.resultSetToTableModel(Expense_DB.get_expense_ledger(Common_Tasks.date_from_date_time_seperated_by_space(Common_Tasks.return_current_date_time()))));
        Common_Tasks.add_blank_row_to_table(jt);
        Expense_Ledger_Helper.populate_expense_table_from_purchase(jt, Common_Tasks.date_from_date_time_seperated_by_space(Common_Tasks.return_current_date_time()));
        Expense_Ledger_Helper.populate_expense_table_from_purchase_credit_pay(jt, Common_Tasks.date_from_date_time_seperated_by_space(Common_Tasks.return_current_date_time()));

        Common_Tasks.add_single_row_to_table(jt, new String[]{"", "", "Total Expense", Common_Tasks.return_total_of_a_column_from_jTable(jt, 3)});

    }

    public static void init_expense_ledger(JTable jt, String date) {
        jt.setModel(DbUtils.resultSetToTableModel(Expense_DB.get_expense_ledger(date)));
        Common_Tasks.add_blank_row_to_table(jt);
        Expense_Ledger_Helper.populate_expense_table_from_purchase(jt, date);
        Expense_Ledger_Helper.populate_expense_table_from_purchase_credit_pay(jt, date);

        Common_Tasks.add_single_row_to_table(jt, new String[]{"", "", "Total Expense", Common_Tasks.return_total_of_a_column_from_jTable(jt, 3)});

    }

    public static void populate_expense_table_from_purchase(JTable jt, String jdate) {
        try {

            vector_to_populated_table_with_serial_number(Resultset_to_customized_expense_ledger_vector_for_purchase(DB_Common.s.executeQuery("SELECT  DATE_FORMAT(`purchase_bill_date`,'%d-%m-%Y'),`purchase_bill_number`, `supplier_name`, `purchase_bill_type`, `purchase_bill_payed_amount`, `purchase_bill_amount` FROM `purchase_bill`,supplier WHERE supplier.supplier_id=purchase_bill.supplier_id AND purchase_bill.purchase_bill_date='" + DB_Common.convert_normal_date_to_sql_date(jdate) + "'")), jt, 3);

        } catch (SQLException ex) {
            Logger.getLogger(Expense_Ledger_Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void vector_to_populated_table_with_serial_number(Vector v, JTable jt, int Column_number) {
        int i = 1;
        String last_serial_number = jt.getValueAt(jt.getRowCount() - i++, 0).toString();
        while (last_serial_number.isEmpty()) {
            last_serial_number = jt.getValueAt(jt.getRowCount() - i++, 0).toString();
        }
        int j = (Integer.parseInt(last_serial_number)) + 1;
        Common_Tasks.debug_display(v);
        for (i = 0; i < v.size(); i++) {
            Common_Tasks.debug_display(v.elementAt(i));
            Common_Tasks.debug_display(Common_Tasks.parse_string_seperated_by_symbol(v.elementAt(i).toString(), "~").elementAt(0).toString());
            Common_Tasks.add_single_row_to_table(jt, new String[]{String.valueOf(j++), Common_Tasks.parse_string_seperated_by_symbol(v.elementAt(i).toString(), "~").elementAt(0).toString(), Common_Tasks.parse_string_seperated_by_symbol(v.elementAt(i).toString(), "~").elementAt(1).toString(), Common_Tasks.parse_string_seperated_by_symbol(v.elementAt(i).toString(), "~").elementAt(2).toString()});
        }
        Common_Tasks.add_blank_row_to_table(jt);

    }

    public static String vector_to_populated_table_with_serial_number_and_return_total_of_a_column(Vector v, JTable jt, int Column_number) {
        int i = 1;
        String last_serial_number = jt.getValueAt(jt.getRowCount() - i++, 0).toString();
        while (last_serial_number.isEmpty()) {
            last_serial_number = jt.getValueAt(jt.getRowCount() - i++, 0).toString();
        }
        int j = (Integer.parseInt(last_serial_number)) + 1;
        Common_Tasks.debug_display(v);
        for (i = 0; i < v.size(); i++) {
            Common_Tasks.debug_display(v.elementAt(i));
            Common_Tasks.debug_display(Common_Tasks.parse_string_seperated_by_symbol(v.elementAt(i).toString(), "~").elementAt(0).toString());
            Common_Tasks.add_single_row_to_table(jt, new String[]{String.valueOf(j++), Common_Tasks.parse_string_seperated_by_symbol(v.elementAt(i).toString(), "~").elementAt(0).toString(), Common_Tasks.parse_string_seperated_by_symbol(v.elementAt(i).toString(), "~").elementAt(1).toString(), Common_Tasks.parse_string_seperated_by_symbol(v.elementAt(i).toString(), "~").elementAt(2).toString()});
        }
        Common_Tasks.add_blank_row_to_table(jt);
        return Common_Tasks.return_total_of_a_column_from_jTable(jt, Column_number);
    }

    public static void populate_expense_table_from_purchase_credit_pay(JTable jt, String jdate) {
        try {

            vector_to_populated_table_with_serial_number(Resultset_to_customized_expense_ledger_vector_for_purchase_credit(DB_Common.s.executeQuery("SELECT  DATE_FORMAT(`purchase_bill_credit_pay_date`,'%d-%m-%Y'),`purchase_bill_number`, `purchase_bill_credit_payed_amount` FROM `purchase_bill_credit`,supplier WHERE purchase_bill_credit.purchase_bill_credit_pay_date='" + DB_Common.convert_normal_date_to_sql_date(jdate) + "'")), jt, 3);

        } catch (SQLException ex) {
            Logger.getLogger(Expense_Ledger_Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void populate_date_combo_box(JComboBox jc) {
        Vector v = new Vector();
        try {
            v = Common_Tasks.Resultset_to_vector(DB_Common.s.executeQuery("SELECT DISTINCT `expense_date` FROM `expense`"));
            v.addAll(Common_Tasks.Resultset_to_vector(DB_Common.s.executeQuery("SELECT DISTINCT purchase_bill.purchase_bill_date FROM purchase_bill")));
            v.addAll(Common_Tasks.Resultset_to_vector(DB_Common.s.executeQuery("SELECT DISTINCT purchase_bill_credit.purchase_bill_credit_pay_date FROM purchase_bill_credit")));
            Common_Tasks.populate_combobox_from_vector(jc, v);
        } catch (SQLException ex) {
            Logger.getLogger(Expense_Ledger_Helper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
