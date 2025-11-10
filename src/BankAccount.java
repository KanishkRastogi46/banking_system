public class BankAccount {
    private long accNumber;
    private double accBalance;
    private Customer accHolder;
    private Bank bank;
    private BankBranches branch;

    public BankAccount() {
        this.accBalance = 5000.00;
    }
    public BankAccount(long accNumber, double accBalance, Customer accHolder, Bank bank, BankBranches branch) {
        this.accNumber = accNumber;
        this.accBalance = accBalance;
        this.accHolder = accHolder;
        this.bank = bank;
        this.branch = branch;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public Customer getAccHolder() {
        return accHolder;
    }

    public void setAccHolder(Customer accHolder) {
        this.accHolder = accHolder;
    }

    public String getIfscCode(BankBranches branch) {
        return branch.getIfsc();
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankBranches getBranch() {
        return branch;
    }

    public void setBranch(BankBranches branch) {
        this.branch = branch;
    }
}
