run: compile
        java FrontEnd

compile:
        City.class RedBlackTree.class BackEnd.class FrontEnd.class

City.class: City.java
        javac City.java

RedBlackTree.class: RedBlackTree.java
        javac RedBlackTree.java

BackEnd.class: BackEnd.java
        javac BackEnd.java

FrontEnd.class: FrontEnd.java
        javac FrondEnd.java

test: RoadTripTester.java
        javac RoadTripTester.java

clean:
        $(RM) *.class