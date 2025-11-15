
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

public class App {
    BufferedReader buff;
    InputStreamReader isr;
    String choice, operations, selectedBank;
    Connection conn;

    App() {
        this.isr = new InputStreamReader(System.in);
        this.buff = new BufferedReader(isr);

        // Connect to Database
        this.conn = DatabaseConnection.connectTODatbase();
    }
    public static void main(String[] args) {
        App myApp = new App();

        boolean stop = false;
        while (!stop) {
            System.out.println("Welcome to Indian banking system.... Please select your bank to proceed further:\n1. ICICI Bank\n2. HDFC Bank\n3. HSBC\n4. Axis\n5. SBI Bank");
            try {
                myApp.choice = myApp.buff.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (Integer.parseInt(myApp.choice)) {
                case 1 ->  {
                    System.out.println("ICICI Bank selected!!"); 
                    myApp.selectedBank = "ICICI";
                }
                case 2 ->  {
                    System.out.println("HDFC Bank selected!!"); 
                    myApp.selectedBank = "HDFC";
                }
                case 3 ->  {
                    System.out.println("HSBC Bank selected!!"); 
                    myApp.selectedBank = "HSBC";
                }
                case 4 ->  {
                    System.out.println("Axis Bank selected!!"); 
                    myApp.selectedBank = "AXIS";
                }
                case 5 ->  {
                    System.out.println("SBI Bank selected!!"); 
                    myApp.selectedBank = "SBI";
                }
                default -> {
                    System.out.println("No bank selected!!");
                    return;
                }
            }

            System.out.println("Please select the operation you want to perform:\n1. Open account\n2. Deposit\n3. Withdraw\n4. Open FD\n5. Appy Loan");
            try {
                myApp.operations = myApp.buff.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            RBI bank = Bank.createBankObj(myApp.selectedBank, myApp.buff);
            switch (Integer.parseInt(myApp.operations)) {
                case 1 ->  {
                    System.out.println("Open Account selected!!");
                    bank.openAccount(myApp.selectedBank);
                }
                case 2 ->  {
                    System.out.println("Deposit selected!!");
                    try {
                        System.out.println("Please enter your account number: ");
                        String accNumStr = myApp.buff.readLine();
                        long accNumber = Long.parseLong(accNumStr);

                        System.out.println("Please enter the amount to be deposited: ");
                        String amountStr = myApp.buff.readLine();
                        double amount = Double.parseDouble(amountStr);

                        bank.depositMoney(amount, accNumber, myApp.selectedBank);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 3 ->  {
                    System.out.println("Withdraw selected!!");
                    try {
                        System.out.println("Please enter your account number: ");
                        String accNumStr = myApp.buff.readLine();
                        long accNumber = Long.parseLong(accNumStr);

                        System.out.println("Please enter the amount to be withdrawn: ");
                        String amountStr = myApp.buff.readLine();
                        double amount = Double.parseDouble(amountStr);

                        bank.withdrawMoney(amount, accNumber, myApp.selectedBank);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 4 ->  {
                    System.out.println("Open FD selected!!");
                    try {
                        System.out.println("Please enter your account number: ");
                        String accNumStr = myApp.buff.readLine();
                        long accNumber = Long.parseLong(accNumStr);

                        bank.openFD(accNumber, myApp.selectedBank);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 5 ->  {
                    System.out.println("Apply Loan selected!!");
                    bank.applyLoan();
                }
                default -> System.out.println("No operation selected!!");
            }
            System.out.println("Do you want to stop? (yes/no)");
            try {
                myApp.choice = myApp.buff.readLine();
                if ("yes".equalsIgnoreCase(myApp.choice.trim())) {
                    stop = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
