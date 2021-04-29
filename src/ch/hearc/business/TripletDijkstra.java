package ch.hearc.business;

public class TripletDijkstra {
    private String nodeName;
    private String predecessorNodeName;
    private int dijkstraWeight;

    public TripletDijkstra(String nodeName, String predecessorNodeName, int dijkstraWeight) {
        this.nodeName = nodeName;
        this.predecessorNodeName = predecessorNodeName;
        this.dijkstraWeight = dijkstraWeight;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getPredecessorNodeName() {
        return predecessorNodeName;
    }

    public void setPredecessorNodeName(String predecessorNodeName) {
        this.predecessorNodeName = predecessorNodeName;
    }

    public int getDijkstraWeight() {
        return dijkstraWeight;
    }

    public void setDijkstraWeight(int dijkstraWeight) {
        this.dijkstraWeight = dijkstraWeight;
    }
}
