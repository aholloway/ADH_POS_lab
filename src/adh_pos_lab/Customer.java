/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adh_pos_lab;

/**
 *
 * @author aholloway
 */
public class Customer {
    //customer information: name, address
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.setName(name);
        this.setAddress(address);
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        //throw Exception if null or ""
        this.name = name;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        //throw Exception if null or ""
        this.address = address;
    }
    
}
