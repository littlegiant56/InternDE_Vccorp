import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileExample {

    public static void writeTextFile(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            System.out.println("Ghi file text thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readTextFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            System.out.println("Đọc file text thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        String textFilePath = "textfile.txt";
        String data = "Đây là nội dung ghi vào file text.";

        writeTextFile(textFilePath, data);

        String fileContent = readTextFile(textFilePath);
        System.out.println("Nội dung file:\n" + fileContent);
    }
}
