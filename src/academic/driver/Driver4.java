package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        System.out.println("Masukkan data (course-add CODE#NAME#CREDITS#GRADECATEGORY, " +
                           "student-add ID#NAME#ACADEMICYEAR#MAJOR, " +
                           "enrollment-add COURSECODE#STUDENTID#ACADEMICYEAR#SEMESTER), " +
                           "ketik '---' untuk berhenti:");

        while (input.hasNextLine()) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] commandAndData = line.split(" ", 2); // Split once to separate command from data
            if (commandAndData.length < 2) {
                System.err.println("Error: Format input tidak valid. Harap sertakan perintah dan data.");
                continue;
            }

            String command = commandAndData[0];
            String data = commandAndData[1];
            String[] parts = data.split("#");

            try {
                switch (command) {
                    case "course-add":
                        if (parts.length == 4) {
                            String code = parts[0];
                            String name = parts[1];
                            int credits = Integer.parseInt(parts[2]);
                            String gradeCategory = parts[3]; // e.g., 'C' or 'D' from example
                            Course newCourse = new Course(code, name, credits, gradeCategory);
                            courses.add(newCourse);
                        } else {
                            System.err.println("Error: Format input Course tidak valid. Harap gunakan CODE#NAME#CREDITS#GRADECATEGORY.");
                        }
                        break;
                    case "student-add":
                        if (parts.length == 4) {
                            String id = parts[0];
                            String name = parts[1];
                            String academicYear = parts[2];
                            String major = parts[3];
                            Student newStudent = new Student(id, name, academicYear, major);
                            students.add(newStudent);
                        } else {
                            System.err.println("Error: Format input Student tidak valid. Harap gunakan ID#NAME#ACADEMICYEAR#MAJOR.");
                        }
                        break;
                    case "enrollment-add":
                        if (parts.length == 4) {
                            String courseCode = parts[0];
                            String studentId = parts[1];
                            String academicYear = parts[2];
                            String semester = parts[3];
                            Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                            enrollments.add(newEnrollment);
                        } else {
                            System.err.println("Error: Format input Enrollment tidak valid. Harap gunakan COURSECODE#STUDENTID#ACADEMICYEAR#SEMESTER.");
                        }
                        break;
                    default:
                        System.err.println("Error: Perintah tidak dikenal: " + command);
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Kesalahan format angka pada input: " + data + " - " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error tak terduga saat memproses baris: " + line + " - " + e.getMessage());
            }
        }

        System.out.println("\n--- Data Courses Tersimpan ---");
        if (courses.isEmpty()) {
            System.out.println("Tidak ada course yang tersimpan.");
        } else {
            for (Course course : courses) {
                System.out.println(course.toString());
            }
        }

        System.out.println("\n--- Data Students Tersimpan ---");
        if (students.isEmpty()) {
            System.out.println("Tidak ada student yang tersimpan.");
        } else {
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }

        System.out.println("\n--- Data Enrollments Tersimpan ---");
        if (enrollments.isEmpty()) {
            System.out.println("Tidak ada enrollment yang tersimpan.");
        } else {
            for (Enrollment enrollment : enrollments) {
                System.out.println(enrollment.toString());
            }
        }

        input.close();
    }
}