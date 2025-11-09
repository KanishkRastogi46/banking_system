
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    BufferedReader buff;
    InputStreamReader isr;
    String choice, operations, selectedBank;
    BankOperations mOpeartions;

    App() {
        this.isr = new InputStreamReader(System.in);
        this.buff = new BufferedReader(isr);
        this.mOpeartions = new BankOperations(buff);
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
                case 1: {
                    System.out.println("ICICI Bank selected!!"); 
                    myApp.selectedBank = "ICICI";
                    break;
                }
                case 2: {
                    System.out.println("HDFC Bank selected!!"); 
                    myApp.selectedBank = "HDFC";
                    break;
                }
                case 3: {
                    System.out.println("HSBC Bank selected!!"); 
                    myApp.selectedBank = "HSBC";
                    break;
                }
                case 4: {
                    System.out.println("Axis Bank selected!!"); 
                    myApp.selectedBank = "AXIS";
                    break;
                }
                case 5: {
                    System.out.println("SBI Bank selected!!"); 
                    myApp.selectedBank = "SBI";
                    break;
                }
                default: {
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

            switch (Integer.parseInt(myApp.operations)) {
                case 1: {
                    System.out.println("Open Account selected!!");
                    System.out.println("Please enter the branch name: ");
                    try {
                        String branchName = myApp.buff.readLine();
                        myApp.mOpeartions.createAccount(myApp.selectedBank, branchName);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
                case 2: {

                }
                case 3: {

                }
                case 4: {

                }
                case 5: {

                }
                default: System.out.println("No operation selected!!");
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
