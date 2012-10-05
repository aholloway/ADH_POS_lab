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

    private Product[] products = {
        new Product("500", "Baseball Hat", 19.95),
        new Product("A40", "Pez Dispenser - Shrek", 1.95),
        new Product("B24245", "Tshirt - XL - Badgers", 14.99)
    };
    //has a customer array
    private Customer[] customers = {
        new Customer("Bill", "123 Onahill Drive"),
        new Customer("Sally", "99 Church Street")
    };
    //has a receipt
    Receipt receipt;

    // When adding an item to a sale you need to look up the item in the database
    // Here we use the prodId to find product in the above array
    public void addItemToSale(String prodId, int qty) {
        Product product = null;
        for (Product p : products) {
            if (prodId.equals(p.getProdNum())) {
                product = p;
                break;
            }
        }

        // if found, add the lineItem to the receipt
        if (product != null) {
            receipt.addLineItem(product, qty);
        }

    }
    
    //has methods to work with the receipt.
    public void beginNewTransaction(){
        receipt = new Receipt();
    } 
    
    public void printReceipt(){
        //prints receipt with subtotals which calculate the amounts for the 
        // each line item and the subtotals and totals
        // should go through each item of the lineItem array and get the product
        // num, desc, basePrice, qty, extended price, extended discount,
        // discounted extended price
        // and then the total of all extended prices, extended discounts,
        // and the grand total discounted extended price
        
    }
    
    
}
