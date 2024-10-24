package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

class StudentSerializer {

    public static void serializeStudent(Student student, String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Ghi đối tượng Student vào tệp dưới dạng JSON
            mapper.writeValue(new File(filename), student);
            System.out.println("Serialization successful: " + student);
        } catch (IOException e) {
            System.err.println("Serialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
