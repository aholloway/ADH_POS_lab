package adh_pos_lab;

/**
 *
 * @Drew Holloway
 */
public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        setProduct(product);
        setQuantity(quantity);
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        //product cannot be null
        this.product = product;
    }

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) {
        //quantity cannot be negative
        this.quantity = quantity;
    }
    
    
}
