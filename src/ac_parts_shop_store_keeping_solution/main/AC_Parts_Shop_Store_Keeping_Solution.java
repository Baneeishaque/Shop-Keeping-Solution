/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution.main;

import ac_parts_shop_store_keeping_solution.forms.Daily_Expense;
import ac_parts_shop_store_keeping_solution.forms.Home;
import modules.db.DB_Common;
import java.sql.SQLException;
import modules.common.Common_Tasks;

/**
 *
 * @author Asus-win7
 */
public class AC_Parts_Shop_Store_Keeping_Solution {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        new DB_Common();
//        new Home().setVisible(true);
//        new DB_Common().convert_normal_date_to_sql_date("18-09-2016");
//Common_Tasks.parse_string_seperated_by_symbol("2016-09-18~P-3, S-Supplier2, Credit-450.0000~500.0000", "~");
        new Daily_Expense().setVisible(true);

    }

}
