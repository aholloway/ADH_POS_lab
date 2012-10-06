package adh_pos_lab;

/**
 *
 * @Drew Holloway
 */
public class Receipt {

    private LineItem[] lineItems;

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


        for (LineItem item : lineItems) {

            basePrice = item.getProduct().getBasePrice();
            quant = item.getQuantity();
            extendedPrice = basePrice * quant;
            extendedDiscount = item.getProduct().getDiscountStrategy()
                    .returnDiscount(item.getProduct(), item.getQuantity());
            extendedDiscountedPrice = extendedPrice - extendedDiscount;

            System.out.println(
                    item.getProduct().getProdNum() + ", "
                    + item.getProduct().getProdDesc() + ", "
                    + basePrice + ", "
                    + quant + ", "
                    + extendedPrice + ", "
                    + extendedDiscount + ", "
                    + extendedDiscountedPrice);
        }
        //for each line item in the array, print
        // Here's how to loop through all the line items and get a grand total
        //create grand total
    }
}
