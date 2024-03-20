public class Division extends BinaryExpression {
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " / " + right.toString() + ")";
    }

    @Override
    public double evaluate() {
        double divisor = right.evaluate();
        if (divisor == 0) {
            throw new ArithmeticException("Lỗi chia cho 0");
        }
        return left.evaluate() / divisor;
    }
}
