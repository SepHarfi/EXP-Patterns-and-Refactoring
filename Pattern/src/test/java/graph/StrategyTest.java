package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class StrategyTest {

    private Graph graph;
    private ArrayList<Node> nodes;

    @Before
    public void setUp() {
        nodes = new ArrayList<>();
        nodes.add(new Node());
        nodes.add(new Node());
        nodes.add(new Node());
        graph = new Graph(nodes);
        Edge.createEdge(nodes.get(0), nodes.get(1), false, 1);
        Edge.createEdge(nodes.get(1), nodes.get(2), false, 2);
        Edge.createEdge(nodes.get(2), nodes.get(0), false, 5);
    }
    
    @Test
    public void trainStrategyTest() {
        TrainStrategy strategy = new TrainStrategy(graph);
        int distance = strategy.getDistance(nodes.get(0), nodes.get(2), null);
        assertEquals(1, distance);
    }
    
    @Test
    public void trainStrategyDirectTest() {
        RoadControl roadControl = new RoadControl();
        roadControl.setState(new OneWayState());
        roadControl.makeAllRoutesOneWay(graph);
        TrainStrategy strategy = new TrainStrategy(graph);
        int distance = strategy.getDistance(nodes.get(0), nodes.get(2), null);
        assertEquals(2, distance);
    }

    @Test
    public void busStrategyTest() {
        BusStrategy strategy = new BusStrategy(graph);
        int distance = strategy.getDistance(nodes.get(0), nodes.get(2), null);
        assertEquals(3, distance);
    }

    @Test
    public void busStrategyAvoidTest() {
        BusStrategy strategy = new BusStrategy(graph);
        int distance = strategy.getDistance(nodes.get(0), nodes.get(2), nodes.get(1));
        assertEquals(5, distance);
    }
}
