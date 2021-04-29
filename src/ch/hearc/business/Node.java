package ch.hearc.business;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Node implements Serializable {
    private String name;
    private HashMap<String, Edge> outEdges;
    private int degreeIn;
    private int degreeOut;
    private boolean discovered; // Marquage comme quoi on est passé dessus
    private int level;
    private int dijkstraWeight = 0;
    private Node dijkstraPredecessor = null;
    private Map<String, TripletDijkstra> routingTable;

    public int getDijkstraWeight() {
        return dijkstraWeight;
    }

    public void setDijkstraWeight(int dijkstraWeight) {
        this.dijkstraWeight = dijkstraWeight;
    }

    public Node getDijkstraPredecessor() {
        return dijkstraPredecessor;
    }

    public void setDijkstraPredecessor(Node dijkstraPredecessor) {
        this.dijkstraPredecessor = dijkstraPredecessor;
    }

    public Map<String, TripletDijkstra> getRoutingTable() {
        return routingTable;
    }

    public void setRoutingTable(Map<String, TripletDijkstra> routingTable) {
        this.routingTable = routingTable;
    }


    /**
     * Constructeur
     */
    public Node(String name){
        this.name = name;
        outEdges = new HashMap<String, Edge>();
    }


    /**
     * Fonctions
     */

    public String wPlus(){
        StringBuilder sb = new StringBuilder();
        for (Edge e : this.outEdges.values()){
            sb.append(" (" + e.getName() + "," + e.getDest().getName() + "," + e.getMetric() + ")");
        }
        return sb.toString();
    }

    public void addEdge(String edgeName, Node dest, int metric) {
        outEdges.putIfAbsent(edgeName, new Edge(edgeName, dest, metric));
    }

    public void addEdge(Edge edge) {
        outEdges.putIfAbsent(edge.getName(), edge);
    }

    public int computeOutEdges() {
        int i = 0;
        for (Edge e : this.outEdges.values()) {
            i += e.getMetric();
        }
        return i;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", outEdges=" + outEdges +
                ", degreeIn=" + degreeIn +
                ", degreeOut=" + degreeOut +
                ", discovered=" + discovered +
                ", level=" + level +
                '}';
    }

    /**
     * Getter / Setter
     */

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public HashMap<String, Edge> getOutEdges() {
        return outEdges;
    }



}
