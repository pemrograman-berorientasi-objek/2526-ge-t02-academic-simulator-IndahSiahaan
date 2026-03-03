package academic.model;

public class Enrollment {
   private String courseCode;
   private String studentId;
   private String academicYear;
   private String semester;
   private String grade;

   public Enrollment(String var1, String var2, String var3, String var4) {
      this.courseCode = var1;
      this.studentId = var2;
      this.academicYear = var3;
      this.semester = var4;
      this.grade = "None";
   }

   public String getCourseCode() {
      return this.courseCode;
   }

   public String getStudentId() {
      return this.studentId;
   }

   public String getAcademicYear() {
      return this.academicYear;
   }

   public String getSemester() {
      return this.semester;
   }

   public String getGrade() {
      return this.grade;
   }

   public void setGrade(String var1) {
      this.grade = var1;
   }

   public String toString() {
      return this.courseCode + "|" + this.studentId + "|" + this.academicYear + "|" + this.semester + "|" + this.grade;
   }
}
