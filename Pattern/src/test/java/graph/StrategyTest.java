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
    
}
