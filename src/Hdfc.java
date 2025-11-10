import java.io.BufferedReader;
import java.util.ArrayList;

public class Hdfc extends Bank {
    BufferedReader buff;
    private static final ArrayList<BankBranches> branches = new ArrayList<>();

    public Hdfc() {
        super("HDFC");
    }
    public Hdfc(BufferedReader buff) {
        super("HDFC");
        this.buff = buff;
    }

    @Override
    public void openAccount(String branchName) {
        long aadharNumber;
        String panNumber, phoneNumber;

        System.out.println("Following deatils are required to create a new bank account:");
        System.out.println("Aadhar card number, PAN card number and phone number");

        try {
            System.out.println("Please enter your name: ");
            String custName = this.buff.readLine();

            System.out.println("Enter your aadhar card number: ");
            String aadhar = this.buff.readLine();
            aadharNumber = Long.parseLong(aadhar);

            System.out.println("Enter your PAN card number: ");
            panNumber = this.buff.readLine();
            
            System.out.println("Enter your phone number: ");
            phoneNumber = this.buff.readLine();

            // Validate customer details
            boolean areDetailsCorrect = Helper.validateCustomer(Long.toString(aadharNumber), panNumber, phoneNumber);
            if (!areDetailsCorrect) {
                System.out.println("Account creation failed due to invalid details!!");
                return;
            }

            Bank bank = new Hdfc();
            StringBuilder ifsc = Helper.generateIfsc("HDFC");
            BankBranches bankBranch = new BankBranches(bank, branchName, ifsc.toString());
            bank.addBranch(bankBranch);

            Customer newCustomer = new Customer();
            BankAccount newAccount = new BankAccount();
            newCustomer.setCustID(Integer.parseInt(Helper.generateCustomerID(branchName).toString()));
            newCustomer.setCustName(custName);
            newCustomer.setCustPhone(phoneNumber);
            newAccount.setAccNumber(Helper.generateAccNumber());
            newAccount.setAccHolder(newCustomer);
            BankBranches.setCustomers(newCustomer);
            BankBranches.setAccounts(newAccount);

            System.out.println("Congratulations!! " + custName + " Your account has been created successfully in HDFC bank and your account number is " + newAccount.getAccNumber());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void depositMoney(double amount, long accNumber) {
        BankAccount account = BankBranches.getAccountByAccNumber(accNumber);
        if (account != null) {
            double currentBalance = account.getAccBalance();
            account.setAccBalance(currentBalance + amount);
            System.out.println("Amount deposited successfully!! New balance is: " + account.getAccBalance());
        } else {
            System.out.println("Account not found with account number: " + accNumber);
        }
    }

    @Override
    public void withdrawMoney(double amount, long accNumber) {
        BankAccount account = BankBranches.getAccountByAccNumber(accNumber);
        if (account != null) {
            boolean isMinBalanceMaintained = Helper.checkMinBalance(account, 5000.00, amount);
            if (isMinBalanceMaintained) {
                double currentBalance = account.getAccBalance();
                account.setAccBalance(currentBalance - amount);
                System.out.println("Amount withdrawn successfully!! New balance is: " + account.getAccBalance());
            } else {
                System.out.println("Insufficient balance to withdraw the amount requested!!");
            }
        } else {
            System.out.println("Account not found with account number: " + accNumber);
        }
    }

    @Override
    public void openFD(long accNumber) {
        
    }

    @Override
    public void applyLoan() {
        
    }

    @Override
    public void addBranch(BankBranches branch) {
        Hdfc.branches.add(branch);
    }

}
