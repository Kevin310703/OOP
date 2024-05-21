import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Week10 week10 = new Week10();

        StringBuilder content = new StringBuilder();
        File file = new File("C:\\Users\\admin\\Documents\\GitHub\\OOP\\Week_11\\src\\VolumeInfo.java");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            line = reader.readLine();
            content.append(line).append("\n");
        }

        System.out.println(week10.getAllFunctions(content.toString()));
    }
}