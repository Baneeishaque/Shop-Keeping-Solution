/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_parts_shop_store_keeping_solution;

import java.sql.SQLException;

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
        new Home().setVisible(true);
        
  
    }
    
    
    

}
