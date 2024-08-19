package graph;

public class BusStrategy implements Strategy{
    private Graph graph;

    public BusStrategy(Graph graph) {
        this.graph = graph;
    }

    @Override
    public int getDistance(Node startCity, Node endCity, Node avoidCity) {
        //TODO
        return 0;
    }
}