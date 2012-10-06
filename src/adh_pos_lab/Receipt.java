
package adh_pos_lab;

import java.text.NumberFormat;

/**
 *
 * @Drew Holloway
 */
public class Receipt {

    private LineItem[] lineItems;
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    public Receipt() {
        this.beginNewTransaction();
    }

    public final void beginNewTransaction() {
        lineItems = new LineItem[0];
    }

    // Here's how to add a purchased product as a LineItem
    public final void addLineItem(Product product, int qty) {
        LineItem item = new LineItem(product, qty);
        addToArray(item);
    }

    // Since arrays are fixed in size, to add a new element you must resize
    // the array, but wait, you can't do that in Java! Well, you can fake it.
    // Here's how:
    // Create a new temporary array that's one larger than the original. Then,
    // copy all the data from the original into the temporary array.
    // Finally, add the new item to the new element in the temporary array. 
    // Then, set the original = temporary. That's it!
    private void addToArray(LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    //I ended up using this logic within the loop that prints each line out
//    public final double getTotalBeforeDiscount() {
//        double grandTotal = 0.0;
//        for (LineItem item : lineItems) {
//            grandTotal += item.getProduct().getBasePrice();
//        }
//        return grandTotal;
//    }
    
    /**
     * print method goes through each line of the receipt, calling each line
     * item in the line item array.  
     */
    public final void print() {
        //initialize local variables
        double basePrice = 0;
        int quant = 0;
        double extendedPrice = 0;
        double extendedDiscount = 0;
        double extendedDiscountedPrice = 0;

        //build these totals while adding the receipt
        double extendedBasePriceTotal = 0;
        double extendedDiscountTotal = 0;
        double extendedDiscountPriceTotal = 0;


        // header row
        System.out.println("PrdNum  Product Description   \tRegPrc\tQnt\t"
                + "ExtPrc\tExtDsc\tNetPrc");

        // goes through each line item in the receipt.
        for (LineItem item : lineItems) {

            //calculate the extended price and extended Discount (using 
            // the return discount method of the discount strategy that is
            // currently in use.  Also calculates extended Discount Price.
            basePrice = item.getProduct().getBasePrice();
            quant = item.getQuantity();
            extendedPrice = basePrice * quant;
            extendedDiscount = item.getProduct().getDiscountStrategy()
                    .returnDiscount(item.getProduct(), item.getQuantity());
            extendedDiscountedPrice = extendedPrice - extendedDiscount;

            System.out.println(
                    //formatted to line up with the header row and to use
                    //dollars where appropriate.
                    item.getProduct().getProdNum()
                    + item.getProduct().getProdDesc() + "\t"
                    + nf.format(basePrice) + "\t"
                    + quant + "\t"
                    + nf.format(extendedPrice) + "\t"
                    + nf.format(extendedDiscount) + "\t"
                    + nf.format(extendedDiscountedPrice));
            // add extended Price and extended discount to the appropriate
            // total variables.
            extendedBasePriceTotal += extendedPrice;
            extendedDiscountTotal += extendedDiscount;
        }
        //calculate extended Discount Price Total (net price after discount)
        extendedDiscountPriceTotal = extendedBasePriceTotal - 
                extendedDiscountTotal;
        //print out totals.
        System.out.println("Total before disocount:   "
                + nf.format(extendedBasePriceTotal));
        System.out.println("Total disocount:          "
                + nf.format(extendedDiscountTotal));
        System.out.println("Grand total:              "
                + nf.format(extendedDiscountPriceTotal));
    }
}
