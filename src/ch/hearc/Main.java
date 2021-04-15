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
//        System.out.println("test type " + jean.getClass());


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

        System.out.println("\n Question 1 : Lister tous les sites de streaming regardés par Paul ");
        for (Node node : grapheL.navigateWidthLevelClass(paul, 1, Watch.class)){
            System.out.println(node.getName());
        }


        System.out.println("\n Question 2 :  Donner tous les amis de Paul jusqu’au 2e niveau qui regardent un site de streaming ");
        // ca marche pas ntm stéphane
        for (Node n : grapheL.navigateWidthLevelClass(paul, 2, IsFriend.class)) {
            if (grapheL.navigateWidthLevelClass(n, 2, Watch.class).size() > 1) {
                System.out.println(n.getName());
            }
        }

        System.out.println("\n Question 3 : Lister tous les amis (1er niveau) de Paul qui habitent à NE et qui regardent Amazon Prime Video");
        for (Node n : grapheL.navigateWidthLevelClass(paul, 1, IsFriend.class)) {
            Person p = (Person) n;
            if (p.getCity().equals("Neuchâtel")) {
                if (grapheL.navigateWidthLevelClass(n, 1, Watch.class).contains(apv)) {
                   System.out.println(n.getName());
                }
            }
        }
//        Question 3 V2
//        System.out.println("Amis de 1er niveau de Paul qui regardent Amazon Prime Video");
//        for (Node n : socialNetworkExtended.navigateWidthWithLevelAndType(paul, 1, Friendship.class)) {
//            Person p = (Person) n;
//            if (p.getCity().equals("Neuchâtel")) {
//                if (socialNetworkExtended.navigateWidthWithLevelAndType(n, 1, Watching.class).contains(socialNetworkExtended.getNode("Amazon Prime Video"))) {
//                    System.out.println(n.getName());
//                }
//            }
//        }


    }
}
