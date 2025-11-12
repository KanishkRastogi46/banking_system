import java.io.BufferedReader;

public class Hdfc extends BankOperations {
    static final double minBalance = 2000;
    static final double fdInterestRate = 5.0;
    static final int fdDurationYears = 1;

    public Hdfc(BufferedReader buff) {
        super(buff);
    }

    @Override
    public void openAccount(String bankName) {
        System.out.println("HDFC specific account opening process initiated.");
        super.openAccount(bankName);
    }

    @Override
    public void depositMoney(double amount, long accNumber, String bankName) {
        System.out.println("HDFC specific deposit process initiated.");
        super.depositMoney(amount, accNumber, bankName);
    }

    @Override
    public void withdrawMoney(double amount, long accNumber, String bankName) {
        System.out.println("HDFC specific withdrawal process initiated.");
        super.withdrawMoney(amount, accNumber, bankName);
    }

    @Override
    public void openFD(long accNumber, String bankName) {
        System.out.println("HDFC specific FD opening process initiated.");
        super.openFD(accNumber, bankName);
    }

    @Override
    public void applyLoan() {
        System.out.println("HDFC specific loan application process initiated.");
        super.applyLoan();
    }
}
