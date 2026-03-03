package academic.driver;

import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 12S24052 Indah Triyuni Siahaan
 */
public class Driver3 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break; // Stop reading input
            }

            // --- PERUBAHAN DIMULAI DI SINI ---
            String[] parts;
            String originalLineData = line;

            // Check if the line starts with "enrollment-add#" (for compatibility with Driver4-style test input)
            if (line.startsWith("enrollment-add#")) {
                // If it does, remove the prefix to get the actual data for Enrollment
                originalLineData = line.substring("enrollment-add#".length());
            }
            
            // Now parse the (potentially modified) line data
            parts = originalLineData.split("#");
            // Input format expected by Enrollment constructor: courseCode#studentId#academicYear#semester (4 parts)
            if (parts.length == 4) {
                String courseCode = parts[0];
                String studentId = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];

                Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(enrollment);
            } else {
                // Optionally handle malformed input lines
                // Note: This error will now only trigger if the data *after* "enrollment-add#" is malformed,
                // or if a line without "enrollment-add#" has incorrect parts.
                System.err.println("Input format error for data: " + originalLineData);
            }
            // --- PERUBAHAN BERAKHIR DI SINI ---
        }

        input.close(); // Close the scanner to prevent resource leak

        // Display all stored enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }
}