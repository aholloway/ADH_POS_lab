package adh_pos_lab;

/**
 *
 * @Drew Holloway
 */
public class StartUp {
    public static void main(String[] args){
        CashRegister cr=new CashRegister(new XmasSaleStrategy());
        cr.beginNewTransaction("Sally");
        cr.addItemToSale("500     ", 2);
        cr.addItemToSale("A40     ", 3);
        cr.printReceipt();
    }
}
