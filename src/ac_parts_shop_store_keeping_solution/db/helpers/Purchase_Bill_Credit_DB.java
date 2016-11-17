/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution.db.helpers;

import modules.db.DB_Common;

/**
 *
 * @author Asus-win7
 */
public class Purchase_Bill_Credit_DB {

    static String Table_name = "purchase_bill_credit";

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

    public static String return_maximum_value_of_purchase_bill_credit_serial_number_plus(String Column) {

        return DB_Common.return_maximum_value_of_a_column_plus(Table_name, Column);

    }


}
