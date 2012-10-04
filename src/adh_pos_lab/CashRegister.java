/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adh_pos_lab;

/**
 *
 * @author aholloway
 */
public class CashRegister {
    //has a product array (this will later be stored in a database)

    Product[] products = {
        new Product("500", "Baseball Hat", 19.95),
        new Product("A40", "Pez Dispenser - Shrek", 1.95),
        new Product("B24245", "Tshirt - XL - Badgers", 14.99)
    };
    //has a customer array
    Customer[] customers = {
        new Customer("Bill", "123 Onahill Drive"),
        new Customer("Sally", "99 Church Street")
    };
    //has a receipt
    //has methods to work with the receipt
    // public beginNewSale(); which creates a new blank receipt with a line
    // item array of size 0.
}
