
import java.util.Date;

public class BankAccount {
    private long accNumber;
    private double accBalance;
    private Customer accHolder;
    private String bankName;
    private Date accOpenDate;

    public BankAccount() {
        this.accBalance = 5000.00;
    }
    public BankAccount(long accNumber, double accBalance, Customer accHolder, String bankName) {
        this.accNumber = accNumber;
        this.accBalance = accBalance;
        this.accHolder = accHolder;
        this.bankName = bankName;
        this.accOpenDate = new Date();
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

    public Date getAccOpenDate() {
        return accOpenDate;
    }

    public void setAccOpenDate(Date accOpenDate) {
        this.accOpenDate = accOpenDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
