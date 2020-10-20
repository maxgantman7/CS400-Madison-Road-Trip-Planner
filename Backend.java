// --== CS400 File Header Information ==--
// Name: Dennis Kelly
// Email: dfkelly2@wisc.edu
// Team: fd
// TA: Abhay
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.LinkedList;
public class Backend {
    private RedBlackTree<City> tree = new RedBlackTree();
    private LinkedList<City> traversedCities = new LinkedList(); // varible that is reused to temporarily store city lists




    /**
     * This method will return a linked list of the cities within the given distance from Madison
     * @param distance the distance around madison to find cities
     * @return a linked list of the City objects within the given distance
     */
    public LinkedList<City> getCitiesWithin(int distance){
        LinkedList<City> citiesWithin = new LinkedList<>();

        // get the in order tree stored into the traversedCities field;
       getTreeInOrder();

        for (City city : traversedCities ){ // search through each city until the distance exceeds the users search
            if (city.getDistance() <= distance){
                citiesWithin.add(city);
            }
            else {
                return citiesWithin;
            }
        }

        return citiesWithin;
    }

    /**
     * This method will return the RB Tree
     */
    public RedBlackTree<City> getTree(){
        return this.tree;
    }

    /**
     * This method will return a list storing an in order traversal of the red black tree
     * @return an in order traversal of the red black tree
     */
    public LinkedList<City> getTreeInOrder(){
        //clear the list of traversed cities
         traversedCities = new LinkedList();
        // call the helper method to traverse and gather the cities into the traversedCities field
        helpGetTreeInOrder(tree.root);


        return traversedCities;
    }

    /**
     * This method will help to traverse and store the whole tree in order.
     *
     * @param current is the node currenly being visited in the list
     * @return none
     */
    private void helpGetTreeInOrder(RedBlackTree.Node<City> current){
        if (current != null){
            // recursive call down left side
            helpGetTreeInOrder(current.leftChild);
            // add to the list
            traversedCities.add(current.data);
            // recursive call down the right side
            helpGetTreeInOrder(current.rightChild);
        }
        return;
    }

    /**
     * This method will add a City object to the red black tree.
     * @param city the city to be added to the tree
     */
    public void add(City city){
    try {
        tree.insert(city);
    }
    catch (IllegalArgumentException e){ // catch an exception thrown if the tree already contained that city
        System.out.println(e.getMessage()); // potentially change depending on how we want to implement
    }
    catch (NullPointerException e1) { // catch an exception thrown if the data passed in is null
        System.out.println(e1.getMessage()); // potentially change depending on how we want to implement
    }
        return;
    }

    /**
     * This method will clear all the cities from the current red black tree
     */
    public void deleteAllCities(){
        this.tree = new RedBlackTree<>();
    }

}
