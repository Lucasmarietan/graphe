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

        /* PARTIE 1
        g.addEdge("x1", "x2", "u1", 34);
        g.addEdge("x2", "x3", "u2", 34);
        // g.removeNode("x2");
        // g.removeEdge("u1");
        System.out.println(g.toString());

        FileUtils.save(g, "Graphe-SNAPSHOT");
        Graph gCOPIE = FileUtils.load("Graphe-SNAPSHOT");

        System.out.println(gCOPIE.toString());
        */
//        System.out.println("--------------------------------------------------------------------------------------------------------------");

        /* PARTIE 2
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
        */

        System.out.println("Exercice GrapheLimiteTypes \n");
        Graph grapheL = new Graph("GLT");
        Person paul = new Person("Paul", "Neuchâtel");
        Person albert = new Person("Albert", "Lausanne");
        Person julie = new Person("Julie", "Cernier");
        Person jean = new Person("Jean", "Neuchâtel");
        Person alfred = new Person("Alfred", "Lausanne");
        Person lucie = new Person("Lucie", "Neuchâtel");

        WebSite netflix = new WebSite("Netflix");
        WebSite disney = new WebSite("Disney +");
        WebSite apv = new WebSite("Amazon Prime Video");

        grapheL.addNode(jean);
        grapheL.addNode(albert);
        grapheL.addNode(julie);
        grapheL.addNode(paul);
        grapheL.addNode(alfred);
        grapheL.addNode(lucie);

        grapheL.addNode(netflix);
        grapheL.addNode(disney);
        grapheL.addNode(apv);
        System.out.println("test type " + jean.getClass());


        jean.addFriend("a1", alfred, 25);
        paul.addFriend("a2", jean, 25);
        paul.addFriend("a3", lucie, 25);
        paul.addFriend("a4", julie, 25);
        julie.addFriend("a5", albert, 25);


        albert.watch("r1", apv, 20);
        albert.watch("r2", disney, 20);
        alfred.watch("r3", netflix, 20);
        lucie.watch("r4", apv, 20);
        lucie.watch("r5", netflix, 20);
        paul.watch("r6", apv, 20);
        paul.watch("r7", netflix, 20);

        System.out.println(grapheL.navigateWidthLevelClass(paul, 1, netflix.getClass()));

    }
}
