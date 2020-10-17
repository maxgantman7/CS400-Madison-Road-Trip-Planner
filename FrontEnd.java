import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrontEnd {

  // How to connect front end to back end
  // private static BackEnd back = new BackEnd();
  private static BackEnd back = new BackEnd();
  // public static RedBlackTree getTree(){
    // return back.getTree();
 // }

  // Need dataWrangler method

  /**
   * This is a helper method to print out a divider of 25 "-"
   */
  private static void divider() {
    for (int i = 0; i < 30; i++) {
      System.out.print("<|>");
    }
    System.out.println("");
  }

  /**
   * This method prints out the help menu of commands
   */
  private static void help() {
    divider();
    System.out.print("*Commands and their description: \n"
        + "*h: Display the help menu\n"
        + "*i: Input distance in miles from Madison\n"
        + "*a: Add new city\n"
        + "*d: Delete a city\n"
        + "*dd: Delete all cities\n"
        + "*f: Add file of cities\n"
        + "*q: Quit program\n");
    divider();
  }

  /**
   * This method will allow a user to add a class and data to the table
   */
  public static void addCity() {
    Scanner scnr = new Scanner(System.in);

    // Data wrangler class
    AcademicClass course;
    String cityName;
    double miles;
    double gasPrice;
    double totalCost;


    System.out.println("Enter the city name. EX: Milwaukee or New York");
    cityName = scnr.nextLine();

    System.out.println("Enter distance from Madison in miles. EX: 20.3");
    miles = scnr.nextDouble();

    System.out.println("Enter gas price per mile. EX 2.1");
    gasPrice = scnr.nextDouble();
    totalCost = gasPrice * miles;

    // Data wrangler class
    city = new AcademicClass(classCode, gpa, percentA, percentF);

    System.out.println("Added city " + cityName);

    back.insert(city);

    help();
  }

  // Need inOrderTraversal method
  /**
   * Displays all cities and prices in regards to miles from Madison.
   * @return
   */
  public static String display(){
    // Maybe can only add up to ten cities???
    String display = "";
    for(int i = 0, i < )
      display += //add all get methods and toString
  }

  private static boolean quit = false;

  public static void main(String args[]) {
    Scanner scnr = new Scanner(System.in);
    String input = "";

    while (quit == false) {
      if (scnr.hasNext()) {
        switch (input) {
          case "h":
            help();
            System.out.println("Enter another command:");
            break;
          case "i":
            System.out.println("Inputing distance.");
            // can this return
            break;
          case "a":
            System.out.println("Adding a new city.");
            addCity();
            break;
          case "d":
            System.out.println("Deleting a city.");
            break;
          case "dd":
            System.out.println("Deleting all cities.");
            break;
          case "f":
            System.out.println("Add file of cities: ");
            String fileName = scnr.next();
            try {
              dataWrangler(fileName);
            } catch (FileNotFoundException e) {
              System.out.println("File not found!");
            }
            System.out.println("Enter another command:");
            break;
          case "q":
            quit = true;
            break;
          default:
            System.out.println("Invalid command: \"" + input + "\"  (type h for help)");
            System.out.println("Enter another command:");

        }
      } else {
        continue;
      }

      if (quit == true) {
        System.out.println("Quitting program");
        break;
      }
      continue;
    }

      }
    }



