public class Fibonacci {
    static long fibonacci(long n) {
        // Xử lý trường hợp n âm
        if (n < 0) {
            return -1;
        }

        // Xử lý trường hợp n = 0 hoặc n = 1
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        // Tính Fibonacci thứ n
        long fibNMinus2 = 0;
        long fibNMinus1 = 1;
        long fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fibNMinus1 + fibNMinus2;
            fibNMinus2 = fibNMinus1;
            fibNMinus1 = fibN;
        }

        // Xử lý trường hợp vượt quá giá trị lớn nhất của long
        if (fibN < 0) {
            return Long.MAX_VALUE;
        }

        return fibN;
    }
}
