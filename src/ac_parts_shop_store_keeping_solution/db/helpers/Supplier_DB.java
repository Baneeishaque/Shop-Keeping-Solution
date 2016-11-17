/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution.db.helpers;

import modules.common.Common_Tasks;
import modules.db.DB_Common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Asus-win7
 */
public class Supplier_DB {

    static String Table_name = "supplier";

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

    public static String return_maximum_value_of_supplier_id_plus(String Column) {

        return DB_Common.return_maximum_value_of_a_column_plus(Table_name, Column);

    }

    public static void populate_supplier(JComboBox supplier,String[] Columns) {
        Common_Tasks.populate_combobox_more_than_one_column(supplier, DB_Common.get_column_specific_values(Table_name, Columns, false, "", false, ""), Columns);
        
    }
    
    public static void populate_suppliers_having_unresolved_balance(JComboBox supplier) {
        Common_Tasks.populate_combobox_by_parsing_string_with_symbol(supplier, Purchase_Bill_DB.return_suppliers_having_unresolved_balance(), "-");
        
    }
    
    
    
    

    

}
