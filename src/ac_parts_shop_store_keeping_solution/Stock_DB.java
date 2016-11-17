/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Asus-win7
 */
public class Stock_DB {

    static String Table_name = "stock";
    static String identity_column="stock_item_id";
    static boolean is_identity_column_varchar=false;

    public static String insert_values(String[] Values, int[] Varchar_positions) {

        String result=DB_Common.insert_values(Table_name, Values, Varchar_positions);
        if(result.equals("true"))
        {
            return "true";
        }
        else
        {
            return result;
        }
            

    }
    
    public static String update_values(String Columns[], String[] Values, int[] Varchar_positions, String identity) {

        String result=DB_Common.update_values(Table_name,Columns, Values, Varchar_positions,identity_column,is_identity_column_varchar,identity);
        if(result.equals("true"))
        {
            return "true";
        }
        else
        {
            return result;
        }
            

    }

    public static String return_maximum_value_of_stock_item_table_column_plus(String Column) {

        return DB_Common.return_maximum_value_of_a_column_plus(Table_name, Column);

    }
    
    public static String return_value_of_stock_item_table_column(String Column,boolean is_with_condition,String condition_column,boolean  is_condition_column_varchar,String condition,String return_value_on_error) {

        ResultSet r=DB_Common.get_column_specific_values(Table_name, new String[]{Column}, is_with_condition, condition_column, is_condition_column_varchar, condition);
        try {
            r.next();
            return r.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(Stock_DB.class.getName()).log(Level.SEVERE, null, ex);
            return return_value_on_error;
        }
        

    }
    
    

    public static void populate_item(JComboBox item,String[] Columns) {
        Common_Tasks.populate_combobox_more_than_one_column(item, DB_Common.get_column_specific_values(Table_name, Columns, false, "", false,""), Columns);
        
    }
    
    


}
