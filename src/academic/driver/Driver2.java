package academic.driver;

import academic.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 12S24052 Indah Triyuni Siahaan
 */
public class Driver2 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break; // Stop reading input
            }

            // Parse the input line
            String[] parts = line.split("#");
            if (parts.length == 4) { // Ensure correct number of parts
                String id = parts[0];
                String name = parts[1];
                int entryYear = Integer.parseInt(parts[2]); // Convert entryYear to int
                String major = parts[3];

                Student student = new Student(id, name, entryYear, major);
                students.add(student);
            } else {
                // Optionally handle malformed input lines
                System.err.println("Input format error: " + line);
            }
        }

        input.close(); // Close the scanner to prevent resource leak

        // Display all stored students
        for (Student student : students) {
            System.out.println(student);
        }
    }
}