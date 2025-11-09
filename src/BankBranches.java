import java.util.ArrayList;

public class BankBranches extends Bank {
    private String branchName;
    private String ifsc;
    private Bank bank;
    private BranchManager branchManager;
    private static ArrayList<Customer> customers;
    private static ArrayList<BankAccount> accounts;
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

    public static void setCustomers(Customer customer) {
        if (customers == null) {
            customers = new ArrayList<>();
        }
        customers.add(customer);
    }

    public Atm getAtm() {
        return atm;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public static BankAccount getAccountByAccNumber(long accNumber) {
        if (accounts != null) {
            for (BankAccount account : accounts) {
                if (account.getAccNumber() == accNumber) {
                    return account;
                }
            }
        }
        return null;
    }

    public void setAccounts(BankAccount account) {
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        accounts.add(account);
    }
}
