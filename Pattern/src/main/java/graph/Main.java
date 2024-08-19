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

        System.out.println("Enter roads in format {from to}");
        for (int i = 0; i < roadCount; i++) {
            String[] road = scanner.nextLine().split(" ");
            Edge.createEdge(cities.get(Integer.parseInt(road[0]) + 1), cities.get(Integer.parseInt(road[1]) + 1), false, 1);
        }

        Graph graph = new Graph(cities);
        runApp(scanner, graph);
    }

    public static void runApp(Scanner scanner, Graph graph){

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
                    //TODO
                    System.out.println("All routes are now one-way.");
                    break;

                case 2:
                    //TODO
                    System.out.println("All routes are now two-way.");
                    break;

                case 3:
                    System.out.println("Enter new train unit time:");
                    int newTime = scanner.nextInt(); //TODO
                    System.out.println("Train unit time updated to " + newTime);
                    break;

                case 4:
                    System.out.println("Enter start and end city:");
                    String startCityTrain = scanner.next();
                    String endCityTrain = scanner.next();
                    int trainTime = 0; //TODO
                    System.out.println("Train travel time from " + startCityTrain + " to " + endCityTrain + " is " + trainTime + " units.");
                    break;

                case 5:
                    System.out.println("Enter start and end city:");
                    String startCityBus = scanner.next();
                    String endCityBus = scanner.next();
                    int busTime = 0; //TODO
                    System.out.println("Bus travel time from " + startCityBus + " to " + endCityBus + " is " + busTime + " units.");
                    break;

                case 6:
                    System.out.println("Enter start and end city:");
                    String startCity = scanner.next();
                    String endCity = scanner.next();
                    int timeByTrain = 0; //TODO
                    int timeByBus = 0; //TODO
                    if (timeByTrain <= timeByBus){
                        System.out.println("Faster travel method from " + startCity + " to " + endCity + " is by train.");
                    }else {
                        System.out.println("Faster travel method from " + startCity + " to " + endCity + " is by bus."); 
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