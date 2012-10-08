
package adh_pos_lab;

/**
 *
 * @author aholloway
 */
public class Customer {
    //customer information: name, address
    private String custNo;
    private String name;
    private String address;

    public Customer(String custNo, String name, String address) {
        this.setCustNo(custNo);
        this.setName(name);
        this.setAddress(address);
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        //throw Exception if null or ""
        if (name==null || name ==""){
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        this.name = name;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        //throw Exception if null or ""
        if (address==null || address ==""){
            throw new IllegalArgumentException("Address cannot be null or"
                    + " blank.");
        }
        this.address = address;
    }

    public final String getCustNo() {
        return custNo;
    }

    public final void setCustNo(String custNo) {
        //throw Exception if null or ""
        if (custNo==null || custNo ==""){
            throw new IllegalArgumentException("Customer number cannot be null"
                    + " or blank.");
        }
        this.custNo = custNo;
    }
    
}
