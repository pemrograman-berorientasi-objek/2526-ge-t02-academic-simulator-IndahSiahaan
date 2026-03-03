package academic.model;

public class Student {
    private String id;
    private String name;
    private String academicYear; // Matches the example output '2020'
    private String major;        // Matches the example output 'Information Systems'

    public Student(String id, String name, String academicYear, String major) {
        this.id = id;
        this.name = name;
        this.academicYear = academicYear;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + academicYear + "|" + major;
    }
}