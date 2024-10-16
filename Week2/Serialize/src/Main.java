public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Student
        Student student = new Student("John Doe", 20);

        // Đường dẫn tệp nơi sẽ lưu trữ đối tượng serialized
        String filename = "student.ser";

        // Gọi phương thức serialize từ StudentSerializer
        StudentSerializer.serializeStudent(student, filename);

        // Gọi phương thức deserialize từ StudentDeserializer
        Student deserializedStudent = StudentDeserializer.deserializeStudent(filename);
    }
}
