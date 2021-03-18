package ch.hearc.business;

import java.util.HashMap;


public class Graph {
    private String name;
    private HashMap<String,Node> nodeList;

    public Graph(String name){
        nodeList = new HashMap<>();
        this.name = name;
    }

    public void addNode(Node n){
        nodeList.putIfAbsent(n.getName(), n);
    }

    public void addNode(String nodeName){
        nodeList.putIfAbsent(nodeName, new Node(nodeName));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Nom : " + this.name + "\n");

        for (Node n : this.nodeList.values()){
            sb.append("W++(" + n.getName() + ") = { " + n.wPlus() +"}\n");
        }
        return sb.toString();
    }

    public Node getNode(String nodeName){
        return this.nodeList.get(nodeName);
    }

    public void addEdge(String srcNodeName, String destNodeName, String edgeName, double metric){
        nodeList.putIfAbsent(srcNodeName, new Node(srcNodeName));
        nodeList.putIfAbsent(destNodeName, new Node(destNodeName));
        this.getNode(srcNodeName).addEdge(edgeName, this.getNode(destNodeName), metric);
    }

    public void removeNode(String nodeName){
        for (Node n : this.nodeList.values()){
            n.getOutEdges ().entrySet ().removeIf (e -> e.getValue ().getDest ().getName ().equalsIgnoreCase (nodeName));
        }
        this.nodeList.remove (name);
    }

    public void removeEdge(String edgeName){
        for (Node n : this.nodeList.values()){
            n.getOutEdges ().entrySet ().removeIf (e -> e.getValue ().getName ().equalsIgnoreCase (edgeName));
        }
    }
}
