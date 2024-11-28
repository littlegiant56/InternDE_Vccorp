package org.example;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Student
        Student student = new Student("Nam", 21);

        // Đường dẫn tệp nơi sẽ lưu trữ đối tượng JSON
        String filename = "student.json";

        // Gọi phương thức serialize từ StudentSerializer
        StudentSerializer.serializeStudent(student, filename);

        // Gọi phương thức deserialize từ StudentDeserializer
        Student deserializedStudent = StudentDeserializer.deserializeStudent(filename);

        // In thông tin đối tượng đã deserialized
        System.out.println("Deserialized Student: " + deserializedStudent);
    }
}
