/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution.db.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import modules.common.Common_Tasks;
import static modules.common.Common_Tasks.debug_display;
import modules.db.DB_Common;

/**
 *
 * @author Asus-win7
 */
public class Expense_DB {

    static String Table_name = "expense";

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
    
    public static ResultSet get_expense_ledger(String jdate)
    {
        ResultSet r = null;
        try {
            r=DB_Common.s.executeQuery("SELECT `serial_number` AS `Sl. No.`,DATE_FORMAT(`expense_date`,'%d-%m-%Y') AS Date,`expense_description` AS Particulars,`expense_amount` AS Amount FROM `expense` WHERE expense_date='"+DB_Common.convert_normal_date_to_sql_date(jdate)+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Expense_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    

   
    
    public static String return_maximum_value_of_expense_serial_number_plus(String Column) {

        return DB_Common.return_maximum_value_of_a_column_plus(Table_name, Column);

    }

    
    
    
    
    

    

}
