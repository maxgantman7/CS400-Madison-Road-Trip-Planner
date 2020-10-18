import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadTextFile {
	public static void main(String [] args) throws FileNotFoundException {
		RedBlackTree<City> tree = new RedBlackTree<City>();
		File file = new File("Destinations.txt");
		
		if(!file.exists()) { //Throws exception if File doesn't exist
			throw new FileNotFoundException("txt file with course information was not found");
		}
		
		String cityName = ""; // name of city to be added
		Scanner scan = new Scanner(file);
		String num = "";
		City city; // city object for the city to be added
		int dist; // distance of city to be added
		
		while(scan.hasNextLine()) { //Loops until no more lines are left in txt file
			cityName = scan.next(); // first word is the city name
			num = scan.next(); // second word is the distance from Madison
			dist = Integer.parseInt(num); // convert second word to an int
			city = new City(cityName, dist);
			tree.insert(city);
			if (scan.hasNextLine()) {
				scan.nextLine();
			}
		}
	}
}
