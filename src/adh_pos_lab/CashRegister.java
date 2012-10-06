package adh_pos_lab;

/**
 * Cash Register is the main class
 *
 * @author aholloway
 */
public class CashRegister {

    //has a product array (this will later be stored in a database)
    private Product[] products = {
        new Product("500     ", "Baseball Hat          ", 19.95),
        new Product("A40     ", "Pez Dispenser - Shrek ", 1.95),
        new Product("B24245  ", "Tshirt - XL - Badgers ", 14.99),
        new Product("597589  ", "Bicycle Chain and Lock", 12.95)
    };
    //has a customer array
    private Customer[] customers = {
        new Customer("Bill", "123 Onahill Drive"),
        new Customer("Sally", "99 Church Street")
    };
    private Receipt receipt; //set with new transaction
    private Customer currentCustomer; //set with new transaction
    private DiscountStrategy currentSale; //set in constructor.

    //constructor with no parameters sets sale stategy to NoSaleStrategy
    public CashRegister() {
        setCurrentSale(new NoSaleStrategy());
    }

    //constructor sets current sale
    public CashRegister(DiscountStrategy currentSale) {
        setCurrentSale(currentSale);
    }

    /**
     * When adding an item to a sale you need to look up the item in the
     * database. Here we use the prodId to find product in the above array
     */
    public final void addItemToSale(String prodId, int qty) {
        Product product = null;
        for (Product p : products) {
            if (prodId.equals(p.getProdNum())) {
                product = p;
                break;
            }
        }

        if (product == null) {
            throw new IllegalArgumentException("Product not found.");
        }

        receipt.addLineItem(product, qty);


    }

    //beginNewTransaction creates a new receipt and uses
    //cust name to set the customer object 
    public final void beginNewTransaction(String custName) {
        receipt = new Receipt();
        setCustomer(custName);
    }

    // private method to set customer name
    private void setCustomer(String custName) {
        Customer customer = null;
        for (Customer c : customers) {

            if (custName.equals(c.getName())) {
                // first customer we find we assume is currnet customer and
                // stop searching.
                customer = c;
                break;
            }
        }
        // if customer is not found, it will be null
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        currentCustomer = customer;

    }

    public final void printReceipt() {

        System.out.println("Thank you for shopping at Kolz Dept Store!");
        System.out.println("");
        System.out.println(currentCustomer.getName());
        System.out.println(currentCustomer.getAddress());
        System.out.println("");
        //this method prints each line item and quantity, as well as a header
        //row and the totals.
        receipt.print();

    }

    public final DiscountStrategy getCurrentSale() {
        return currentSale;
    }

    public final void setCurrentSale(DiscountStrategy currentSale) {
        if (currentSale == null) {

            throw new IllegalArgumentException("Discount Strategy cannot be "
                    + "null");
        }

        this.currentSale = currentSale;
        //apply sale to all products.
        for (Product p : products) {
            p.setDiscountStrategy(currentSale);
        }
    }
}
