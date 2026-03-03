package academic.driver;

import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        System.out.println("Masukkan data enrollment (CODE#ID#TAHUN#SEMESTER), ketik '---' untuk berhenti:");

        while (input.hasNextLine()) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            // Penanganan error: Memastikan format input benar
            String[] parts = line.split("#");
            if (parts.length != 4) {
                System.err.println("Error: Format input tidak valid. Harap gunakan format CODE#ID#TAHUN#SEMESTER.");
                continue; // Lanjutkan ke input berikutnya
            }

            try {
                String courseCode = parts[0];
                String studentId = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];

                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(newEnrollment);
            } catch (Exception e) {
                System.err.println("Error tak terduga saat memproses baris: " + line + " - " + e.getMessage());
            }
        }

        System.out.println("\n--- Daftar Enrollment Tersimpan ---");
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