package ch.hearc.business;

import java.util.HashMap;


public class Node {
    private String name;
    private HashMap<String, Edge> outEdges;

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
}
