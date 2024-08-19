package graph;

public interface Strategy {
    int getDistance(Node start, Node end, Node avoid);
}