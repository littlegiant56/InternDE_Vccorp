import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Override equals() to compare based on name and age
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Same reference
        if (o == null || getClass() != o.getClass()) return false; // Null or different class
        Student student = (Student) o; // Cast to Student
        return age == student.age && name.equals(student.name); // Compare fields
    }

    // Override hashCode() to generate hash based on name and age
    @Override
    public int hashCode() {
        return Objects.hash(name, age); // Create hash based on fields
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ")"; // String representation
    }
}

public class DataStructuresExample {

    public static void main(String[] args) {

        // 1. Using HashMap to store Student objects and their scores
        HashMap<Student, Integer> studentScores = new HashMap<>();
        studentScores.put(new Student("Nam", 20), 85);
        studentScores.put(new Student("Huy", 21), 90);
        studentScores.put(new Student("Linh", 19), 75);
        studentScores.put(new Student("An", 22), 80);

        // Print each student's score
        System.out.println("Scores of each student:");
        for (Map.Entry<Student, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 2. Demonstrate equality in HashMap
        System.out.println("\nChecking for an existing student:");
        Student checkStudent = new Student("Nam", 20);
        if (studentScores.containsKey(checkStudent)) {
            System.out.println(checkStudent + " is found with score: " + studentScores.get(checkStudent));
        } else {
            System.out.println(checkStudent + " is not found.");
        }

        // 3. Using HashSet to store Student objects (no duplicates)
        HashSet<Student> studentSet = new HashSet<>();
        studentSet.add(new Student("Nam", 20));
        studentSet.add(new Student("Huy", 21));
        studentSet.add(new Student("Nam", 20)); // Will not be added again
        studentSet.add(new Student("Linh", 19));

        // Print the list of students in the HashSet
        System.out.println("\nList of students in HashSet (no duplicates):");
        for (Student student : studentSet) {
            System.out.println(student);
        }

        // 4. Using ArrayList to store a list of students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Nam", 20));
        students.add(new Student("Huy", 21));
        students.add(new Student("Linh", 19));
        students.add(new Student("An", 22));

        // Print the list of students
        System.out.println("\nList of students in ArrayList:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
