import java.time.LocalDate;

public class Person {
  public String Name;
  public int ID;
  public String PhoneNumber;
  public LocalDate Birthday;
  public LocalDate CreatedAt;
  public LocalDate UpdatedAt;

  protected int padding = 24;

  public Person(int ID, String Name, String PhoneNumber, int year, int month, int day) {
    this.Name = Name;
    this.ID = ID;
    this.PhoneNumber = PhoneNumber;
    this.Birthday = LocalDate.of(year, month, day);
    this.CreatedAt = LocalDate.now();
    this.UpdatedAt = LocalDate.now();
  }

  public Person(int ID, String Name, String PhoneNumber, int year, int month, int day, LocalDate created) {
    this.Name = Name;
    this.ID = ID;
    this.PhoneNumber = PhoneNumber;
    this.Birthday = LocalDate.of(year, month, day);
    this.CreatedAt = created;
    this.UpdatedAt = LocalDate.now();
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
    System.out.print("Person ");
    System.out.print(" | ");
    System.out.println(" - ");
  }
}
