public class InvalidFundingAmountException extends BankException {
    /**
     * Kiem tra so tien họp le.
     * */
    public InvalidFundingAmountException(double amount) {
        super(String.format(
                "Số tiền không hợp lệ: $%.2f",
                amount
        ));
    }
}