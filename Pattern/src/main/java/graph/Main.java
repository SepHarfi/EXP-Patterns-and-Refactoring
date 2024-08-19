package graph;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of cities:");
        int cityCount = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Node> cities = new ArrayList<>();
        for(int i = 1; i <= cityCount; i++) {
            cities.add(new Node());
        }        

        System.out.println("Enter the number of roads:");
        int roadCount = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter roads in format {from to weight}");
        for (int i = 0; i < roadCount; i++) {
            String[] road = scanner.nextLine().split(" ");
            Edge.createEdge(cities.get(Integer.parseInt(road[0]) + 1), cities.get(Integer.parseInt(road[1]) + 1), false, Integer.parseInt(road[2]));
        }

        Graph graph = new Graph(cities);
        runApp(scanner, graph);
    }

    public static void runApp(Scanner scanner, Graph graph){

        RoadControl roadControl = new RoadControl();
        TrainStrategy trainStrategy = new TrainStrategy(graph);
        BusStrategy busStrategy = new BusStrategy(graph);

        while (true) {

            System.out.println("-----------------------------------------------");
            System.out.println("Select command:");
            System.out.println("1. Make all routes one-way");
            System.out.println("2. Make all routes two-way");
            System.out.println("3. Change train unit time");
            System.out.println("4. Get train travel time between cities");
            System.out.println("5. Get bus travel time between cities");
            System.out.println("6. Find faster travel method between cities");
            System.out.println("7. Check if travel between cities is possible avoiding certain city");
            System.out.println("8. Exit");

            int command = scanner.nextInt();

            if (command == 8) {
                break;
            }

            switch (command) {

                case 1:
                    roadControl.setState(new OneWayState());
                    roadControl.makeAllRoutesOneWay(graph);
                    System.out.println("All routes are now one-way.");
                    break;

                case 2:
                    roadControl.setState(new TwoWayState());
                    roadControl.makeAllRoutesTwoWay(graph);
                    System.out.println("All routes are now two-way.");
                    break;

                case 3:
                    System.out.println("Enter new train unit time:");
                    int newTime = scanner.nextInt();
                    roadControl.changeTrainUnitTime(graph, newTime);
                    System.out.println("Train unit time updated to " + newTime);
                    break;

                case 4:
                    System.out.println("Enter start and end city:");
                    Node startCityTrain = graph.getGraph().get(scanner.nextInt() -1);
                    Node endCityTrain = graph.getGraph().get(scanner.nextInt() -1);
                    int trainTime = trainStrategy.getDistance(startCityTrain, endCityTrain, null);
                    System.out.println("Train travel time is " + trainTime + " units.");
                    break;

                case 5:
                    System.out.println("Enter start and end city:");
                    Node startCityBus = graph.getGraph().get(scanner.nextInt() -1);
                    Node endCityBus = graph.getGraph().get(scanner.nextInt() -1);
                    int busTime = busStrategy.getDistance(startCityBus, endCityBus, null);
                    System.out.println("Bus travel time is " + busTime + " units.");
                    break;

                case 6:
                    System.out.println("Enter start and end city:");
                    Node startCity = graph.getGraph().get(scanner.nextInt() -1);
                    Node endCity = graph.getGraph().get(scanner.nextInt() -1);
                    int timeByTrain = trainStrategy.getDistance(startCity, endCity, null);
                    int timeByBus = busStrategy.getDistance(startCity, endCity, null);
                    if (timeByTrain <= timeByBus){
                        System.out.println("Faster travel method is by train.");
                    }else {
                        System.out.println("Faster travel method is by bus."); 
                    }
                    break;

                case 7:
                    System.out.println("Enter start city, end city, and city to avoid:");
                    String startCityAvoid = scanner.next();
                    String endCityAvoid = scanner.next();
                    String avoidCity = scanner.next();
                    boolean canAvoid = false; //TODO
                    System.out.println("It is " + (canAvoid ? "possible" : "not possible") + " to travel from " + startCityAvoid + " to " + endCityAvoid + " avoiding " + avoidCity + ".");
                    break;

                default:
                    System.out.println("Invalid Command! Try Again.");
            }
        }
    }
}