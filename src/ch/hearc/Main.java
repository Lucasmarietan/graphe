package ch.hearc;

import ch.hearc.business.*;
import ch.hearc.utils.FileUtils;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph("G1");

        /* Ancienne méthode pour ajouter les noeuds
        g.addNode("x1");
        g.addNode("x2");
        Node src = g.getNode("x1");
        Node dest = g.getNode("X2");
        Node n = g.getNode("x1");
        src.addEdge("u1", dest, 45);
        */

        g.addEdge("x1", "x2", "u1", 34);
        g.addEdge("x2", "x3", "u2", 34);
        // g.removeNode("x2");
        // g.removeEdge("u1");
        System.out.println(g.toString());

        FileUtils.save(g, "Graphe-SNAPSHOT");
        Graph gCOPIE = FileUtils.load("Graphe-SNAPSHOT");

        System.out.println(gCOPIE.toString());

        System.out.println("--------------------------------------------------------------------------------------------------------------");


        Graph graphFriendship = new Graph("Friendship");
        Person jain = new Person("jain", "La chaux de fond");
        Person tanguy = new Person("tanguy", "La chaux de fond");
        Person manu = new Person("manu", "Lausanne");
        Person lucas = new Person("lucas", "Lausanne");

        graphFriendship.addNode(jain);
        graphFriendship.addNode(tanguy);
        graphFriendship.addNode(manu);
        graphFriendship.addNode(lucas);

        jain.addFriend("a1", tanguy, 34);
        jain.addFriend("a2", manu, 15);
        tanguy.addFriend("a1", lucas, 16);

        Receipt ravioli = new Receipt("lucas");
        graphFriendship.addNode(ravioli);
        jain.cook("b1", ravioli, 10);

        System.out.println(graphFriendship.navigateWidth(jain));
        System.out.println(graphFriendship.navigateWidthLevelClass(jain, 1, Cook.class));

        System.out.println(graphFriendship.toString());


    }
}
