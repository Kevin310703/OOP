import java.util.*;

public class Week4 {

    public static int max2Int(int a, int b) {
        // Tim gia tri lon nhat cua hai so nguyen
        return Math.max(b, a);
    }

    public static int minArray (int[] array) {
        // Tim gia tri nho nhat cua 1 mang so nguyen
        Arrays.sort(array);

        return array[0];
    }

    public static String calculateBMI(double weight, double height){
        // Tinh BMI
        double bmi = weight / (height * height);
        double roundedBMI = Math.round(bmi * 10.0) / 10.0;

        if (roundedBMI < 18.5) {
            return "Thiếu cân";
        } else if (roundedBMI >= 18.5 && roundedBMI <= 22.9) {
            return "Bình thường";
        } else if (roundedBMI >= 23 && roundedBMI <= 24.9) {
            return "Thừa cân";
        } else {
            return "Béo phì";
        }
    }
}
