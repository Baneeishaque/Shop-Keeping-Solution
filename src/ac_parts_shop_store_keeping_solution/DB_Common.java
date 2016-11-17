/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus-win7
 */
public class DB_Common {

    public static Statement s;
    public static Connection c;

    static String update_values(String Table_name, String Columns[], String[] Values, int[] Varchar_positions, String identity_column, boolean is_identity_column_varchar, String identity) {
        try {

            DB_Common.s.executeUpdate(DB_Common.Query_builder_update_values(Table_name, Columns, Values, Varchar_positions, identity_column, is_identity_column_varchar, identity));
            return "true";
        } catch (SQLException ex) {
            Logger.getLogger(DB_Common.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getLocalizedMessage();
        }
    }

    private static String Query_builder_update_values(String Table_name, String Columns[], String[] Values, int[] Varchar_positions, String identity_column, boolean is_identity_column_varchar, String identity) {
        String Query = "UPDATE `" + Table_name + "` SET ";
        String Field_value;
        if (Array_contains(Varchar_positions, 1)) {
            Field_value = "`" + Columns[0] + "`='" + Values[0] + "'";
        } else {
            Field_value = "`" + Columns[0] + "`=" + Values[0];
        }
        Query = Query + Field_value;
        for (int i = 1; i < Values.length; i++) {
            if (Array_contains(Varchar_positions, (i + 1))) {
                Field_value = "`" + Columns[i] + "`='" + Values[i] + "'";
            } else {
                Field_value = "`" + Columns[i] + "`=" + Values[i];
            }

            Query = Query + "," + Field_value;

        }
        Query = Query +Query_builder_where_condition(identity_column, is_identity_column_varchar, identity);
        Common_Tasks.debug_display(Query);
        return Query;

        //UPDATE `stock` SET `stock_item_id`=[value-1],`stock_item_name`=[value-2],`stock_item_quantity`=[value-3],`stock_item_selling_price`=[value-4],`stock_item_remarks`=[value-5] WHERE `stock_item_id`=1
        //UPDATE `stock` SET `stock_item_id`=[value-1] WHERE `stock_item_id`=1
    }

    
    
    public static String Query_builder_select_specific_values(String Table_name, String[] Columns, boolean is_with_condition,String condition_column,boolean  is_condition_column_varchar,String condition) {
        String Query = "SELECT `" + Columns[0] + "`";
        for (int i = 1; i < Columns.length; i++) {

            Query = Query + ",`" + Columns[i] + "`";

        }
        Query = Query + " FROM `" + Table_name + "`";
        if(is_with_condition)
        {
            Query = Query +Query_builder_where_condition(condition_column, is_condition_column_varchar, condition);
        
        }
//        Common_Tasks.debug_display(Query);
        return Query;
    }
    
    static String Query_builder_where_condition(String condition_column,boolean  is_condition_column_varchar,String condition)
    {
        return " WHERE `" + condition_column + "`=" + (is_condition_column_varchar ? "'" + condition + "'" : "" + condition + "");
    }
    
    public static ResultSet get_column_specific_values(String Table_name,String[] Columns,boolean is_with_condition,String condition_column,boolean  is_condition_column_varchar,String condition) {
        ResultSet r = null;
        try {
            r = DB_Common.s.executeQuery(DB_Common.Query_builder_select_specific_values(Table_name, Columns,is_with_condition,condition_column, is_condition_column_varchar, condition));
            
        } catch (SQLException ex) {
            Logger.getLogger(Stock_DB.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return r;
    }

   
    public DB_Common() throws SQLException {
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ac_parts_shop_db", "root", "");
        s = c.createStatement();
    }

    public static String Query_builder_insert_values(String Table_name, String[] Values, int[] Varchar_positions) {
        String Query = "INSERT INTO `" + Table_name + "` VALUES (";
        String Field_value;
        if (Array_contains(Varchar_positions, 1)) {
            Field_value = "'" + Values[0] + "'";
        } else {
            Field_value = Values[0];
        }
        Query = Query + Field_value;
        for (int i = 1; i < Values.length; i++) {
            if (Array_contains(Varchar_positions, (i + 1))) {
                Field_value = "'" + Values[i] + "'";
            } else {
                Field_value = Values[i];
            }

            Query = Query + "," + Field_value;

        }
        Query = Query + ")";
        return Query;
    }

    private static boolean Array_contains(int[] Varchar_positions, int Position) {
        for (int i = 0; i < Varchar_positions.length; i++) {
            if (Varchar_positions[i] == Position) {
                return true;
            }
        }
        return false;
    }

    public static String Query_builder_maximum_value_of_a_column(String Table_name, String Column) {

        return "SELECT MAX(`" + Column + "`) FROM `" + Table_name + "`";

    }

    

    public static String return_maximum_value_of_a_column_plus(String Table_name, String Column) {

        ResultSet r;
        try {

            r = DB_Common.s.executeQuery(DB_Common.Query_builder_maximum_value_of_a_column(Table_name, Column));
            r.next();
            if (r.getObject(1) == null) {
                return "1";
            } else {
                return String.valueOf(r.getInt(1) + 1);
            }

        } catch (SQLException ex) {

            Logger.getLogger(DB_Common.class.getName()).log(Level.SEVERE, null, ex);

            return "1";
        }

    }

    public static String insert_values(String Table_name, String[] Values, int[] Varchar_positions) {

        try {

            DB_Common.s.executeUpdate(DB_Common.Query_builder_insert_values(Table_name, Values, Varchar_positions));
            return "true";
        } catch (SQLException ex) {
            Logger.getLogger(DB_Common.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getLocalizedMessage();
        }

    }

}
