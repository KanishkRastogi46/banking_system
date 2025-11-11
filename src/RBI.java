public interface RBI {
    static final double MIN_BALANCE = 5000.00;
    static final double FD_INTEREST_RATE = 3;
    static final double FD_DURATION_YEARS = 3;

    void openAccount(String bankName);
    void depositMoney(double amount, long accNumber);
    void withdrawMoney(double amount, long accNumber);
    void openFD(long accNumber);
    void applyLoan();
}
