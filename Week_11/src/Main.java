import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Week10 week10 = new Week10();
        String filePath = "C:\\Users\\admin\\Documents\\GitHub\\OOP\\Week_11\\src\\VolumeInfo.java";
        String fileContent = "";

        try {
            fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
//            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> signatures = week10.getAllFunctions(fileContent);
        for (String signature : signatures) {
            System.out.println(signature);
        }
    }
}