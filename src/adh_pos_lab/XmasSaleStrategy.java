
package adh_pos_lab;

/**
 *
 * @author aholloway
 */
public class XmasSaleStrategy implements DiscountStrategy {
    private double percentOff=.25;

    @Override
    public double returnDiscount(Product product, int quantity) {
        return product.getBasePrice()*quantity*percentOff;
    }
    
}
