import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileDirectoryOperations {

    public static void listFilesAndDirectories(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.println("[Thư mục] " + file.getName());
                    } else {
                        System.out.println("[Tệp] " + file.getName());
                    }
                }
            } else {
                System.out.println("Thư mục rỗng.");
            }
        } else {
            System.out.println("Thư mục không tồn tại hoặc không hợp lệ.");
        }
    }

    public static void readFileContent(String filePath) {
        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                System.out.println("Nội dung của file " + file.getName() + ":");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đọc file: " + e.getMessage());
            }
        } else {
            System.out.println("File không tồn tại hoặc không phải là tệp hợp lệ.");
        }
    }

    public static void main(String[] args) {
        String directoryPath = "path/to/directory";

        String filePath = "path/to/directory/filename.txt";

        System.out.println("Danh sách file và thư mục trong: " + directoryPath);
        listFilesAndDirectories(directoryPath);

        System.out.println("\nĐọc nội dung file:");
        readFileContent(filePath);
    }
}
