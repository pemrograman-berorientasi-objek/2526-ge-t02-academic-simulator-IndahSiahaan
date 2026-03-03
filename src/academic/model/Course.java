package academic.model;

public class Course {
    private String code;
    private String name;
    private int credits;
    private String gradeCategory; // Added to match the 4-field output (e.g., 'C', 'D')

    public Course(String code, String name, int credits, String gradeCategory) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.gradeCategory = gradeCategory;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGradeCategory() {
        return gradeCategory;
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + gradeCategory;
    }
}