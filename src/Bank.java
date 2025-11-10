
import java.util.ArrayList;

public abstract class Bank implements RBI {
    private String bankName;
    private static final ArrayList<BankBranches> branches = new ArrayList<>();

    public Bank(String name) {
        this.bankName = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ArrayList<BankBranches> getBranches() {
        return branches;
    }

    public void addBranch(BankBranches branch) {
        Bank.branches.add(branch);
    }
}
