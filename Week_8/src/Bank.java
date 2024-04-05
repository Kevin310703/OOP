import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    private final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    /**
     * Doc du lieu tu file.
     * */
    public void readCustomerList(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            Customer customer = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");

                if (isNumeric(data[0])) {
                    // Nếu dòng bắt đầu bằng số, xử lý thông tin tài khoản
                    long accountNumber = Long.parseLong(data[0]);
                    String accountType = data[1];
                    double balance = Double.parseDouble(data[2]);

                    Account account;
                    if (accountType.equals(Account.CHECKING)) {
                        account = new CheckingAccount(accountNumber, balance);
                    } else if (accountType.equals(Account.SAVINGS)) {
                        account = new SavingsAccount(accountNumber, balance);
                    } else {
                        // Handle unrecognized account type
                        continue;
                    }

                    if (customer != null) {
                        customer.addAccount(account);
                    }
                } else {
                    // Nếu không phải số, tạo một khách hàng mới
                    if (customer != null) {
                        customerList.add(customer);
                    }

                    String fullName = data[0] + " " + data[1] + " " + data[2];
                    long idNumber = Long.parseLong(data[3]);

                    customer = new Customer(idNumber, fullName);
                }
            }

            // Đảm bảo thêm khách hàng cuối cùng vào danh sách
            if (customer != null) {
                customerList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sap xep theo ten khach hang.
     * */
    public String getCustomersInfoByNameOrder() {
        List<Customer> sortedCustomers = new ArrayList<>(customerList);
        Collections.sort(sortedCustomers, Comparator.comparing(Customer::getFullName));
        StringBuilder info = new StringBuilder();
        for (Customer customer : sortedCustomers) {
            info.append("Số CMND: ")
                    .append(customer.getIdNumber())
                    .append(". Họ tên: ")
                    .append(customer.getFullName())
                    .append(".\n");
        }
        return info.toString();
    }

    /**
     * Sap xep theo id khach hang.
     * */
    public String getCustomersInfoByIdOrder() {
        List<Customer> sortedCustomers = new ArrayList<>(customerList);
        sortedCustomers.sort(Comparator.comparing(Customer::getIdNumber));
        StringBuilder info = new StringBuilder();
        for (Customer customer : sortedCustomers) {
            info.append("Số CMND: ")
                    .append(customer.getIdNumber())
                    .append(". Họ tên: ")
                    .append(customer.getFullName())
                    .append(".\n");
        }
        return info.toString();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}