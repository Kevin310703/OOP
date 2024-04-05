import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private final List<Account> accountList = new ArrayList<>();

    public Customer() {}

    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * In thong tin khach hang.
     * */
    public String getCustomerInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Thông tin khách hàng:\n");
        info.append("ID Number: ").append(idNumber).append("\n");
        info.append("Full Name: ").append(fullName).append("\n");
        info.append("Danh sách tài khoản:\n");
        for (Account account : accountList) {
            info.append("- Số tài khoản: ").append(account.getAccountNumber()).append("\n");
            info.append("  Số dư: $").append(account.getBalance()).append("\n");
        }
        return info.toString();
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}