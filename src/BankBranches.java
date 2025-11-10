import java.util.TreeMap;

public class BankBranches {
    private String branchName;
    private String ifsc;
    private Bank bank;
    private BranchManager branchManager;
    private static final TreeMap<Integer, Customer> customers = new TreeMap<>();
    private static final TreeMap<Long, BankAccount> accounts = new TreeMap<>();
    private Atm atm;

    public BankBranches(String name) {}
    public BankBranches(Bank bank, String branchName, String code) {
        this.bank = bank;
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

    public static TreeMap<Integer, Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(Customer customer) {
        customers.put(customer.getCustID(), customer);
    }

    public Atm getAtm() {
        return atm;
    }

    public static TreeMap<Long, BankAccount> getAccounts() {
        return accounts;
    }

    public static BankAccount getAccountByAccNumber(long accNumber) {
        if (accounts != null) {
            for (long account : accounts.keySet()) {
                if (account == accNumber) {
                    return accounts.get(account);
                }
            }
        }
        return null;
    }

    public static void setAccounts(BankAccount account) {
        accounts.put(account.getAccNumber(), account);
    }
}
