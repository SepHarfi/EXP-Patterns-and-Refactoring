package graph;

public class TwoWayState implements State {
    @Override
    public void makeOneWay(Graph graph) {
        // Empty Body
    }

    @Override
    public void makeTwoWay(Graph graph) {
        for (Node node : graph.getGraph()) {
            for (Edge edge : node.getEdges()) {
                edge.setDirected(false);
            }
        }
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