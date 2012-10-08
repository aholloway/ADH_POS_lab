package adh_pos_lab;

/**
 *
 * @author aholloway
 */
public class QuantityDiscountStrategy implements DiscountStrategy {

    private double percentOff;
    private int minQuant;
    private int maxQuant;

    public QuantityDiscountStrategy(double percentOff, int minQuant, int maxQuant) {
        setPercentOff(percentOff);
        setMinQuant(minQuant);
        setMaxQuant(maxQuant);
    }

    @Override
    public final double returnDiscount(Product product, int quantity) {
        if (quantity >= minQuant && quantity <= maxQuant) {
            return product.getBasePrice() * quantity * percentOff;
        } else if (quantity > maxQuant) {
            return product.getBasePrice() * maxQuant * percentOff;
        } else {
            return 0;
        }
    }

    @Override
    public final double getPercentOff() {
        return percentOff;
    }

    @Override
    public final void setPercentOff(double percentOff) {
        //percent off cannot be negative
        this.percentOff = percentOff;
    }

    public final int getMinQuant() {
        return minQuant;
    }

    public final void setMinQuant(int minQuant) {
        //cannot be negative; must be less than or equal to maxQuant,
        // if maxQuant is set
        this.minQuant = minQuant;
    }

    public final int getMaxQuant() {
        //must be greater than minQuant if minQuant is set
        return maxQuant;
    }

    public final void setMaxQuant(int maxQuant) {
        this.maxQuant = maxQuant;
    }
}
