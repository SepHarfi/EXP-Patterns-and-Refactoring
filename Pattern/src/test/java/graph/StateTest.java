package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class StateTest {
    private Graph graph;
    private ArrayList<Node> nodes;
    private RoadControl roadControl;

    @Before
    public void setUp() {
        roadControl = new RoadControl();
        nodes = new ArrayList<>();
        nodes.add(new Node());
        nodes.add(new Node());
        nodes.add(new Node());
        graph = new Graph(nodes);
        Edge.createEdge(nodes.get(0), nodes.get(1), false, 1);
        Edge.createEdge(nodes.get(1), nodes.get(2), false, 1);
        Edge.createEdge(nodes.get(2), nodes.get(0), false, 1);
    }
    
    @Test
    public void makeOneWayTest(){
        roadControl.setState(new OneWayState());
        roadControl.makeAllRoutesOneWay(graph);
        assertTrue(nodes.get(0).getEdges().get(0).isDirected());
    }

    @Test
    public void makeTwoWayTest(){
        roadControl.setState(new OneWayState());
        roadControl.makeAllRoutesOneWay(graph);
        roadControl.setState(new TwoWayState());
        roadControl.makeAllRoutesTwoWay(graph);
        assertFalse(nodes.get(0).getEdges().get(0).isDirected());
    }

    @Test
    public void changeTrainUnitTimeTest(){
        roadControl.setState(new OneWayState());
        roadControl.changeTrainUnitTime(graph, 2);
        assertEquals(nodes.get(0).getEdges().get(0).getWeight(), 2);
    }

}
