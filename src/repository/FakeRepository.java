import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class FakeRepository implements IRepository {
  private List<Person> data = new ArrayList<>();
  private int idCounter = 0;

  public Person RetrievePerson(int ID) {
    try  {
      for (Person p: this.data) {
        if (p.ID == ID) {
          return p; 
        }
      }

      throw new Exception("Person not found");
    } catch (Exception e) {
      return null;
    }
  }

  public void CreatePerson(String name, String PhoneNumber, int year, int month, int day, String gradeString) {
    System.out.println("creating person...");
    this.idCounter++;

    Person p;

    if (gradeString.equals("n") || gradeString.equals("N") || gradeString.equals("")) {
      p = new Person(this.idCounter, name, PhoneNumber, year, month, day);
    } else {
      double grade = Double.parseDouble(gradeString);
      p = new Student(this.idCounter, name, PhoneNumber, year, month, day, grade);
    }

    this.data.add(p);
  }

  public void UpdatePerson(int ID, String name, String PhoneNumber, int year, int month, int day, String gradeString) {
    System.out.println("updating person...");
    for (int i=0 ; i < this.data.size(); i++) {
      if (this.data.get(i).ID == ID) {
        if (gradeString.equals("n") || gradeString.equals("N") || gradeString.equals("")) {
          Person replace = new Person(i+1, name, PhoneNumber, year, month, day, this.data.get(i).CreatedAt);
          this.data.set(i, replace);
        } else {
          double grade = Double.parseDouble(gradeString);
          Person replace = new Student(i + 1, name, PhoneNumber, year, month, day, grade, this.data.get(i).CreatedAt);
          this.data.set(i, replace);
        }
      }
    }
  }

  public void DeletePerson(int ID) {
    System.out.println("deleting person...");
    for (int i=0; i < this.data.size(); i++) {
      if (this.data.get(i).ID == ID) {
        this.data.remove(i);
      }
    }
  }

  public List<Person> ListPersons() {
    System.out.println("-----------------------------------------------------------------------------------------------");

    for (Person person: this.data) {
      person.ViewAsRow();
    }

    return this.data;
  }
}
