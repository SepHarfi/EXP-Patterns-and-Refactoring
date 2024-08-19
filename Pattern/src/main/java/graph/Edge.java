package graph;

import org.javatuples.Pair;

import lombok.Getter;

public class Edge {
    @Getter
    private final Pair<Node, Node> nodes;
    @Getter
    private boolean directed;
    @Getter
    private int weight;

    private Edge(Node a, Node b, boolean directed, int weight) {
        nodes = new Pair<Node, Node>(a, b);
        this.directed = directed;
        this.weight = weight;
    }

    public static void createEdge(Node a, Node b, boolean directed, int weight) {
        Edge newEdge = new Edge(a, b, directed, weight);
        a.getEdges().add(newEdge);
        b.getEdges().add(newEdge);
    }

    public void setDirected(boolean directed){
        this.directed = directed;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

}
