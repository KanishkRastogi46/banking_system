public class BranchManager {
    private String managerName;
    private String empId;
    private BankBranches branch;

    public BranchManager(String managerName, String employeeId) {
        this.managerName = managerName;
        this.empId = employeeId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getEmpId() {
        return this.empId;
    }
}
