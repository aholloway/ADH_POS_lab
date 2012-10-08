
package adh_pos_lab;

/**
 *
 * @author aholloway
 */
public class PercentOffDiscountStrategy implements DiscountStrategy {
    private double percentOff;
    
    public PercentOffDiscountStrategy(double percentOff){
        this.setPercentOff(percentOff);
    }
  
    
    @Override
    public final double returnDiscount(Product product, int quantity) {
        return product.getBasePrice()*quantity*percentOff;
    }

    public final double getPercentOff() {
        return percentOff;
    }

    public final void setPercentOff(double percentOff) {
        //percent off should be positive.
        this.percentOff = percentOff;
    }
    
}
