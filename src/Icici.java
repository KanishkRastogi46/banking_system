import java.io.BufferedReader;

public class Icici extends BankOperations {
    public Icici(BufferedReader buff) {
        super(buff);
    }

    @Override
    public void openAccount(String bankName) {
        System.out.println("ICICI specific account opening process initiated.");
        super.openAccount(bankName);
    }

    @Override
    public void depositMoney(double amount, long accNumber) {
        System.out.println("ICICI specific deposit process initiated.");
        super.depositMoney(amount, accNumber);
    }

    @Override
    public void withdrawMoney(double amount, long accNumber) {
        System.out.println("ICICI specific withdrawal process initiated.");
        super.withdrawMoney(amount, accNumber);
    }

    @Override
    public void openFD(long accNumber) {
        System.out.println("ICICI specific FD opening process initiated.");
        super.openFD(accNumber);
    }

    @Override
    public void applyLoan() {
        System.out.println("ICICI specific loan application process initiated.");
        super.applyLoan();
    }
}
