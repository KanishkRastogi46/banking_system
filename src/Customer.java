public class Customer {
    private String custID;
    private String custName;
    private String custPhone;

    public Customer() {}
    public Customer(String name, String phone) {
        this.custName = name;
        this.custPhone = phone;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }
}
