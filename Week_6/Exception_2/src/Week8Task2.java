import java.io.FileNotFoundException;

public class Week8Task2 {
    public static void throwFileNotFoundException() throws FileNotFoundException {
        throw new FileNotFoundException(); // Gây ra FileNotFoundException
    }

    public static String nullPointerExTest() {
        return "Lỗi Null Pointer";
    }

    public static String arrayIndexOutOfBoundsExTest() {
        return "Lỗi Array Index Out of Bounds";
    }

    public static String arithmeticExTest() {
        return "Lỗi Arithmetic";
    }

    public static String fileNotFoundExTest() {
        return "Lỗi File Not Found";
    }

    public static String ioExTest() {
        return "Lỗi IO";
    }
}