package ch.hearc.business;

import java.io.Serializable;

public class Edge implements Serializable {
    private String name;
    private double metric;
    private Node dest;

    /**
     * Constructeur
     */
    public Edge(String name, Node dest, double metric) {
        this.name = name;
        this.metric = metric;
        this.dest = dest;
    }

    /**
     * Getter / Setter
     */
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
