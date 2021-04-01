package ch.hearc.business;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Graph implements Serializable {
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

    public void reInit(){
        for (Node n : nodeList.values()){
            n.setDegreeIn(0);
            n.setDegreeOut(0);
        }
    }

    public void computeDegree(){
        reInit();
        for (Node n : nodeList.values()){
            n.computeOutEdges();
            for (Edge e : n.getOutEdges().values()){
                e.getDest().setDegreeIn(n.getDegreeIn()+1);
            }
        }
    }

    public List<Node> navigateWidth(Node startNode) {
        reInit();
        List<Node> result = new LinkedList<>();
        LinkedList<Node> file = new LinkedList<>();
        file.addFirst(startNode);
        startNode.setDiscovered(true);
        while(!file.isEmpty()) {
            Node currentNode = file.removeLast();
            result.add(currentNode);
            for (Edge edge : currentNode.getOutEdges().values()) {
                Node destinationNode = edge.getDest();
                if (!destinationNode.isDiscovered()) {
                    file.addFirst(destinationNode);
                    destinationNode.setDiscovered(true);
                }
            }
        }
        return result;
    }

    public List<Node> navigateDepth(Node startNode) {
        reInit();
        List<Node> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(startNode);
        startNode.setDiscovered(true);
        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            result.add(currentNode);
            for (Edge edge : currentNode.getOutEdges().values()) {
                Node destinationNode = edge.getDest();
                if (!destinationNode.isDiscovered()) {
                    stack.push(destinationNode);
                    destinationNode.setDiscovered(true);
                }
            }
        }
        return result;
    }
}
