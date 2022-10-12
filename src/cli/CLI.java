import java.time.LocalDate;
import java.util.Scanner;

public class CLI {
  public IRepository repo = null;
  public Scanner scanner = null;

  public CLI(IRepository repo, Scanner scanner) {
    this.repo = repo;
    this.scanner = scanner;
  }

  public void ShowMenu() {
    System.out.println("--------------------------------------");
    System.out.println("--------------crudJAVA----------------");
    System.out.println("--------------------------------------");
    System.out.println("Choose one of the following options: ");
    System.out.println("--------------------------------------");
    System.out.println("1 - Create person or student");
    System.out.println("2 - Retrieve all persons and students");
    System.out.println("3 - Update person/student data");
    System.out.println("4 - Delete person/student");
    System.out.println("5 - Finish operations");
    System.out.println("--------------------------------------");
  }

  public void cleanConsole() {
    System.out.println("\033[H\033[2J");
    System.out.flush();
  }

  public void HandlePersonInput(Boolean update, int id) {
    String name;
    int year;
    int month;
    int day;
    String phonenumber;
    double grade;

    System.out.print("Enter person name: ");
    name = this.scanner.nextLine();
    System.out.println(" ");

    System.out.print("Enter person phone number: ");
    phonenumber = this.scanner.nextLine();
    System.out.println(" ");

    System.out.print("Enter person birth year: ");
    String yearString = this.scanner.nextLine();
    year = Integer.valueOf(yearString);
    System.out.println(" ");

    System.out.print("Enter person birth month: ");
    String monthString = this.scanner.nextLine();
    month = Integer.valueOf(monthString);
    System.out.println(" ");

    System.out.print("Enter person birth day: ");
    String dayString = this.scanner.nextLine();
    day = Integer.valueOf(dayString);
    System.out.println(" ");

    System.out.print("The grade scored in the course [n/N: in case not] ?: ");
    String gradeString = this.scanner.nextLine();
    System.out.println(" ");

    if (!update) {
      this.repo.CreatePerson(name, phonenumber, year, month, day, gradeString);
    } else {
      this.repo.UpdatePerson(id, name, phonenumber, year, month, day, gradeString);
    }
  }

  public int HandleGetID() {
    System.out.print("Enter person ID: ");
    String idString = this.scanner.nextLine();
    int id = Integer.valueOf(idString);

    Person p = this.repo.RetrievePerson(id);

    if (p != null) {
      return id;
    }

    return -1;
  }

  public int HandleOptions(String input) {
    try {
      int value = Integer.valueOf(input);

      switch (value) {
        case 1:
          this.cleanConsole();
          System.out.println("=========== Create Person =================");
          this.HandlePersonInput(false, 0);
          return 0;
        case 2:
          this.cleanConsole();
          System.out.println("========= Retrieve All Persons ============");
          System.out.print(String.format("%1$-" + 4 + "s", "ID"));
          System.out.print(" | ");
          System.out.print(String.format("%1$-" + 24 + "s", "Name"));
          System.out.print(" | ");
          System.out.print(String.format("%1$-" + 14 + "s", "Phone Number"));
          System.out.print(" | ");
          System.out.print("Birthday  ");
          System.out.print(" | ");
          System.out.print("Created At");
          System.out.print(" | ");
          System.out.print("Updated At");
          System.out.print(" | ");
          System.out.print("Type   ");
          System.out.print(" | ");
          System.out.println("Grade");

          this.repo.ListPersons();
          return 3;
        case 3:
          this.cleanConsole();
          System.out.println("=========== Update Person =================");
          int id = HandleGetID();
          if (id == -1) {
            throw new Exception("Invalid ID");
          }

          this.HandlePersonInput(true, id);

          break;
        case 4:
          this.cleanConsole();
          System.out.println("=========== Delete Person =================");
          int Pid = HandleGetID();
          if (Pid == -1) {
            throw new Exception("Invalid ID");
          }

          this.repo.DeletePerson(Pid);

          return 3;
        case 5:
          System.out.println("exiting...");
          return 1;
        default:
          this.cleanConsole();
          System.out.println("Invalid option...");
          break;
      }

      return 0;
    } catch (Exception e) {
      System.out.print("[ERROR]: ");
      System.out.println(e);
      System.out.println("\nAn error ocurred, invalid input, try again...");
      return 3;
    }
  }
}
