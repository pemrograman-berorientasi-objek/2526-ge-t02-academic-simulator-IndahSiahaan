package academic.model;

public class Student {
   private String id;
   private String name;
   private int entryYear;
   private String major;

   public Student(String var1, String var2, int var3, String var4) {
      this.id = var1;
      this.name = var2;
      this.entryYear = var3;
      this.major = var4;
   }

   public String getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public int getEntryYear() {
      return this.entryYear;
   }

   public String getMajor() {
      return this.major;
   }

   public String toString() {
      return this.id + "|" + this.name + "|" + this.entryYear + "|" + this.major;
   }
}
