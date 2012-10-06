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
        //nf = NumberFormat.getCurrencyInstance();
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
    // the array, but wait, you can't do that in Java! Well, you can fake it. Here's how:
    // Create a new temporary array that's one larger than the original. Then,
    // copy all the data from the original into the temporary array.
    // Finally, add the new item to the new element in the temporary array. Then,
    // set the original = temporary. That's it!
    private void addToArray(LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    public final double getTotalBeforeDiscount() {
        double grandTotal = 0.0;
        for (LineItem item : lineItems) {
            grandTotal += item.getProduct().getBasePrice();
        }
        return grandTotal;
    }

    public void print() {
        double basePrice = 0;
        int quant = 0;
        double extendedPrice = 0;
        double extendedDiscount = 0;
        double extendedDiscountedPrice = 0;
        
        //build these totals while adding the receipt
        double extendedBasePriceTotal=0;
        double extendedDiscountTotal=0;
        double extendedDiscountPriceTotal=0;
                
        
        
        System.out.println("PrdNum  Product Description   \tRegPrc\tQnt\t"
                + "ExtPrc\tExtDsc\tNetPrc");

        for (LineItem item : lineItems) {

            basePrice = item.getProduct().getBasePrice();
            quant = item.getQuantity();
            extendedPrice = basePrice * quant;
            extendedDiscount = item.getProduct().getDiscountStrategy()
                    .returnDiscount(item.getProduct(), item.getQuantity());
            extendedDiscountedPrice = extendedPrice - extendedDiscount;

            System.out.println(
                    //ideally this would be better formatted.
                    item.getProduct().getProdNum()  
                    + item.getProduct().getProdDesc() + "\t" 
                    + nf.format(basePrice) + "\t"
                    + quant + "\t"
                    + nf.format(extendedPrice) + "\t"
                    + nf.format(extendedDiscount) + "\t"
                    + nf.format(extendedDiscountedPrice));
            extendedBasePriceTotal+=extendedPrice;
            extendedDiscountTotal+=extendedDiscount;
        }
        extendedDiscountPriceTotal=extendedBasePriceTotal-extendedDiscountTotal;
        System.out.println("Total before disocount:   "+
                nf.format(extendedBasePriceTotal));
        System.out.println("Total disocount:          "+
                nf.format(extendedDiscountTotal));
        System.out.println("Grand total:              "+
                nf.format(extendedDiscountPriceTotal));
    }
}
