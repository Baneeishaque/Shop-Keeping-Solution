/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution.db.helpers;

/**
 *
 * @author Asus-win7
 */
public class DB_Configuration {

    public static final String DB_Vendor = "MySQL",
            DB_Server_Address = "localhost",
            DB_Port_Number = "3306",
            DB_Name = "ac_parts_shop_db",
            DB_User = "root",
            DB_User_Passcode = "";

    public static final String[] DB_Init_Queries_MySQL = new String[]{"DROP TABLE IF EXISTS `purchase_bill`",
        "CREATE TABLE `purchase_bill` (\n"
        + "  `purchase_bill_number` int(11) NOT NULL,\n"
        + "  `purchase_bill_date` varchar(50) NOT NULL,\n"
        + "  `supplier_id` int(11) NOT NULL,\n"
        + "  `purchase_bill_amount` decimal(13,4) NOT NULL,\n"
        + "  `purchase_bill_type` varchar(50) NOT NULL,\n"
        + "  `purchase_bill_payed_amount` decimal(13,4) NOT NULL\n"
        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8",
        "INSERT INTO `purchase_bill` (`purchase_bill_number`, `purchase_bill_date`, `supplier_id`, `purchase_bill_amount`, `purchase_bill_type`, `purchase_bill_payed_amount`) VALUES\n"
        + "(1, '16-09-2016', 1, '50.0000', 'Credit', '40.0000'),\n"
        + "(2, '16-09-2016', 2, '5.0000', 'Credit', '2.0000')"};

    public static String[] DB_Init_Queries_H2;

    public static String[] DB_Init_Queries_SQLite;
}
