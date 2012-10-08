
package adh_pos_lab;

/**
 *
 * @author aholloway
 */
public class Product {
    //has properties product#, product description and basePrice, and discount
    // strategy properties.
    //

    private String prodNum;
    private String prodDesc;
    private double basePrice;
    private DiscountStrategy discountStrategy;

    public Product(String prodNum, String prodDesc, double basePrice,
            DiscountStrategy discountStrategy) {
        this.setProdNum(prodNum);
        this.setProdDesc(prodDesc);
        this.setBasePrice(basePrice);
        this.setDiscountStrategy(discountStrategy);
    }

    public final String getProdNum() {
        return prodNum;
    }

    public final void setProdNum(String prodNum) {
        //throw Exception if null or ""
        if (prodNum==null || prodNum==""){
            throw new IllegalArgumentException("Prodcut Num cannot be null "
                    + "or blank");
        }
        this.prodNum = prodNum;
    }

    public final String getProdDesc() {
        return prodDesc;
    }

    public final void setProdDesc(String prodDesc) {
        //throw Exception if null or ""
        if (prodDesc==null || prodDesc==""){
            throw new IllegalArgumentException("Prodcut Desc cannot be null "
                    + "or blank");
        }
        this.prodDesc = prodDesc;
    }

    public final double getBasePrice() {
        return basePrice;
    }

    public final void setBasePrice(double basePrice) {
        //throw Exception if < 0
        if (basePrice<0){
            throw new IllegalArgumentException("Base price must be 0 or greater"
                    + ".");
        }
        this.basePrice = basePrice;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(DiscountStrategy discountStrategy) {
        //cannot be null
        if (discountStrategy==null){
            throw new IllegalArgumentException("Discount Strategy cannot be"
                    + "null.");
        }
        this.discountStrategy = discountStrategy;
    }
}
