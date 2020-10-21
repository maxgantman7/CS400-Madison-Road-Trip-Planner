// --== CS400 File Header Information ==--
// Name: Alex Barkmeier and Larry Goldman
// Email: barkmeier@wisc.edu, ldgoldman@wisc.edu
// Team: fd
// TA: Abhay
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

/**
 * Class that represents cities and holds their data
 */
public class City implements Comparable<City> {

	private String name; // name of the city
	private int distance; // distance from Madison
	
	public City (String name, int dist) {
		this.name = name;
		this.distance = dist;
	}
	
	
	/**
	 * Returns the distance between this city and Madison
	 * @return the distance between this city and Madison
	 */
	public int getDistance() {
		return this.distance;
	}
	
	/**
	 * Returns the name of this city
	 * @return the name of this city
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets a new name for this city
	 * @param newName - the new name for this city
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * Set a new distance between this city and Madison
	 * @param dist - the new distance between this city and Madison
	 */
	public void setDistance(int dist) {
		this.distance = dist;
	}
	
public String printTrip(){
    return "-------> " + this.name + " " + this.distance + " miles";
  }
	
	@Override
  public String toString(){
    String temp = "";
    temp += this.name + " " + this.distance;
    return (temp);
  }
	
	/**
	 * Compares the distance of this city from Madison to the distance
	 * from Madison of another city.
	 * @param other - the city being compared to
	 * @return 0 if the distances are equal, a negative number if this
	 * 		   city is closer to Madison than the other, or a positive
	 * 		   number if this city is further from Madison.
	 */
	@Override
	public int compareTo(City other) {
		if (this.distance == other.getDistance()) {
			// if the distances are equal
			return 0;
		}
		else if (this.distance < other.getDistance()) {
			// if this city is closer to Madison than "other"
			return -1;
		}
		else {
			// if this city is further from Madison than "other"
			return 1;
		}
	}

	
}
