/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Asus-win7
 * Created: 16 Sep, 2016
 */

SELECT `purchase_bill_number` FROM `purchase_bill` WHERE `purchase_bill_type`='Credit';

SELECT supplier_id,(( `purchase_bill_amount` - `purchase_bill_payed_amount`) - SUM(purchase_bill_credit.purchase_bill_credit_payed_amount)) FROM `purchase_bill`,purchase_bill_credit WHERE purchase_bill.purchase_bill_number = purchase_bill_credit.purchase_bill_number AND purchase_bill.`purchase_bill_number` = 1;

