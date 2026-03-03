package academic.driver;

import academic.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Masukkan data mahasiswa (ID#Nama#Tahun#Jurusan), ketik '---' untuk berhenti:");

        while (input.hasNextLine()) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            // Penanganan error: Memastikan format input benar
            String[] parts = line.split("#");
            if (parts.length != 4) {
                System.err.println("Error: Format input tidak valid. Harap gunakan format ID#Nama#Tahun#Jurusan.");
                continue; // Lanjutkan ke input berikutnya
            }

            try {
                String id = parts[0];
                String name = parts[1];
                String year = parts[2]; // Tahun dianggap String sesuai contoh input
                String major = parts[3];

                Student newStudent = new Student(id, name, year, major);
                students.add(newStudent);
            } catch (Exception e) {
                System.err.println("Error tak terduga saat memproses baris: " + line + " - " + e.getMessage());
            }
        }

        System.out.println("\n--- Daftar Mahasiswa Tersimpan ---");
        if (students.isEmpty()) {
            System.out.println("Tidak ada mahasiswa yang tersimpan.");
        } else {
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }

        input.close();
    }
}