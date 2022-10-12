import java.time.LocalDate;

public class Student extends Person {
  public double Grade;

  public Student(int ID, String Name, String PhoneNumber, int year, int month, int day, double grade) {
    super(ID, Name, PhoneNumber, year, month, day);
    this.Grade = grade;
  }

  public Student(int ID, String Name, String PhoneNumber, int year, int month, int day, double grade, LocalDate created) {
    super(ID, Name, PhoneNumber, year, month, day, created);
    this.Grade = grade;
  }

  public void ViewAsRow() {
    System.out.print(String.format("%1$-" + 4 + "s", this.ID));
    System.out.print(" | ");
    System.out.print(String.format("%1$-" + this.padding + "s", this.Name));
    System.out.print(" | ");
    System.out.print(String.format("%1$-" + 14 + "s", this.PhoneNumber));
    System.out.print(" | ");
    System.out.print(this.Birthday);
    System.out.print(" | ");
    System.out.print(this.CreatedAt);
    System.out.print(" | ");
    System.out.print(this.UpdatedAt);
    System.out.print(" | ");
    System.out.print("Student");
    System.out.print(" | ");
    System.out.println(this.Grade);
  }
}; 
