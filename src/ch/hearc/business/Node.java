package ch.hearc.business;

import java.io.Serializable;
import java.util.HashMap;


public class Node implements Serializable {
    private String name;
    private HashMap<String, Edge> outEdges;
    private int degreeIn;
    private int degreeOut;
    private boolean discovered;

    public void setDegreeIn(int degreeIn) {
        this.degreeIn = degreeIn;
    }

    public int getDegreeIn() {
        return degreeIn;
    }

    public void setDegreeOut(int degreeOut) {
        this.degreeOut = degreeOut;
    }

    public String getName() {
        return name;
    }


    public Node(String name){
        this.name = name;
        outEdges = new HashMap<String, Edge>();
    }

    public HashMap<String, Edge> getOutEdges() {
        return outEdges;
    }

    public String wPlus(){
        StringBuilder sb = new StringBuilder();
        for (Edge e : this.outEdges.values()){
            sb.append(" (" + e.getName() + "," + e.getDest().getName() + "," + e.getMetric() + ")");
        }
        return sb.toString();
    }

    public void addEdge(String edgeName, Node dest, double metric) {
        outEdges.putIfAbsent(edgeName, new Edge(edgeName, dest, metric));
    }

    public int computeOutEdges() {
        int i = 0;
        for (Edge e : this.outEdges.values()) {
            i += e.getMetric();
        }
        return i;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }


}
