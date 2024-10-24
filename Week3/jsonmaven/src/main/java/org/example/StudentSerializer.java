package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

class StudentDeserializer {

    public static Student deserializeStudent(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        Student student = null;
        try {
            // Đọc đối tượng từ tệp JSON
            student = mapper.readValue(new File(filename), Student.class);
            System.out.println("Deserialization successful: " + student);
        } catch (IOException e) {
            System.err.println("Deserialization failed: " + e.getMessage());
            e.printStackTrace();
        }
        return student;
    }
}
