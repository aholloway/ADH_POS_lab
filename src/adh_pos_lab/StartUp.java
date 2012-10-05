package adh_pos_lab;

/**
 *
 * @Drew Holloway
 */
public class StartUp {
    public static void main(String[] args){
        CashRegister cr=new CashRegister();
        cr.beginNewTransaction();
        cr.addItemToSale("500", 2);
        //cr.print
    }
}
