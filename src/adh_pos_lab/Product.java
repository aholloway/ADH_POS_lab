/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adh_pos_lab;

/**
 *
 * @author aholloway
 */
public class Product {
    //has properties product#, product description and basePrice

    private String prodNum;
    private String prodDesc;
    private double basePrice;

    public Product(String prodNum, String prodDesc, double basePrice) {
        this.setProdNum(prodNum);
        this.setProdDesc(prodDesc);
        this.setBasePrice(basePrice);
    }

    public final String getProdNum() {
        return prodNum;
    }

    public final void setProdNum(String prodNum) {
        //throw Exception if null or ""
        this.prodNum = prodNum;
    }

    public final String getProdDesc() {
        return prodDesc;
    }

    public final void setProdDesc(String prodDesc) {
        //throw Exception if null or ""
        this.prodDesc = prodDesc;
    }

    public final double getBasePrice() {
        return basePrice;
    }

    public final void setBasePrice(double basePrice) {
        //throw Exception if < 0
        this.basePrice = basePrice;
    }
}
