
import java.io.BufferedReader;
import java.io.IOException;

public class BankOperations {
    BufferedReader buff;

    public BankOperations(BufferedReader buff) {
        this.buff = buff;
    }

    public void createAccount(String bankName, String branchName) {
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

            System.out.println("Verification successful!! Creating your account now...");
            Bank bank = new Bank(bankName);
            BankBranches bankBranch = new BankBranches(bankName);
            bank.addBranch(bankBranch);
            bankBranch.setIfsc(Helper.generateIfsc(bankName).toString());

            Customer newCustomer = new Customer();
            BankAccount newAccount = new BankAccount();

            // Generate account number
            long accNumber = Helper.generateAccNumber();
            newAccount.setAccNumber(accNumber);
            newCustomer.setCustID(Helper.generateCustomerID(bankName).toString());
            newCustomer.setCustName(custName);
            newCustomer.setCustPhone(phoneNumber);
            newAccount.setAccHolder(newCustomer);
            bankBranch.setCustomers(newCustomer);

            System.out.println("Congratulations!! " + custName + " Your account has been created successfully in " + bankName + " bank and your account number is " + accNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void depositMoney(double amount, BankAccount account) {
        account.setAccBalance(account.getAccBalance() + amount);
    }

    public void withdrawMoney(double amount, BankAccount account) {
        if (Helper.checkMinBalance(account, 5000.00)) account.setAccBalance(account.getAccBalance() - amount);
        else System.out.println("Insufficient balance to withdraw the amount requested!!");
    }

    public void openFD() {

    }

    public void applyLoan() {

    }
}
