
import java.io.BufferedReader;

public class Axis extends BankOperations {
    static final double minBalance = 1000;
    static final double fdInterestRate = 4.5;
    static final int fdDurationYears = 3;

    public Axis(BufferedReader buff) {
        super(buff);
    }

    @Override
    public void openAccount(String bankName) {
        System.out.println("AXIS specific account opening process initiated.");
        super.openAccount(bankName);
    }

    @Override
    public void depositMoney(double amount, long accNumber, String bankName) {
        System.out.println("AXIS specific deposit process initiated.");
        super.depositMoney(amount, accNumber, bankName);
    }

    @Override
    public void withdrawMoney(double amount, long accNumber, String bankName) {
        System.out.println("AXIS specific withdrawal process initiated.");
        super.withdrawMoney(amount, accNumber, bankName);
    }

    @Override
    public void openFD(long accNumber, String bankName) {
        System.out.println("AXIS specific FD opening process initiated.");
        super.openFD(accNumber, bankName);
    }

    @Override
    public void applyLoan() {
        System.out.println("AXIS specific loan application process initiated.");
        super.applyLoan();
    }
}
