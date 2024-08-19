package graph;

public class TrainStrategy implements Strategy {
    private Graph graph;

    public TrainStrategy(Graph graph) {
        this.graph = graph;
    }

    @Override
    public int getDistance(Node startCity, Node endCity, Node avoidCity) {
        //TODO
        return 0;
    }
}