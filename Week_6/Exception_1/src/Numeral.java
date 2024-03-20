public class Numeral extends Expression {
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Numeral() {}

    public Numeral(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value == (int) value) {
            return String.valueOf((int) value);
        } else {
            return String.valueOf(value);
        }
    }

    @Override
    public double evaluate() {
        return value;
    }
}
