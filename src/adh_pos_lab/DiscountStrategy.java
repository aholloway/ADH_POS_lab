
package adh_pos_lab;

/**
 *
 * @author aholloway
 */
public interface DiscountStrategy {
    /**
     * a discount strategy object should take the price, the quantity, and then
     * throw it together with the percent off (and any additional logic)
     * to calculate the discount.
     *
     */
    public double returnDiscount(Product product,int quantity);
}
