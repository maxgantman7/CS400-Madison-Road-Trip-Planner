import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * Tests all functions of app.
 */
public class TestTripClass {

    /**
     * Checks whether the implementation of class information like Distance, and the Name of the city
     * are correctly returned and modified 
     */
   @Test
  public void testConstructor(){ 
    City city = new City("Seattle", 1904);
    if(city.getDistance() != 1904) {
      fail("getDistance() failed");
    }
    if(!city.getName().equals("Seattle")) {
      fail("getName() failed");
    }
    city.setName("Portland");
    city.setDistance(1983);
    if(city.getDistance() != 1983) {
        fail("getDistance() failed after setDistance()");
      }
    if(!city.getName().equals("Portland")) {
        fail("getName() failed after setName()");
    }

  }
   /**
    * Test whether cities are being added to the tree correctly
    */
   @Test
   public void testAdd() {
	   Backend back = new Backend();
	   back.add(new City("Seattle", 1904));
	   back.add(new City("Portland", 1983));
	   back.add(new City("SanFrancisco", 2086));
	   RedBlackTree<City> tree = back.getTree();
	   if(!tree.toString().equals("[Portland 1983, Seattle 1904, SanFrancisco 2086]")) {
		   System.out.println(tree.toString());
		   fail("add() failed, incorrect order ");	   
	   }
	   try { //adding duplicate city
		   back.add(new City("Seattle", 1904));
	   }
	   catch(IllegalArgumentException e) {
		   //Should be caught
	   }
	   try {
		   back.add(null);
	   }
	   catch(NullPointerException e1) {
		   //should be caught 
	   }
	   
	   //ADD MORE TESTS HERE   
   }
   /**
    * Tests implementation of deleteAllCities() method in 
    * Backend
    */
   @Test
   public void testdeleteAllCities() {
	   Backend back = new Backend();
	   back.add(new City("Seattle", 1904));
	   back.add(new City("Portland", 1983));
	   back.add(new City("SanFrancisco", 2086));
	   back.deleteAllCities();
	   RedBlackTree<City> tree = back.getTree();
	   if(tree == null) {
		   fail();
	   }
   }
   @Test
   public void testGetCitiesWithin() {
	   Backend back = new Backend();
	   back.add(new City("Seattle", 1904));
	   back.add(new City("Portland", 1983));
	   back.add(new City("SanFrancisco", 2086));
	   System.out.println(back.getCitiesWithin(2000).toString());
	   if(!back.getCitiesWithin(2000).toString().equals("[Seattle 1904, Portland 1983]")) {
		   fail("getCitiesWithin() failed");
	   }
   }
   @Test
   public void testGetTree() {
	   Backend back = new Backend();
	   back.add(new City("Seattle", 1904));
	   back.add(new City("Portland", 1983));
	   back.add(new City("SanFrancisco", 2086));
	   //System.out.println(back.getTree().toString());
	   if(!back.getTree().toString().equals("[Portland 1983, Seattle 1904, SanFrancisco 2086]")) {
		   fail("getTree() failed");
	   }
   }
   @Test
   public void testGetTreeInOrder() {
	   Backend back = new Backend();
	   back.add(new City("Seattle", 1904));
	   back.add(new City("Portland", 1983));
	   back.add(new City("SanFrancisco", 2086));
	   back.add(new City("StLouis", 359));
	   System.out.println(back.getTreeInOrder().toString());
   }
   

   // Reading from text file properly
   @Test
   public void testReadFile(){
     // If file does not exist
     try {
       FrontEnd.dataWrangler("Destinations.txt");
     } 
     catch (FileNotFoundException e1){
       if(e1.getMessage() == null || !e1.getMessage().equals("File not found!")){
         fail("FileNotFoundException not working.");
       }
     } 
     catch (Exception e2){
       System.out.println("Another Exception not working.");
     }

     // If file does exist
     try {
       FrontEnd.dataWrangler("UWClasses.txt");
     } 
     catch (FileNotFoundException e1){
       if(e1.getMessage() == null || !e1.getMessage().equals("File not found!")){
    	   fail("FileNotFoundException not working.");
       }
     } 
     catch (Exception e2){
       fail("Another Exception not working.");
     }
   }
}