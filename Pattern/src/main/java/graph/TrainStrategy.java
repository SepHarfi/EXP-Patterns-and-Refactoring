package graph;

public class TrainStrategy implements Strategy {
    private Graph graph;

    public TrainStrategy(Graph graph) {
        this.graph = graph;
    }

    @Override
    public int getDistance(Node startCity, Node endCity, Node avoidCity) {
        graph.bfs(startCity, avoidCity);
        int distance = endCity.getDistance() * graph.trainUnitTime; 
        return distance;
    }
}