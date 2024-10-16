import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileExample {

    public static void writeBinaryFile(String filePath, int number, String text) { //ghi dữ liệu vào file nhị phân
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(number);
            dos.writeUTF(text);
            System.out.println("Ghi file binary thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBinaryFile(String filePath) { //đọc dữ liệu từ file nhị phân
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            int number = dis.readInt();
            String text = dis.readUTF();
            System.out.println("Đọc file binary thành công.");
            System.out.println("Số nguyên: " + number);
            System.out.println("Chuỗi: " + text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String binaryFilePath = "binaryfile.dat";
        int number = 678;
        String text = "Tiếp theo thì ...";

        writeBinaryFile(binaryFilePath, number, text);

        readBinaryFile(binaryFilePath);
    }
}
