
import java.io.BufferedReader;

public class Hsbc extends BankOperations {
    public Hsbc(BufferedReader buff) {
        super(buff);
    }

    @Override
    public void openAccount(String bankName) {
        System.out.println("HSBC specific account opening process initiated.");
        super.openAccount(bankName);
    }

    @Override
    public void depositMoney(double amount, long accNumber) {
        System.out.println("HSBC specific deposit process initiated.");
        super.depositMoney(amount, accNumber);
    }

    @Override
    public void withdrawMoney(double amount, long accNumber) {
        System.out.println("HSBC specific withdrawal process initiated.");
        super.withdrawMoney(amount, accNumber);
    }

    @Override
    public void openFD(long accNumber) {
        System.out.println("HSBC specific FD opening process initiated.");
        super.openFD(accNumber);
    }

    @Override
    public void applyLoan() {
        System.out.println("HSBC specific loan application process initiated.");
        super.applyLoan();
    }
}
