package graph;

public class OneWayState implements State {
    @Override
    public void makeOneWay(Graph graph) {
        for (Node node : graph.getGraph()) {
            for (Edge edge : node.getEdges()) {
                edge.setDirected(true);
            }
        }
    }

    @Override
    public void makeTwoWay(Graph graph) {
        // Empty Body
    }

    @Override
    public void changeTrainUnitTime(Graph graph, int unit) {
        for (Node node : graph.getGraph()) {
            for (Edge edge : node.getEdges()) {
                edge.setWeight(unit);
            }
        }
    }
}