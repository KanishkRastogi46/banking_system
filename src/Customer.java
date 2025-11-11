public class Customer {
    private int custID;
    private String custName;
    private String custPhone;
    private BankAccount custAccount;

    public Customer() {}
    public Customer(String name, String phone) {
        this.custName = name;
        this.custPhone = phone;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
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
