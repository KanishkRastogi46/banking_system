
import java.util.Random;

public class Helper {
    public static long generateAccNumber() {
        StringBuilder accNumber = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 12; i++) {
            int digit = rand.nextInt(10);
            accNumber.append(digit);
        }
        return Long.parseLong(accNumber.toString());
    }

    public static boolean validateCustomer(String aadhar, String pan, String phone) {
        if (!"".equals(aadhar.trim())) {
            if (aadhar.length() != 12) {
                System.out.println("Invalid Aadhar number!! It should be of 12 digits.");
                return false;
            }
        }
        if (!"".equals(pan.trim())) {
            if (pan.length() != 10) {
                System.out.println("Invalid PAN number!! It should be of 10 characters.");
                return false;
            }
        }
        if (!"".equals(phone.trim())) {
            if (phone.length() != 10) {
                System.out.println("Invalid phone number!! It should be of 10 digits.");
                return false;
            }
        }
        return true;
    }

    public static StringBuilder generateCustomerID(String bankName) {
        StringBuilder custID = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 8; i++) {
            int digit = rand.nextInt(10);
            custID.append(digit);
        }
        return custID;
    }

    public static StringBuilder generateIfsc(String bankName) {
        int endIndex = bankName.length() < 4 ? bankName.length() : 4;
        String bankInitial4Letters = bankName.substring(0, endIndex).toUpperCase();
        StringBuilder ifsc = new StringBuilder();
        Random rand = new Random();
        ifsc.append(bankInitial4Letters);
        ifsc.append("0");
        for (int i=0; i<6; i++) {
            int digit = rand.nextInt(10);
            ifsc.append(digit);
        }
        return ifsc;
    }

    public static boolean checkMinBalance(BankAccount account, double minBalance, double withdrawAmount) {
        return (account.getAccBalance() - withdrawAmount) >= minBalance;
    }
}
