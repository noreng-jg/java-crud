import java.util.List;

interface IRepository {
  void CreatePerson(String name, String PhoneNumber, int year, int month, int day, String gradeString);
  void UpdatePerson(int ID, String name, String PhoneNumber, int year, int month, int day, String gradeString);
  void DeletePerson(int ID);
  public Person RetrievePerson(int ID);
  List<Person> ListPersons();
}
