package ac_parts_shop_store_keeping_solution;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dk-dual-core-s3-win7
 */
public class Common_Tasks {

    public static void hide_components(JComponent jc[]) {
        for (JComponent jc1 : jc) {
            jc1.setVisible(false);
        }
    }

    public static void show_components(JComponent jc[]) {
        for (JComponent jc1 : jc) {
            jc1.setVisible(true);
        }
    }

    public static Vector Resultset_to_vector(ResultSet rs) {
        Vector v = new Vector();
        try {
            while (rs.next()) {
                v.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Common_Tasks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public static String return_current_date() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy  hh:mm a"));
    }

    public static void display_frame(JFrame jf) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setLocation(dim.width / 2 - jf.getSize().width / 2, dim.height / 2 - jf.getSize().height / 2);
    }

    public static void populate_combobox_by_parsing_string_with_symbol(JComboBox jc, String raw, String symbol) {
        jc.removeAllItems();
        debug_display(raw);
        String[] collection = raw.split(symbol);
        for (String collection1 : collection) {
            jc.addItem(collection1);
        }
    }

    public static void populate_combobox_more_than_one_column(JComboBox jc, ResultSet r, String[] Columns) {
        jc.removeAllItems();
        try {
            while (r.next()) {
                String Item = r.getString(1);
                for (int i = 1; i < Columns.length; i++) {

                    Item = Item + " : " + r.getString(i + 1);

                }
                jc.addItem(Item);
            }
            jc.setSelectedIndex(-1);

        } catch (SQLException ex) {
            Logger.getLogger(Supplier_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void add_single_row_to_table(JTable jt, String[] row) {
        DefaultTableModel m = (DefaultTableModel) jt.getModel();
        m.addRow(row);
    }

    public static void remove_single_row_from_table(JTable jt, int row_position) {
        DefaultTableModel m = (DefaultTableModel) jt.getModel();
        m.removeRow(row_position);
    }

    public static Vector parse_string_seperated_by_full_column(String raw) {
        return parse_string_seperated_by_symbol(raw, ":");
    }

    public static Vector parse_string_seperated_by_symbol(String raw, String symbol) {
        Vector result = new Vector();
//        System.out.println(raw);
        while (raw.contains(symbol)) {
//            System.out.println(raw);
            result.add(raw.substring(0, raw.indexOf(symbol)));
//            System.out.println(result.toString());
            raw = raw.substring(raw.indexOf(symbol) + 1);
//            System.out.println(raw);
        }
        result.add(raw);
        return result;
    }

    public static String return_next_serial_number(JTable jt) {
        if (jt.getRowCount() == 0) {
            return "1";
        } else {
            return String.valueOf(Integer.parseInt(jt.getValueAt(jt.getRowCount() - 1, 0).toString()) + 1);
        }
    }

    public static String return_total_of_a_column_from_jTable(JTable jt, int Column_number) {
        double Sum = 0;
        for (int i = 0; i < jt.getRowCount(); i++) {
            Sum = Sum + Double.parseDouble(jt.getValueAt(i, Column_number).toString());
            //System.out.println(jt.getValueAt(i, Column_number).toString());
        }
        return String.valueOf(round_double(Sum, 2));
    }

    public static double round_double(double value, int places) {
        return new BigDecimal(value).setScale(places, RoundingMode.HALF_UP).doubleValue();
    }

    public static void remove_row_from_table_and_index_continues_column_excluding_serial_number(JTable jt, int selectedRow, int upto_column_number) {

        Vector table_data = new Vector();

        for (int i = 0; i < jt.getRowCount(); i++) {

            if (i != jt.getSelectedRow()) {

                String table_data_string = jt.getValueAt(i, 1).toString();
                debug_display(jt.getValueAt(i, 1).toString());
                for (int j = 2; j <= upto_column_number; j++) {
                    debug_display(jt.getValueAt(i, j).toString());
                    table_data_string = table_data_string + ":" + jt.getValueAt(i, j).toString();
                }
                debug_display(table_data_string);
                table_data.add(table_data_string);
                debug_display(table_data.toString());

            }

        }

        while (jt.getRowCount() != 0) {
            Common_Tasks.remove_single_row_from_table(jt, 0);
        }

        for (int i = 0; i < table_data.size(); i++) {
            debug_display(Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).toString());
            debug_display(Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(0).toString());
            debug_display(Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(1).toString());
            debug_display(Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(2).toString());
            debug_display(Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(3).toString());
            debug_display(Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(4).toString());
            debug_display(Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(5).toString());
            Vector table_row = new Vector();
            table_row.add(String.valueOf(i + 1));
            for (int j = 0; j < upto_column_number; j++) {
                table_row.add(Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(j).toString());
            }
            debug_display(table_row.toString());
            Common_Tasks.add_single_row_to_table(jt, table_row);
//            Common_Tasks.add_single_row_to_table(jTable_purchase_bill, new String[]{String.valueOf(i + 1), Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(0).toString(), Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(1).toString(), Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(2).toString(), Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(3).toString(), Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(4).toString(), Common_Tasks.parse_string_seperated_by_full_column(table_data.elementAt(i).toString()).elementAt(5).toString()});
        }
    }

    public static void debug_display(String raw) {
        System.out.println(raw);
    }

    public static void add_single_row_to_table(JTable jt, Vector table_row) {
        DefaultTableModel m = (DefaultTableModel) jt.getModel();
        m.addRow(table_row);
    }

    public static String date_from_date_time_seperated_by_space(String date_time) {
        return parse_string_seperated_by_symbol(date_time, " ").elementAt(0).toString();
    }
}
