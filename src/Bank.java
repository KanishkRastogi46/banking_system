
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class Bank {
    private String bankName;
    private static final TreeMap<String, ArrayList<BankAccount>> accounts = new TreeMap<>();
    private static final TreeMap<String, ArrayList<Customer>> customers = new TreeMap<>();
    private static final TreeMap<Long, BankAccount> accNumberMap = new TreeMap<>();
    private static final TreeMap<Integer, Customer> custIDMap = new TreeMap<>();
    private static final TreeMap<Long, Integer> customerAccountMap = new TreeMap<>();

    public Bank(String name) {
        this.bankName = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public static RBI createBankObj(String bankName, BufferedReader buff) {
        if (bankName.trim().equalsIgnoreCase("icici")) return new Icici(buff);
        else if (bankName.trim().equalsIgnoreCase("hdfc")) return new Hdfc(buff);
        else if (bankName.trim().equalsIgnoreCase("hsbc")) return new Hsbc(buff);
        else if (bankName.trim().equalsIgnoreCase("axis")) return new Axis(buff);
        else if (bankName.trim().equalsIgnoreCase("sbi")) return new Sbi(buff);
        else return null;
    }

    public static ArrayList<BankAccount> getAccountsByBank(String bankName) {
        if (accounts.isEmpty() || !accounts.containsKey(bankName)) return null;
        return accounts.get(bankName);
    }

    public static BankAccount getAccountInfo(String bankName, long accNum) {
        if (accounts.isEmpty() || !accounts.containsKey(bankName)) return null;
        else {
            for (BankAccount account: accounts.get(bankName)) {
                if (account.getAccNumber() == accNum) {
                    return account;
                }
            }
        }
        return null;
    }

    public static void addAccountByBank(String bankName, BankAccount account) {
        if (accounts.containsKey(bankName)) {
            accounts.get(bankName).add(account);
        } else {
            ArrayList<BankAccount> newAccountList = new ArrayList<>();
            newAccountList.add(account);
            accounts.put(bankName, newAccountList);
        }
        accNumberMap.put(account.getAccNumber(), account);
    }

    public static ArrayList<Customer> getCustomersByBank(String bankName) {
        if (customers.isEmpty() || !customers.containsKey(bankName)) return null;
        return customers.get(bankName);
    }

    public static Customer getCustomerInfo(String bankName, int custID) {
        if (custIDMap.isEmpty() || !custIDMap.containsKey(custID)) return null;
        else {
            for (Customer customer: customers.get(bankName)) {
                if (customer.getCustID() == custID) return customer;
            }
        }
        return null;
    }

    public static int getNumOfCustomers(String bankName) {
        if (customers.isEmpty() || !customers.containsKey(bankName)) return 0;
        return customers.get(bankName).size();
    }

    public static void addCustomerByBank(String bankName, Customer customer) {
        if (customers.containsKey(bankName)) {
            customers.get(bankName).add(customer);
        } else {
            ArrayList<Customer> newCustomerList = new ArrayList<>();
            newCustomerList.add(customer);
            customers.put(bankName, newCustomerList);
        }
        custIDMap.put(customer.getCustID(), customer);
    }

    public static void mapAccNumToCustID(long accNum, int custID) {
        customerAccountMap.put(accNum, custID);
    }
}
