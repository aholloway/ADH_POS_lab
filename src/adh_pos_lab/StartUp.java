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
        cr.beginNewTransaction("2423");
        cr.addItemToSale("500     ", 2);
        cr.addItemToSale("B24245  ", 3);
        cr.printReceipt();
        
        System.out.println("");
        cr.beginNewTransaction("1");
        cr.addItemToSale("A40     ", 6);
        cr.addItemToSale("597589  ",1);
        cr.printReceipt();
        
        //Test the quantity Discount Strategy
        System.out.println("");
        cr.beginNewTransaction("1");
        cr.addItemToSale("A40     ",1);
        cr.addItemToSale("A40     ",7);
        cr.printReceipt();
        //seems to work!
                
    }
}
