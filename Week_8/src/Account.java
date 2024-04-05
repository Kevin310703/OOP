import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    public Account() {}

    /**
     * Constructor.
     * */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Lich su giao dich.
     * */
    public String getTransactionHistory() {
        StringBuilder history = new StringBuilder();
        history.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");
        for (Transaction transaction : transactionList) {
            history.append(transaction.getTransactionSummary()).append("\n");
        }
        return history.toString();
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * So sanh so tai khoan trung nhau.
     * */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Account account = (Account) obj;
        return accountNumber == account.accountNumber;
    }

    /**
     * Rut tien.
     * */
    public void doWithdrawing(double amount)
            throws InvalidFundingAmountException, InsufficientFundsException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        }

        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }
    }

    /**
     * Nap tien.
     * */
    public void doDepositing(double amount)
            throws InvalidFundingAmountException, InsufficientFundsException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        }
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);
}
