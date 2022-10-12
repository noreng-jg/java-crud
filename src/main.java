import java.util.Scanner;

class main {
  static public void main(String[] args) {
    FakeRepository repo = new FakeRepository();
    Scanner scanln = new Scanner(System.in);
    CLI cli = new CLI(repo, scanln);

    try {
        mainLoop(cli);
    } catch (Exception e) {
        System.out.println(e);
        System.out.println("exiting ...");
      }
  }

  static public void mainLoop(CLI cli) {
      while (true) {
          cli.ShowMenu();

          System.out.print("\nEnter option here: ");
          String input;
          input = cli.scanner.nextLine();

          int status = cli.HandleOptions(input);

          if (status == 0) {
            cli.cleanConsole();
          }

          if (status == 3) {
            System.out.print("\n\n\nPress any key to return to menu: ");
            input = cli.scanner.nextLine();
            cli.cleanConsole();
          }

          if (status == 1) {
            cli.scanner.close();
            break;
          }
        }
  }
}
