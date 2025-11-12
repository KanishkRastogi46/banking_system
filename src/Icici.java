import java.io.BufferedReader;

public class Icici extends BankOperations {
    static final double minBalance = 10000;
    static final double fdInterestRate = 4.0;
    static final int fdDurationYears = 2;

    public Icici(BufferedReader buff) {
        super(buff);
    }

    @Override
    public void openAccount(String bankName) {
        System.out.println("ICICI specific account opening process initiated.");
        super.openAccount(bankName);
    }

    @Override
    public void depositMoney(double amount, long accNumber, String bankName) {
        System.out.println("ICICI specific deposit process initiated.");
        super.depositMoney(amount, accNumber, bankName);
    }

    @Override
    public void withdrawMoney(double amount, long accNumber, String bankName) {
        System.out.println("ICICI specific withdrawal process initiated.");
        super.withdrawMoney(amount, accNumber, bankName);
    }

    @Override
    public void openFD(long accNumber, String bankName) {
        System.out.println("ICICI specific FD opening process initiated.");
        super.openFD(accNumber, bankName);
    }

    @Override
    public void applyLoan() {
        System.out.println("ICICI specific loan application process initiated.");
        super.applyLoan();
    }
}
