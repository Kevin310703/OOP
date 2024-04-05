import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tạo danh sách các khách hàng và tài khoản
//        List<Customer> customers = new ArrayList<>();

        // Tạo các tài khoản và thêm vào danh sách tương ứng với mỗi khách hàng
//        CheckingAccount account1 = new CheckingAccount(1234567890, 1000.0);
//        SavingsAccount account2 = new SavingsAccount(1234567891, 3000.0);
//        Customer customer1 = new Customer(123456789, "Nguyễn Thị A");
//        customer1.addAccount(account1);
//        customer1.addAccount(account2);
//        customers.add(customer1);
//
//        CheckingAccount account3 = new CheckingAccount(1234567892, 5000.0);
//        Customer customer2 = new Customer(123456788, "Lê Hoàng B");
//        customer2.addAccount(account3);
//        customers.add(customer2);
//
//        CheckingAccount account4 = new CheckingAccount(1234567893, 2000.0);
//        Customer customer3 = new Customer(123456787, "Hoàng Văn C");
//        customer3.addAccount(account4);
//        customers.add(customer3);
//
//        // Thực hiện giao dịch
//        account1.deposit(500.0);
//        account1.withdraw(1900.0);
//        account2.deposit(1000.0);
//        account2.withdraw(500.0);0
//        account3.deposit(200.0);
//        account3.withdraw(300.0);
//        account4.deposit(100.0);
//        account4.withdraw(150.0);

        Bank bank = new Bank();

        try {
            FileInputStream db = new FileInputStream("C:\\Users\\admin\\Documents\\GitHub\\OOP\\Week_8\\customerData.txt");
            bank.readCustomerList(db);
            db.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bank.getCustomersInfoByIdOrder());



        for (Customer customer : bank.getCustomerList()) {
            for (Account account : customer.getAccountList()) {
//                System.out.println(account.getAccountNumber());
                account.deposit(1000.0);
                account.withdraw(2000.0);

                System.out.println(account.getTransactionHistory());
            }
        }


        // Hiển thị thông tin lịch sử giao dịch của tài khoản 1234567890
//        long accountNumberToCheck = 1234567890;
////        System.out.println("\nLịch sử giao dịch của tài khoản " + accountNumberToCheck + ":");
//        for (Customer customer : customers) {
//            for (Account account : customer.getAccountList()) {
//                if (account.getAccountNumber() == accountNumberToCheck) {
//                    System.out.println(account.getTransactionHistory());
//                }
//            }
//        }
    }
}
