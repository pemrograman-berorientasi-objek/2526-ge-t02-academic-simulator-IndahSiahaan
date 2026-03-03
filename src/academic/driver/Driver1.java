package academic.driver;

import academic.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 12S24052 Indah Triyuni Siahaan
 */
public class Driver1 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break; // Stop reading input
            }

            // Parse the input line
            String[] parts = line.split("#");
            if (parts.length == 4) { // Ensure correct number of parts
                String code = parts[0];
                String name = parts[1];
                int credits = Integer.parseInt(parts[2]); // Convert credits to int
                String grade = parts[3];

                Course course = new Course(code, name, credits, grade);
                courses.add(course);
            } else {
                // Optionally handle malformed input lines
                System.err.println("Input format error: " + line);
            }
        }

        input.close(); // Close the scanner to prevent resource leak

        // Display all stored courses
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}