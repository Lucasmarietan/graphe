package ch.hearc.business;

public class Edge {
    private String name;
    private double metric;
    private Node dest;

    public Edge(String name, Node dest, double metric) {
        this.name = name;
        this.metric = metric;
        this.dest = dest;
    }

    public String getName() {
        return name;
    }

    public double getMetric() {
        return metric;
    }

    public Node getDest() {
        return dest;
    }
}
