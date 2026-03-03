package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 12S24052 Indah Triyuni Siahaan
 */
public class Driver4 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break; // Stop reading input
            }

            String[] parts = line.split("#");
            String command = parts[0];

            switch (command) {
                case "course-add":
                    if (parts.length == 5) { // command#code#name#credits#grade
                        String code = parts[1];
                        String name = parts[2];
                        int credits = Integer.parseInt(parts[3]);
                        String grade = parts[4]; // This 'grade' might be initial expected grade, but for Task 01 it was just part of Course. For consistency with previous solutions, we'll store it.
                        Course course = new Course(code, name, credits, grade);
                        courses.add(course);
                    } else {
                        System.err.println("Invalid course-add format: " + line);
                    }
                    break;

                case "student-add":
                    if (parts.length == 5) { // command#id#name#entryYear#major
                        String id = parts[1];
                        String name = parts[2];
                        int entryYear = Integer.parseInt(parts[3]);
                        String major = parts[4];
                        Student student = new Student(id, name, entryYear, major);
                        students.add(student);
                    } else {
                        System.err.println("Invalid student-add format: " + line);
                    }
                    break;

                case "enrollment-add":
                    if (parts.length == 5) { // command#courseCode#studentId#academicYear#semester
                        String courseCode = parts[1];
                        String studentId = parts[2];
                        String academicYear = parts[3];
                        String semester = parts[4];
                        Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                        enrollments.add(enrollment);
                    } else {
                        System.err.println("Invalid enrollment-add format: " + line);
                    }
                    break;

                default:
                    System.err.println("Unknown command: " + command);
                    break;
            }
        }

        input.close();

        // Display all stored courses
        for (Course course : courses) {
            System.out.println(course);
        }

        // Display all stored students
        for (Student student : students) {
            System.out.println(student);
        }

        // Display all stored enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }
}