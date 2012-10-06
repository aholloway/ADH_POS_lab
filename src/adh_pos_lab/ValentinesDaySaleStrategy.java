
package adh_pos_lab;

/**
 *
 * @author aholloway
 */
public class ValentinesDaySaleStrategy implements DiscountStrategy {
    private double percentOff=.15;

    @Override
    public double returnDiscount(Product product, int quantity) {
        return product.getBasePrice()*quantity*percentOff;
    }
    
}
