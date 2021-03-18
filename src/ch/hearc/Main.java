package ch.hearc;

import ch.hearc.business.Graph;
import ch.hearc.business.Node;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph("G1");

        /*
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
    }
}
