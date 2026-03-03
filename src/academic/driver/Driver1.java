package academic.driver;

import academic.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        System.out.println("Masukkan data mata kuliah (kode#nama#sks#nilai), ketik '---' untuk berhenti:");

        while (input.hasNextLine()) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            // Penanganan error: Memastikan format input benar
            String[] parts = line.split("#");
            if (parts.length != 4) {
                System.err.println("Error: Format input tidak valid. Harap gunakan format kode#nama#sks#nilai.");
                continue; // Lanjutkan ke input berikutnya
            }

            try {
                String code = parts[0];
                String name = parts[1];
                int credits = Integer.parseInt(parts[2]); // Penanganan error: SKS harus angka
                String grade = parts[3];

                Course newCourse = new Course(code, name, credits, grade);
                courses.add(newCourse);
            } catch (NumberFormatException e) {
                System.err.println("Error: Jumlah SKS harus berupa angka. Baris dilewati: " + line);
            } catch (Exception e) {
                System.err.println("Error tak terduga saat memproses baris: " + line + " - " + e.getMessage());
            }
        }

        System.out.println("\n--- Daftar Mata Kuliah Tersimpan ---");
        if (courses.isEmpty()) {
            System.out.println("Tidak ada mata kuliah yang tersimpan.");
        } else {
            for (Course course : courses) {
                System.out.println(course.toString());
            }
        }

        input.close();
    }
}