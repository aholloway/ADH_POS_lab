package adh_pos_lab;

/**
 * method to use cash register
 * All cash register needs to know is the current sale strategy (set in 
 * constructor or changed at runtime as demonstrated below
 * 
 * @Drew Holloway
 */
public class StartUp {
    public static void main(String[] args){
        CashRegister cr=new CashRegister();
        cr.beginNewTransaction("Sally");
        cr.addItemToSale("500     ", 2);
        cr.addItemToSale("B24245  ", 3);
        cr.printReceipt();
        
        System.out.println("");
        cr.beginNewTransaction("Bill");
        cr.addItemToSale("A40     ", 6);
        cr.addItemToSale("597589  ",1);
        cr.printReceipt();
             
        //bad code causes errors.  
        // currently it is legal for the strategy to be swapped at the 
        // register.  But this would be nice if there were coupons involved
        // that gave a certain amount off the purchase.
        System.out.println("");
        //cr.beginNewTransaction("Bob");  //Bob is not a customer
        //cr.addItemToSale("X", 6);  //"X" is not a recognized product  
        //cr.addItemToSale("A40     ", -2); //-2 is not a valid quantity.
        cr.printReceipt();
                
    }
}
