import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class FrontEnd {

  // How to connect front end to back end
  private static BackEnd back = new BackEnd();


  /**
   * This is a helper method to print out a divider with app name.
   */
  private static void topDivider() {
    for (int i = 0; i < 15; i++) {
      System.out.print("~");
    }
    System.out.print("| Madison Road Trip Finder |");
    for (int i = 0; i < 16; i++) {
      System.out.print("~");
    }
    System.out.println();
  }

  /***
   * Prints out divider without app name.
   */
  private static void bottomDivider() {
    for (int i = 0; i < 59; i++) {
      System.out.print("~");
    }
    System.out.println();
  }

  /**
   * This method prints out the help menu of commands
   */
  private static void help() {
    topDivider();
    System.out.print("*Commands and their description: \n"
        + "*h: Display the help menu\n"
        + "*i: Input distance in miles from Madison\n"
        + "*a: Add new city\n"
        + "*d: Display current route\n"
        + "*c: Clear trip\n"
        + "*f: Add file of cities\n"
        + "*q: Quit program\n");
    bottomDivider();
  }

  /**
   * This method will allow a user to add a class and data to the table
   */
  public static void addCity() throws NumberFormatException{
    Scanner scnr = new Scanner(System.in);
    // Data wrangler class
    String cityName;
    int miles;

    System.out.println("Enter the city name. EX: Milwaukee or NewYork");
    cityName = scnr.nextLine();

    System.out.println("Enter distance from Madison in miles. EX: 20");
    miles = scnr.nextInt();
    if(miles < 0){
      throw new NumberFormatException("Only positive distances please.");
    }

    System.out.println("Added " + cityName + " to route!");

    back.add(new City(cityName, miles));

    // help();
  }

  /**
   * This method creates an array list of city names and distances by reading a text file.
   */
  public static void dataWrangler(String fileName) throws FileNotFoundException {
    // if file not found
    File file = new File(fileName);
    if(!file.exists()){
      throw new FileNotFoundException("File not found!");
    }

    Scanner sc = new Scanner(file);
    Scanner sc2;
    String line;
    while (sc.hasNextLine()) {
      line = sc.nextLine();
      sc2 = new Scanner(line);
      sc2.useDelimiter(" ");
      String cityName = sc2.next();
      String dis = sc2.next().trim();
      double miles = Double.parseDouble(dis);

      back.add(new City(cityName, miles));

    }
    // help();
  }

  // Need inOrderTraversal method
  /**
   * Displays all cities and prices in regards to miles from Madison.
   * @return
   */
  public static String display(){
    LinkedList<City> temp  =  back.getTreeInOrder();
    String empty= "Madison, 0 miles ";
    for(City i: temp){
      empty += i.toString() + " ";
    }
    return empty;
    // Traverse linked list
  }

  private static boolean quit = false;

  public static void main(String args[]) {
    Scanner scnr = new Scanner(System.in);
    String file;
    String input;
    int miles;

    topDivider();
    System.out.println("Welcome to Road Trip Finder. Let's make a road trip!");
    bottomDivider();
    System.out.println();
    help();

    while (quit == false) {
      if (scnr.hasNext()) {
        input = scnr.nextLine();
        switch (input) {
          case "h":
            help();
            System.out.println("Enter another command:");
            break;
          case "i":
            System.out.println("Input distance from Madison in miles: ");
            miles = scnr.nextInt();
            System.out.println("These are all the cities within " + miles +
                " miles of Madison:");
            System.out.println(back.getCitiesWithin(miles).toString());
            System.out.println();
            System.out.println("*h: Display the help menu");
            break;
          case "a":
            System.out.println("Adding a new city.");
            try {
              addCity();
            } catch (NumberFormatException e){
              System.out.println("Not added. No negative distances. Try again.");
            }
            System.out.println();
            System.out.println("*h: Display the help menu");
            break;
          case "d":
            System.out.println("Current route: ");
            System.out.println(display());
            System.out.println();
            System.out.println("*h: Display the help menu");
            break;
          case "c":
            System.out.println("Clear trip");
            back.deleteAllCities();
            System.out.println();
            System.out.println("*h: Display the help menu");
            break;
          case "f":
            System.out.println("Insert file name: ");
            file = scnr.nextLine();
            try {
              dataWrangler(file);
            } catch (FileNotFoundException e) {
              System.out.println("File not found!");
            }
            System.out.println();
            System.out.println("*h: Display the help menu");
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
        System.out.println("Quitting program!");
        break;
      }
      continue;
    }

  }
}



