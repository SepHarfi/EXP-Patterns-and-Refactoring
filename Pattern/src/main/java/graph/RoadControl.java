package graph;

public class RoadControl {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void makeAllRoutesOneWay(Graph graph) {
        state.makeOneWay(graph);
    }

    public void makeAllRoutesTwoWay(Graph graph) {
        state.makeTwoWay(graph);
    }

    public void changeTrainUnitTime(Graph graph, int unit) {
        state.changeTrainUnitTime(graph, unit);
    }
}