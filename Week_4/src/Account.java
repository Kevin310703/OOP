import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    // Getter cho balance (chỉ để mục đích kiểm tra, không có setter)
    public double getBalance() {
        return balance;
    }

    /**
     * Constructor.
     * */
    public Account() {
        this.balance = 0;
        this.transitionList = new ArrayList<>();
    }

    // Phương thức deposit
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    // Phương thức withdraw
    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= getBalance()) {
                balance -= amount;
            } else {
                System.out.println("So tien ban rut vuot qua so du!");
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }
    /**
     * addTransaction.
     * */

    public void addTransaction(double amount, String operation) {
        String normalizedOperation = operation.toUpperCase();  // Chuẩn hóa giá trị operation

        if (normalizedOperation.equals(Transaction.DEPOSIT)
                || normalizedOperation.equals(Transaction.WITHDRAW)) {
            Transaction transaction = new Transaction(normalizedOperation, amount, balance);
            transitionList.add(transaction);

            balance = transaction.getBalance();

            if (normalizedOperation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
            } else {
                withdraw(amount);
            }

            transaction.setBalance(balance);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }
    /**
     * printTransaction.
     * */

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            Transaction transaction = transitionList.get(i);

            String formattedAmount = String.format(Locale.US, "%.2f", transaction.getAmount());
            String formattedBalance = String.format(Locale.US, "%.2f", transaction.getBalance());

            if (Objects.equals(transaction.getOperation().toUpperCase(), "DEPOSIT")) {
                System.out.println("Giao dich " + (i + 1) + ": Nap tien $" + formattedAmount
                + ". So du luc nay: $" + formattedBalance + ".");
            } else {
                System.out.println("Giao dich " + (i + 1) + ": Rut tien $" + formattedAmount
                        + ". So du luc nay: $" + formattedBalance + ".");
            }
        }
    }
}
