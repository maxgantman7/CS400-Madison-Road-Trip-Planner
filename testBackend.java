import java.util.LinkedList;

public class testBackend {

    public static void main(String args[]){
        Backend back = new Backend();

        back.add(new City("Minneapolis", 100));
        back.add(new City("Dallas", 56));
        back.add(new City("Buffalo", 72));
        back.add(new City("Tallahasse", 120));
        back.add(new City("Woodbury", 133));
//        back.add(new City("Eagan", 22));
//        back.add(new City("Hastings", 11));
//        back.add(new City("Farmington", 110));





        RedBlackTree<City> tempTree = back.getTree();
        System.out.println(tempTree.toString());

        if (!(tempTree.toString().equals("[72, 56, 120, 100, 133]"))){
            System.out.println("TEST FAILED: TREE IN INCORRECT ORDER");
        }
        else {
            System.out.println("TEST PASSED!");
        }
       // System.out.println(cities.size());
//        int previousDistance = 0;
//        for (City city : cities) {
//            System.out.print("Name : " + city.getName() + "  Distance : " + city.getDistance());
//            if (!(city.getDistance() > previousDistance)){
//                System.out.println(" Error: distances not reported in order");
//            }
//            else {
//                System.out.println(" added this successfully");
//            }
//            previousDistance = city.getDistance();
//        }
    }
}
