
package adh_pos_lab;

/**
 *
 * @author aholloway
 */
public class NoSaleStrategy implements DiscountStrategy {
    private double percentOff=0;

    @Override
    public double returnDiscount(Product product, int quantity) {
        return product.getBasePrice()*quantity*percentOff;
    }
    
}
