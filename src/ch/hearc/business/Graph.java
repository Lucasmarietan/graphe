package ch.hearc.business;

import java.io.Serializable;
import java.util.*;


public class Graph implements Serializable {
    private String name;
    private HashMap<String,Node> nodeList;

    /**
    * CONSTRUCTEUR
     */
    public Graph(String name){
        nodeList = new HashMap<>();
        this.name = name;
    }

    /**
     * Fonctions
     */

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

    public void addEdge(String srcNodeName, String destNodeName, String edgeName, int metric){
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

    // Navigation en largeur : On part d'un noeud, on explore tout ses voisins et ainsi de suite
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

    // Navigation en largeur mais avec une limitation de niveau
    public List<Node> navigateWidthLevel(Node startNode, int levelMax) {
        reInit();
        List<Node> result = new LinkedList<>();
        LinkedList<Node> file = new LinkedList<>();
        file.addFirst(startNode);
        startNode.setDiscovered(true);
        startNode.setLevel(0);
        while(!file.isEmpty()) {
            Node currentNode = file.removeLast();
            result.add(currentNode);
            if (currentNode.getLevel() < levelMax) {
                for (Edge edge : currentNode.getOutEdges().values()) {
                    Node destinationNode = edge.getDest();
                    if (!destinationNode.isDiscovered()) {
                        file.addFirst(destinationNode);
                        destinationNode.setDiscovered(true);
                    }
                }
            }
        }
        return result;
    }

    // Navigation en largeur mais avec une limitation de niveau
    public List<Node> navigateWidthLevelClass(Node startNode, int maxLevel, Class edgeType) {
        reInit();
        List<Node> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(startNode);
        startNode.setDiscovered(true);
        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            result.add(currentNode);
            if (currentNode.getLevel() < maxLevel) {
                for (Edge edge : currentNode.getOutEdges().values()) {
                    if(edge.getClass() == edgeType) {
                        Node destinationNode = edge.getDest();
                        if (!destinationNode.isDiscovered()) {
                            stack.push(destinationNode);
                            destinationNode.setDiscovered(true);
                            destinationNode.setLevel(currentNode.getLevel()+1);
                        }
                    }
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

    /**
     * Getter / Setter
     */

    public Node getNode(String nodeName){
        return this.nodeList.get(nodeName);
    }

    private void dijkstra(Node startNode) {
        startNode.setDijkstraWeight(0);
        List<Node> priorityList = new ArrayList<>();
        Node currentNode;
        Node destinationNode;
        Edge tmpEdge;
        int currentWeight;
        priorityList.add(startNode);

        while (!priorityList.isEmpty()){
            Collections.sort(priorityList, new DijkstraNodeComparator());
            currentNode = (Node) priorityList.remove(0);
            String pred = currentNode.getDijkstraPredecessor() == null ? "" : currentNode.getName();
            System.out.println(currentNode + " / " + currentNode.getDijkstraWeight() + " / " + currentNode.getDijkstraPredecessor());
            startNode.getRoutingTable().put(currentNode.getName(), new TripletDijkstra(currentNode.getName(), pred, currentNode.getDijkstraWeight()));

            for (Iterator ita = currentNode.getOutEdges().values().iterator(); ita.hasNext();) {
                tmpEdge = (Edge) ita.next();
                destinationNode = tmpEdge.getDest();
                currentWeight = currentNode.getDijkstraWeight() + tmpEdge.getMetric();

                if (destinationNode.getDijkstraWeight() == Integer.MAX_VALUE); {
                    priorityList.add(destinationNode);
                }
                if(currentWeight < destinationNode.getDijkstraWeight()){
                    destinationNode.setDijkstraWeight(currentWeight);
                    destinationNode.setDijkstraPredecessor(currentNode);
                }

            }
        }
    }

    public String shortestPathToString(String srcNodeName, String destNodeName) {
        Node src= this.getNode(srcNodeName);
        Node dest = this.getNode(destNodeName);

        System.out.println("Plus court chemin entre " + src.getName() + " et " + dest.getName());

        if(src.getRoutingTable() == null ) {
            src.setRoutingTable(new HashMap<>());
            dijkstra(src);
        }

        TripletDijkstra currentTriplet = src.getRoutingTable().get(destNodeName);

        if (currentTriplet == null) {
            System.out.println("Pas de chemin entre "+ src.getName() + " et " + dest.getName());
        } else {
            System.out.println("Le coût du trajet est de "+ currentTriplet.getDijkstraWeight());
        }

        LinkedList<TripletDijkstra> path = new LinkedList<TripletDijkstra>();

        while (currentTriplet != null) {
            path.addFirst(currentTriplet);
            currentTriplet = src.getRoutingTable().get(currentTriplet.getPredecessorNodeName());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Les étapes sont : ");
        for (TripletDijkstra step : path) {
            sb.append("       ").append(step.getNodeName());
        }
        sb.append("\n");

        return sb.toString();

    }

}
