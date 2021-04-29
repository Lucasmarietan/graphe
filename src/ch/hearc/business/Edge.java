package ch.hearc.business;

import java.io.Serializable;

public class Edge implements Serializable {
    private String name;
    private int metric;
    private Node dest;

    /**
     * Constructeur
     */
    public Edge(String name, Node dest, int metric) {
        this.name = name;
        this.metric = metric;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "name='" + name + '\'' +
                ", metric=" + metric +
                ", dest=" + dest +
                '}';
    }

    /**
     * Getter / Setter
     */
    public String getName() {
        return name;
    }

    public int getMetric() {
        return metric;
    }

    public Node getDest() {
        return dest;
    }
}
