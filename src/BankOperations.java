
import java.io.BufferedReader;
import java.io.IOException;

public class BankOperations implements RBI {
    BufferedReader buff;

    public BankOperations(BufferedReader buff) {
        this.buff = buff;
    }

    @Override
    public void openAccount(String bankName) {
        try {
            long aadharNumber;
            String panNumber, phoneNumber;

            System.out.println("Following deatils are required to create a new bank account:");
            System.out.println("1. Aadhar card number,\n2. PAN card number,\n3. phone number\n");

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

            Customer newCustomer = new Customer();
            BankAccount newAccount = new BankAccount();

            // Generate account number
            long accNumber = Helper.generateAccNumber();
            newAccount.setAccNumber(accNumber);
            newCustomer.setCustID(Integer.parseInt(Helper.generateCustomerID().toString()));
            newCustomer.setCustName(custName);
            newCustomer.setCustPhone(phoneNumber);
            newAccount.setAccHolder(newCustomer);

            Bank.addAccountByBank(bankName, newAccount);
            Bank.addCustomerByBank(bankName, newCustomer);
            Bank.mapAccNumToCustID(accNumber, newCustomer.getCustID());

            int numOfCustomers = Bank.getNumOfCustomers(bankName);
            System.out.println("Total number of customers in " + bankName + " bank are: " + numOfCustomers);

            System.out.println("Congratulations!! " + custName + " Your account has been created successfully in " + bankName + " bank and your account number is " + accNumber);
        } catch(IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void depositMoney(double amount, long accNumber, String bankName) {
        BankAccount account = Bank.getAccountInfo(bankName, accNumber);
        if (account != null) {
            double currentBalance = account.getAccBalance();
            account.setAccBalance(currentBalance + amount);
            System.out.println("Amount deposited successfully!! New balance is: " + account.getAccBalance());
        } else {
            System.out.println("Account not found with account number: " + accNumber);
        }
    }

    @Override
    public void withdrawMoney(double amount, long accNumber, String bankName) {
        BankAccount account = Bank.getAccountInfo(bankName, accNumber);
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
    public void openFD(long accNum, String bankName) {
        try {
            System.out.println("Opening FD for account number: " + accNum + " in bank: " + bankName);
            System.out.println("Please enter the amount to be deposited in FD: ");
            double amount = Double.parseDouble(this.buff.readLine());
            double interestRate = RBI.FD_INTEREST_RATE;
            int durationYears = RBI.FD_DURATION_YEARS;
            double maturityAmount;

            if (bankName.toLowerCase().equals("icici")) {
                interestRate = Icici.fdInterestRate;
                durationYears = Icici.fdDurationYears;
                maturityAmount = Helper.calculateFDMaturityAmount(amount, interestRate, durationYears);
            } else if (bankName.toLowerCase().equals("hdfc")) {
                interestRate = Hdfc.fdInterestRate;
                durationYears = Hdfc.fdDurationYears;
                maturityAmount = Helper.calculateFDMaturityAmount(amount, interestRate, durationYears);
            } else if (bankName.toLowerCase().equals("hsbc")) {
                interestRate = Hsbc.fdInterestRate;
                durationYears = Hsbc.fdDurationYears;
                maturityAmount = Helper.calculateFDMaturityAmount(amount, interestRate, durationYears);
            } else if (bankName.toLowerCase().equals("axis")) {
                interestRate = Axis.fdInterestRate;
                durationYears = Axis.fdDurationYears;
                maturityAmount = Helper.calculateFDMaturityAmount(amount, interestRate, durationYears);
            } else if (bankName.toLowerCase().equals("sbi")) {
                interestRate = Sbi.fdInterestRate;
                durationYears = Sbi.fdDurationYears;
                maturityAmount = Helper.calculateFDMaturityAmount(amount, interestRate, durationYears);
            } else {
                maturityAmount = Helper.calculateFDMaturityAmount(amount, interestRate, durationYears);
            }

            System.out.println("FD created successfully!!");
            System.out.println("Principal Amount: " + amount);
            System.out.println("Interest Rate: " + interestRate + "%");
            System.out.println("Duration (years): " + durationYears);
            System.out.println("Maturity Amount: " + maturityAmount);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void applyLoan() {
        System.out.println("Loan application process initiated...");
        System.out.println("This feature is under development. Please check back later.");
    }
}
