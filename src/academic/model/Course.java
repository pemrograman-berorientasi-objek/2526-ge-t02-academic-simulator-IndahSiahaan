package academic.model;

public class Course {
   private String code;
   private String name;
   private int credits;
   private String grade;

   public Course(String var1, String var2, int var3, String var4) {
      this.code = var1;
      this.name = var2;
      this.credits = var3;
      this.grade = var4;
   }

   public String getCode() {
      return this.code;
   }

   public String getName() {
      return this.name;
   }

   public int getCredits() {
      return this.credits;
   }

   public String getGrade() {
      return this.grade;
   }

   public String toString() {
      return this.code + "|" + this.name + "|" + this.credits + "|" + this.grade;
   }
}
