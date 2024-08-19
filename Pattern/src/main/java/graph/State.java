package graph;

public interface State {
    void makeOneWay(Graph graph);
    
    void makeTwoWay(Graph graph);

    void changeTrainUnitTime(Graph graph, int unit);
}