import java.math.BigInteger;

/**
 * solution.
 * */

public class Solution {
    private static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }

    private int numerator;
    private int denominator;

    Solution(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
    }
    /**
     * setNumerator.
     * */

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    /**
     * setDenominator.
     * */

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    /**
     * reduce.
     * */

    public Solution reduce() {
        Solution temp = new Solution(1, 1);
        temp.setNumerator(this.numerator / gcd(this.numerator, this.denominator));
        temp.setDenominator(this.denominator / gcd(this.numerator, this.denominator));
        return temp;
    }
    /**
     * add.
     * */

    public Solution add(Solution temp2) {
        Solution temp = new Solution(1, 1);
        temp.setNumerator(this.numerator * temp2.getDenominator()
                + temp2.getNumerator() * this.denominator);
        temp.setDenominator(this.denominator * temp2.getDenominator());
        return temp;
    }
    /**
     * subtract.
     * */

    public Solution subtract(Solution temp2) {
        Solution temp = new Solution(1, 1);
        temp.setNumerator(this.numerator * temp2.getDenominator()
                - temp2.getNumerator() * this.denominator);
        temp.setDenominator(this.denominator * temp2.getDenominator());
        return temp;
    }
    /**
     * multiply.
     * */

    public Solution multiply(Solution temp2) {
        Solution temp = new Solution(1, 1);
        temp.setNumerator(this.numerator * temp2.getNumerator());
        temp.setDenominator(this.denominator * temp2.getDenominator());
        return temp;
    }
    /**
     * divide.
     * */

    public Solution divide(Solution temp2) {
        Solution temp = new Solution(1, 1);
        temp.setNumerator(this.numerator * temp2.getDenominator());
        temp.setDenominator(this.denominator * temp2.getNumerator());
        return temp;
    }
    /**
     * equals.
     * */

    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            if ((this.numerator / other.getNumerator())
                    == (this.denominator / other.getDenominator())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}