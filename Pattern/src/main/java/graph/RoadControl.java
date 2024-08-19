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
        //TODO
    }

    public void changeTrainUnitTime(Graph graph, int unit) {
        //TODO
    }
}