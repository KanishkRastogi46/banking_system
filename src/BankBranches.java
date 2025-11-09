import java.util.ArrayList;

public class BankBranches extends Bank {
    private String branchName;
    private String ifsc;
    private Bank bank;
    private BranchManager branchManager;
    private ArrayList<Customer> customers;
    private Atm atm;

    public BankBranches(String name) {
        super(name);
    }
    public BankBranches(String bankName, String branchName, String code) {
        super(bankName);
        this.branchName = branchName;
        this.ifsc = code;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public Bank getBank() {
        return bank;
    }

    public BranchManager getBranchManager() {
        return branchManager;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customer) {
        if (this.customers == null) {
            this.customers = new ArrayList<>();
        }
        this.customers.add(customer);
    }

    public Atm getAtm() {
        return atm;
    }
}
