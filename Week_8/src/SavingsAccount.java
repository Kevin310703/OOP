public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 5000.0;
    private static final double MAX_WITHDRAWAL = 1000.0;

    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Rut tien.
     * */
    @Override
    public void withdraw(double amount) {
        try {
            if (amount > MAX_WITHDRAWAL) {
                throw new InvalidFundingAmountException(amount);
            }

            if (balance - amount < MIN_BALANCE) {
                throw new InsufficientFundsException(amount);
            }

            doWithdrawing(amount);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
                    amount, balance, balance - amount));
            balance -= amount;
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Nap tien.
     * */
    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
                    amount, balance, balance + amount));
            balance += amount;
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }
}