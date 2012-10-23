package adh_pos_lab;

import java.util.*;

/**
 * Cash Register is the main class
 *
 * @author aholloway
 */
public class CashRegister {

    private Map<String, Product> products;
    private Map<String, Customer> customers;
    private Receipt receipt; //set with new transaction
    private Customer currentCustomer; //set with new transaction

    public CashRegister() {
        Product p1 = new Product("500     ", "Baseball Hat          ", 19.95,
                new PercentOffDiscountStrategy(.15));
        Product p2 = new Product("A40     ", "Pez Dispenser - Shrek ", 1.95,
                new QuantityDiscountStrategy(.10, 2, 6));
        Product p3 = new Product("B24245  ", "Tshirt - XL - Badgers ", 14.99,
                new PercentOffDiscountStrategy(0));
        Product p4 = new Product("597589  ", "Bicycle Chain and Lock", 12.95,
                new PercentOffDiscountStrategy(.25));

        products.put(p1.getProdNum(), p1);
        products.put(p2.getProdNum(), p2);
        products.put(p3.getProdNum(), p3);
        products.put(p4.getProdNum(), p4);

        Customer c1 = new Customer("1", "Bill", "123 Onahill Drive");
        Customer c2 = new Customer("2423", "Sally", "99 Church Street");
        
        customers.put(c1.getCustNo(), c1);
        customers.put(c2.getCustNo(), c2);

    }

    /**
     * When adding an item to a sale you need to look up the item in the
     * database. Here we use the prodId to find product in the above array
     */
    public final void addItemToSale(String prodId, int qty) {
        Product product = null;
        ArrayList<Product> productList = new ArrayList<>(products.values());
        
        for (Product p : productList) {
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
    private void setCustomer(String custNo) {
        Customer customer = null;
        ArrayList<Customer> customerList = new ArrayList<>(customers.values());
        
        for (Customer c : customerList) {

            if (custNo.equals(c.getCustNo())) {
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
}
