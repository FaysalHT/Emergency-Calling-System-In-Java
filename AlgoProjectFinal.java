package algoprojectfinal;

import java.util.*;

public class AlgoProjectFinal {
    // Hardcoded default credentials for User and Admin
    private static  String USER_DEFAULT_USERNAME = "user";
    private static  String USER_DEFAULT_PASSWORD = "user123";

    private static  String ADMIN_DEFAULT_USERNAME = "admin";
    private static  String ADMIN_DEFAULT_PASSWORD = "admin123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the Login or Sign Up interface
            System.out.println("\n===== Login or Sign Up Interface =====");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int loginOrSignUpChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

             switch (loginOrSignUpChoice) {
                case 1:
                    // Login
                    loginInterface(scanner);
                    break;
                case 2:
                    // Sign Up
                    signUpInterface(scanner);
                    break;
                case 3:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        
    }

    private static void loginInterface(Scanner scanner) {
        while (true) {
            // Display the Login interface
            System.out.println("\n===== Login Interface =====");
            System.out.println("Are you an User or an Admin?");
            
            System.out.println("Enter your input: ");
            String userType = scanner.nextLine().toLowerCase();

            // Perform login based on user type
            if (userType.equals("user")) {
                if (userLogin()) {
                    // User actions
                    userActions();
                }
            } else if (userType.equals("admin")) {
                if (adminLogin()) {
                    // Admin actions
                    adminActions();
                }
            } else {
                System.out.println("Invalid user type. Please enter 'user' or 'admin'.");
            }
        }
    }
    
    private static void signUpInterface(Scanner scanner) {
        while (true) {
            // Display the Sign Up interface
            System.out.println("\n===== Sign Up Interface =====");
            System.out.println("Are you an User or an Admin?");
            
            System.out.println("Enter your input: ");
            String userType = scanner.nextLine().toLowerCase();

            // Perform sign up based on user type
            if (userType.equals("user")) {
                if (userSignUp(scanner)) {
                    System.out.println("User sign up successful! You can now log in.");
                    break;
                }
            } else if (userType.equals("admin")) {
                if (adminSignUp(scanner)) {
                    System.out.println("Admin sign up successful! You can now log in.");
                    break;
                }
            } else {
                System.out.println("Invalid user type. Please enter 'user' or 'admin'.");
            }
        }
    }

    
    private static boolean userSignUp(Scanner scanner) {
        // User sign-up
        System.out.println("\n===== User Sign Up =====");
        System.out.println("Enter your new username:");
        String username = scanner.nextLine();
        System.out.println("Enter your new password:");
        String password = scanner.nextLine();

        // You might want to add additional checks for strong password requirements, etc.

        // Set the new default User credentials
        USER_DEFAULT_USERNAME = username;
        USER_DEFAULT_PASSWORD = password;

        System.out.println("\nUser sign up successful!");
        return true;
    }

    private static boolean adminSignUp(Scanner scanner) {
        // Admin sign-up
        System.out.println("\n===== Admin Sign Up =====");
        System.out.println("Enter your new username:");
        String username = scanner.nextLine();
        System.out.println("Enter your new password:");
        String password = scanner.nextLine();

        // You might want to add additional checks for strong password requirements, etc.

        // Set the new default Admin credentials
        ADMIN_DEFAULT_USERNAME = username;
        ADMIN_DEFAULT_PASSWORD = password;

        System.out.println("\nAdmin sign up successful!");
        return true;
    }
    
    private static boolean userLogin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // User login
            System.out.println("\n===== User Login =====");
            System.out.println("Enter your username:");
            String username = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            // Check if the entered credentials match the default User credentials
            if (username.equals(USER_DEFAULT_USERNAME) && password.equals(USER_DEFAULT_PASSWORD)) {
                System.out.println("\nUser login successful!");
                return true;
            } else {
                System.out.println("\nInvalid username or password for User. Login failed.");
                System.out.println("1. Returning to the main login interface");
                System.out.println("2. Try again with correct username / password");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (choice == 1) {
                    // Return to the main login interface
                    return false;
                } else if (choice != 2) {
                    System.out.println("\nInvalid choice. Exiting...");
                    return false;
                }
            }
        }
    }

    private static boolean adminLogin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Admin login
            System.out.println("\n===== Admin Login =====");
            System.out.println("Enter your username:");
            String username = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            // Check if the entered credentials match the default Admin credentials
            if (username.equals(ADMIN_DEFAULT_USERNAME) && password.equals(ADMIN_DEFAULT_PASSWORD)) {
                System.out.println("\nAdmin login successful!");
                return true;
            } else {
                System.out.println("\nInvalid username or password for Admin. Login failed.");
                System.out.println("1. Returning to the main login interface");
                System.out.println("2. Try again with correct username/password");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (choice == 1) {
                    // Return to the main login interface
                    return false;
                } else if (choice != 2) {
                    System.out.println("\nInvalid choice. Exiting...");
                    return false;
                }
            }
        }
    }

    private static void userActions() {
        // User actions code
        
    while(true){
        System.out.println("\n===== User Actions =====\n");
         class Graph {
    Map<String, Integer> nodeIndices;
    List<Map<Integer, Integer>> adjList;

    public Graph() {
      nodeIndices = new HashMap<>();
      adjList = new ArrayList<>();
    }

    public void addNode(String nodeName) {
        String lowerCaseNodeName = nodeName.toLowerCase();
        if (!nodeIndices.containsKey(lowerCaseNodeName)) {
            int index = nodeIndices.size();
            nodeIndices.put(lowerCaseNodeName, index);
            adjList.add(new HashMap<>());
        }
    }

    public void addEdge(String source, String destination, int weight) {
    String lowerCaseSource = source.toLowerCase();
    String lowerCaseDestination = destination.toLowerCase();

    Integer sourceIndex = nodeIndices.get(lowerCaseSource);
    Integer destinationIndex = nodeIndices.get(lowerCaseDestination);

    if (sourceIndex != null && destinationIndex != null) {
        adjList.get(sourceIndex).put(destinationIndex, weight);
        adjList.get(destinationIndex).put(sourceIndex, weight); // Assuming undirected graph
    } else {
        // Handle the case where either source or destination is not found
        System.out.println("Error: Source or destination node not found.");
    }
}
    public void printAllPathsWithDistance(String source, String destination) {
        String lowerCaseSource = source.toLowerCase();
        String lowerCaseDestination = destination.toLowerCase();
        int sourceIndex = nodeIndices.get(lowerCaseSource);
        int destinationIndex = nodeIndices.get(lowerCaseDestination);
        boolean[] visited = new boolean[nodeIndices.size()];
        List<String> path = new ArrayList<>();
        printAllPathsDFSWithDistance(sourceIndex, destinationIndex, visited, path);
    }
    
       private void printAllPathsDFSWithDistance(int u, int destination, boolean[] visited, List<String> path) {
        visited[u] = true;
        path.add(getNodeName(this, u));

        if (u == destination) {
            // Calculate and print the total distance for the current path
            int totalDistance = calculateTotalDistance(path);
            System.out.print("Path: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println("\nTotal Distance: " + totalDistance + " KM");
            System.out.println();
        } else {
            for (Map.Entry<Integer, Integer> neighborEntry : adjList.get(u).entrySet()) {
                int v = neighborEntry.getKey();
                if (!visited[v]) {
                    printAllPathsDFSWithDistance(v, destination, visited, path);
                }
            }
        }

        // Backtrack
        visited[u] = false;
        path.remove(path.size() - 1);
    }

    private int calculateTotalDistance(List<String> path) {
        int totalDistance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String source = path.get(i);
            String destination = path.get(i + 1);
            int sourceIndex = nodeIndices.get(source);
            int destinationIndex = nodeIndices.get(destination);
            totalDistance += adjList.get(sourceIndex).get(destinationIndex);
        }
        return totalDistance;
    }   
       
        public void printAllPathsInOrder(String source, String destination, boolean ascendingOrder) {
        List<PathWithDistance> pathsWithDistances = new ArrayList<>();
        printAllPathsDFSWithDistanceInOrder(source, destination, new boolean[nodeIndices.size()], new ArrayList<>(), pathsWithDistances);

        // Sort the paths based on distance
        pathsWithDistances.sort(Comparator.comparingInt(PathWithDistance::getTotalDistance));

        // If descending order is requested, reverse the order
        if (!ascendingOrder) {
            Collections.reverse(pathsWithDistances);
        }

        // Print the sorted paths
        for (PathWithDistance pathWithDistance : pathsWithDistances) {
            System.out.println(pathWithDistance.getPath() + " (Total Distance: " + pathWithDistance.getTotalDistance() + " KM)");
        }
    }
        
        private void printAllPathsDFSWithDistanceInOrder(String source, String destination, boolean[] visited, List<String> path, List<PathWithDistance> pathsWithDistances) {
        int u = nodeIndices.get(source);
        int destinationIndex = nodeIndices.get(destination);

        visited[u] = true;
        path.add(getNodeName(this, u));

        if (u == destinationIndex) {
            // Calculate the total distance for the current path
            int totalDistance = calculateTotalDistance(path);
            pathsWithDistances.add(new PathWithDistance(new ArrayList<>(path), totalDistance));
        } else {
            for (Map.Entry<Integer, Integer> neighborEntry : adjList.get(u).entrySet()) {
                int v = neighborEntry.getKey();
                if (!visited[v]) {
                    printAllPathsDFSWithDistanceInOrder(getNodeName(this, v), destination, visited, path, pathsWithDistances);
                }
            }
        }

        // Backtrack
        visited[u] = false;
        path.remove(path.size() - 1);
    }    
        
    private static class PathWithDistance {
        private final List<String> path;
        private final int totalDistance;

        public PathWithDistance(List<String> path, int totalDistance) {
            this.path = path;
            this.totalDistance = totalDistance;
        }

        public List<String> getPath() {
            return path;
        }

        public int getTotalDistance() {
            return totalDistance;
        }
    }
    
    
   public void printAllPaths(String source, String destination) {
        String lowerCaseSource = source.toLowerCase();
        String lowerCaseDestination = destination.toLowerCase();
        int sourceIndex = nodeIndices.get(lowerCaseSource);
        int destinationIndex = nodeIndices.get(lowerCaseDestination);
        boolean[] visited = new boolean[nodeIndices.size()];
        List<String> path = new ArrayList<>();
        printAllPathsDFS(sourceIndex, destinationIndex, visited, path);
    }

   
   public void calculateTotalDistance(String source, String destination) {
    String lowerCaseSource = source.toLowerCase();
    String lowerCaseDestination = destination.toLowerCase();
    int sourceIndex = nodeIndices.get(lowerCaseSource);
    int destinationIndex = nodeIndices.get(lowerCaseDestination);
    boolean[] visited = new boolean[nodeIndices.size()];
    List<String> path = new ArrayList<>();
    calculateTotalDistanceDFS(sourceIndex, destinationIndex, visited, path, 0);
}
   
   private void calculateTotalDistanceDFS(int u, int destination, boolean[] visited, List<String> path, int totalDistance) {
    visited[u] = true;
    path.add(getNodeName(this, u));

    if (u == destination) {
        // Print the current path and total distance
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" (Total Distance: " + totalDistance + " KM)");
    } else {
        for (Map.Entry<Integer, Integer> neighborEntry : adjList.get(u).entrySet()) {
            int v = neighborEntry.getKey();
            int weight = neighborEntry.getValue();
            if (!visited[v]) {
                calculateTotalDistanceDFS(v, destination, visited, path, totalDistance + weight);
            }
        }
    }

    // Backtrack
    visited[u] = false;
    path.remove(path.size() - 1);
}

    private void printAllPathsDFS(int u, int destination, boolean[] visited, List<String> path) {
      visited[u] = true;
      path.add(getNodeName(this, u));

      if (u == destination) {
        // Print the current path
        for (int i = 0; i < path.size(); i++) {
          System.out.print(path.get(i));
          if (i < path.size() - 1) {
            System.out.print(" -> ");
          }
        }
        System.out.println();
      } else {
        for (Map.Entry<Integer, Integer> neighborEntry : adjList.get(u).entrySet()) {
          int v = neighborEntry.getKey();
          if (!visited[v]) {
            printAllPathsDFS(v, destination, visited, path);
          }
        }
      }

      // Backtrack
      visited[u] = false;
      path.remove(path.size() - 1);
    }

    public int[] dijkstra(String source) {
      int sourceIndex = nodeIndices.get(source);

      int[] dist = new int[nodeIndices.size()];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[sourceIndex] = 0;

      PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
      minHeap.add(new Node(sourceIndex, 0));

      while (!minHeap.isEmpty()) {
        Node currentNode = minHeap.poll();
        int u = currentNode.vertex;

        for (Map.Entry<Integer, Integer> neighborEntry : adjList.get(u).entrySet()) {
          int v = neighborEntry.getKey();
          int weight = neighborEntry.getValue();

          if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
            dist[v] = dist[u] + weight;
            minHeap.add(new Node(v, dist[v]));
          }
        }
      }

      return dist;
    }

    private static class Node {
      int vertex;
      int distance;

      public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
      }
    }

    private static void printPath(Graph graph, String source, String destination, int[] distances) {
      List<String> path = new ArrayList<>();
      
        String lowerCaseSource = source.toLowerCase();
        String lowerCaseDestination = destination.toLowerCase();
        int destinationIndex = graph.nodeIndices.get(lowerCaseDestination);
        int current = destinationIndex;

      while (current != graph.nodeIndices.get(source)) {
        path.add(getNodeName(graph, current));
        for (Map.Entry<Integer, Integer> entry : graph.adjList.get(current).entrySet()) {
          int neighbor = entry.getKey();
          int weight = entry.getValue();
          if (distances[current] == distances[neighbor] + weight) {
            current = neighbor;
            break;
          }
        }
      }

      path.add(source);
      Collections.reverse(path);

      // Print the path without arrows after the last node
      for (int i = 0; i < path.size(); i++) {
        System.out.print(path.get(i));
        if (i < path.size() - 1) {
          System.out.print(" -> ");
        }
      }
      System.out.println();
    }

    private static String getNodeName(Graph graph, int index) {
      for (Map.Entry<String, Integer> entry : graph.nodeIndices.entrySet()) {
        if (entry.getValue() == index) {
          return entry.getKey();
        }
      }
      return null;
    }
  }
          Graph graph = new Graph();

    // Adding nodes with custom names
    graph.addNode("Home");
    graph.addNode("Mirpur");
    graph.addNode("Agergaon");
    graph.addNode("Mogbazar");
    graph.addNode("Uttara");
    graph.addNode("ECB");
    graph.addNode("Police");
    graph.addNode("FireService");
    graph.addNode("Hospital");
    graph.addNode("Ride");

    // Adding predefined edges and weights with custom node names
    graph.addEdge("Home", "Mirpur", 0);
    graph.addEdge("Mirpur", "Agergaon", 2);
    graph.addEdge("Mirpur", "Mogbazar", 4);
    graph.addEdge("Agergaon", "Mogbazar", 1);
    graph.addEdge("Agergaon", "Uttara", 7);
    graph.addEdge("Mogbazar", "ECB", 3);
    graph.addEdge("Uttara", "ECB", 1);
    graph.addEdge("ECB", "Police", 0);
    graph.addEdge("Uttara", "FireService", 0);
    graph.addEdge("Mogbazar", "Hospital", 0);
    graph.addEdge("Agergaon", "Ride", 0);

    // Get source and destination nodes from user input
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Your Location: ");
    String sourceNode = scanner.nextLine().toLowerCase();
    System.out.print("\nWhich service you want to take?\n\n<> Police\n<> Hospital\n<> FireService\n<> Ride\n\nType Here: ");
    String destinationNode = scanner.nextLine().toLowerCase();

    // Print all paths between source and destination
    System.out.println("\nAll paths between " + sourceNode + " and " + destinationNode + ":");
    graph.calculateTotalDistance(sourceNode, destinationNode);
    
    System.out.println("\nDo you want to sort the path(s)?");
    System.out.println("\n1) Ascending order\n");
    System.out.println("2) Descending order");
    
    System.out.println("\nEnter your input: ");
    
    int ask = scanner.nextInt();
    
    if(ask == 1){
        // Print all paths and distances in ascending order
        System.out.println("\nAll paths and distances between " + sourceNode + " and " + destinationNode + " in ascending order:");
        graph.printAllPathsInOrder(sourceNode, destinationNode, true);

    }
    else if (ask ==2){
        // Print all paths and distances in descending order
        System.out.println("\nAll paths and distances between " + sourceNode + " and " + destinationNode + " in descending order:");
        graph.printAllPathsInOrder(sourceNode, destinationNode, false);
    }      
    
    else{
       break; 
    }
    
    // Calculate and print the shortest distance from source to destination
    int[] shortestDistances = graph.dijkstra(sourceNode);
    int destinationIndex = graph.nodeIndices.get(destinationNode);
    int shortestDistance = shortestDistances[destinationIndex];
        
    System.out.println("\nDo you want to check shortest path?");
    System.out.println("1)Yes \n2)No");
    
    int choice;
    
    System.out.println("\nEnter your input: ");
    
    int Choice = scanner.nextInt();
    
    if(Choice == 1){
           
    System.out.println("\nShortest distance from " + sourceNode + " to " + destinationNode + ": " + shortestDistance + " KM ");

    // Print the shortest path
    System.out.println("\nShortest path:");
    Graph.printPath(graph, sourceNode, destinationNode, shortestDistances);
        
    }
    
    else{
        System.out.println("\nThank you for visiting");
    }
        
            System.out.println("\nOptions:");
            System.out.println("1) Start from the login interface");
            System.out.println("2) Exit program");

        System.out.println("\nEnter your input: ");
            
        int choose = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choose == 1) {
            break;
        }
        else if (choose == 2) {
                System.out.println("\nExiting program...");
                System.exit(0);
            }
        scanner.close();
    
    }    
        
  }

    private static void adminActions() {
        // Admin actions code here
      while(true){
        
           System.out.println("\n===== Admin Actions =====\n");

         class Graph {
    Map<String, Integer> nodeIndices;
    List<Map<Integer, Integer>> adjList;

    public Graph() {
      nodeIndices = new HashMap<>();
      adjList = new ArrayList<>();
    }

   public void addNode(String nodeName) {
        if (!nodeIndices.containsKey(nodeName.toLowerCase())) {
            int index = nodeIndices.size();
            nodeIndices.put(nodeName.toLowerCase(), index);
            adjList.add(new HashMap<>());
        }
    }

    public void printAllPathsWithDistance(String source, String destination) {
        String lowerCaseSource = source.toLowerCase();
        String lowerCaseDestination = destination.toLowerCase();
        int sourceIndex = nodeIndices.get(lowerCaseSource);
        int destinationIndex = nodeIndices.get(lowerCaseDestination);
        boolean[] visited = new boolean[nodeIndices.size()];
        List<String> path = new ArrayList<>();
        printAllPathsDFSWithDistance(sourceIndex, destinationIndex, visited, path);
    }
    
     private void printAllPathsDFSWithDistance(int u, int destination, boolean[] visited, List<String> path) {
        visited[u] = true;
        path.add(getNodeName(this, u));

        if (u == destination) {
            // Calculate and print the total distance for the current path
            int totalDistance = calculateTotalDistance(path);
            System.out.print("Path: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println("\nTotal Distance: " + totalDistance + " KM");
            System.out.println();
        } else {
            for (Map.Entry<Integer, Integer> neighborEntry : adjList.get(u).entrySet()) {
                int v = neighborEntry.getKey();
                if (!visited[v]) {
                    printAllPathsDFSWithDistance(v, destination, visited, path);
                }
            }
        }

        // Backtrack
        visited[u] = false;
        path.remove(path.size() - 1);
    }

    private int calculateTotalDistance(List<String> path) {
        int totalDistance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String source = path.get(i);
            String destination = path.get(i + 1);
            int sourceIndex = nodeIndices.get(source);
            int destinationIndex = nodeIndices.get(destination);
            totalDistance += adjList.get(sourceIndex).get(destinationIndex);
        }
        return totalDistance;
    }
     
        public void printAllPathsInOrder(String source, String destination, boolean ascendingOrder) {
        List<PathWithDistance> pathsWithDistances = new ArrayList<>();
        printAllPathsDFSWithDistanceInOrder(source, destination, new boolean[nodeIndices.size()], new ArrayList<>(), pathsWithDistances);

        // Sort the paths based on distance
        pathsWithDistances.sort(Comparator.comparingInt(PathWithDistance::getTotalDistance));

        // If descending order is requested, reverse the order
        if (!ascendingOrder) {
            Collections.reverse(pathsWithDistances);
        }

        // Print the sorted paths
        for (PathWithDistance pathWithDistance : pathsWithDistances) {
            System.out.println(pathWithDistance.getPath() + " (Total Distance: " + pathWithDistance.getTotalDistance() + " KM)");
        }
    }

        private void printAllPathsDFSWithDistanceInOrder(String source, String destination, boolean[] visited, List<String> path, List<PathWithDistance> pathsWithDistances) {
        int u = nodeIndices.get(source);
        int destinationIndex = nodeIndices.get(destination);

        visited[u] = true;
        path.add(getNodeName(this, u));

        if (u == destinationIndex) {
            // Calculate the total distance for the current path
            int totalDistance = calculateTotalDistance(path);
            pathsWithDistances.add(new PathWithDistance(new ArrayList<>(path), totalDistance));
        } else {
            for (Map.Entry<Integer, Integer> neighborEntry : adjList.get(u).entrySet()) {
                int v = neighborEntry.getKey();
                if (!visited[v]) {
                    printAllPathsDFSWithDistanceInOrder(getNodeName(this, v), destination, visited, path, pathsWithDistances);
                }
            }
        }

        // Backtrack
        visited[u] = false;
        path.remove(path.size() - 1);
    }
        
    private static class PathWithDistance {
        private final List<String> path;
        private final int totalDistance;

        public PathWithDistance(List<String> path, int totalDistance) {
            this.path = path;
            this.totalDistance = totalDistance;
        }

        public List<String> getPath() {
            return path;
        }

        public int getTotalDistance() {
            return totalDistance;
        }
    }

    
    public void addEdge(String source, String destination, int weight) {
        int sourceIndex = nodeIndices.get(source.toLowerCase());
        int destinationIndex = nodeIndices.get(destination.toLowerCase());
        adjList.get(sourceIndex).put(destinationIndex, weight);
        adjList.get(destinationIndex).put(sourceIndex, weight); // Assuming undirected graph
    }

    public void printAllPaths(String source, String destination) {
            String lowerCaseSource = source.toLowerCase();
            String lowerCaseDestination = destination.toLowerCase();
            int sourceIndex = nodeIndices.get(lowerCaseSource);
            int destinationIndex = nodeIndices.get(lowerCaseDestination);
            boolean[] visited = new boolean[nodeIndices.size()];
            List<String> path = new ArrayList<>();
            printAllPathsDFS(sourceIndex, destinationIndex, visited, path);
        }

    public void calculateTotalDistance(String source, String destination) {
    String lowerCaseSource = source.toLowerCase();
    String lowerCaseDestination = destination.toLowerCase();
    int sourceIndex = nodeIndices.get(lowerCaseSource);
    int destinationIndex = nodeIndices.get(lowerCaseDestination);
    boolean[] visited = new boolean[nodeIndices.size()];
    List<String> path = new ArrayList<>();
    calculateTotalDistanceDFS(sourceIndex, destinationIndex, visited, path, 0);
}

    private void calculateTotalDistanceDFS(int u, int destination, boolean[] visited, List<String> path, int totalDistance) {
    visited[u] = true;
    path.add(getNodeName(this, u));

    if (u == destination) {
        // Print the current path and total distance
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" (Total Distance: " + totalDistance + " KM)");
    } else {
        for (Map.Entry<Integer, Integer> neighborEntry : adjList.get(u).entrySet()) {
            int v = neighborEntry.getKey();
            int weight = neighborEntry.getValue();
            if (!visited[v]) {
                calculateTotalDistanceDFS(v, destination, visited, path, totalDistance + weight);
            }
        }
    }

    // Backtrack
    visited[u] = false;
    path.remove(path.size() - 1);
}

    private void printAllPathsDFS(int u, int destination, boolean[] visited, List<String> path) {
      visited[u] = true;
      path.add(getNodeName(this, u));

      if (u == destination) {
        // Print the current path
        for (int i = 0; i < path.size(); i++) {
          System.out.print(path.get(i));
          if (i < path.size() - 1) {
            System.out.print(" -> ");
          }
        }
        System.out.println();
      } else {
        for (Map.Entry<Integer, Integer> neighborEntry : adjList.get(u).entrySet()) {
          int v = neighborEntry.getKey();
          if (!visited[v]) {
            printAllPathsDFS(v, destination, visited, path);
          }
        }
      }

      // Backtrack
      visited[u] = false;
      path.remove(path.size() - 1);
    }

    public int[] dijkstra(String source) {
      int sourceIndex = nodeIndices.get(source);

      int[] dist = new int[nodeIndices.size()];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[sourceIndex] = 0;

      PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
      minHeap.add(new Node(sourceIndex, 0));

      while (!minHeap.isEmpty()) {
        Node currentNode = minHeap.poll();
        int u = currentNode.vertex;

        for (Map.Entry<Integer, Integer> neighborEntry : adjList.get(u).entrySet()) {
          int v = neighborEntry.getKey();
          int weight = neighborEntry.getValue();

          if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
            dist[v] = dist[u] + weight;
            minHeap.add(new Node(v, dist[v]));
          }
        }
      }

      return dist;
    }

    private static class Node {
      int vertex;
      int distance;

      public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
      }
    }

    private static void printPath(Graph graph, String source, String destination, int[] distances) {
      List<String> path = new ArrayList<>();
      
        String lowerCaseSource = source.toLowerCase();
        String lowerCaseDestination = destination.toLowerCase();
        int destinationIndex = graph.nodeIndices.get(lowerCaseDestination);
        int current = destinationIndex;

      while (current != graph.nodeIndices.get(source)) {
        path.add(getNodeName(graph, current));
        for (Map.Entry<Integer, Integer> entry : graph.adjList.get(current).entrySet()) {
          int neighbor = entry.getKey();
          int weight = entry.getValue();
          if (distances[current] == distances[neighbor] + weight) {
            current = neighbor;
            break;
          }
        }
      }

      path.add(source);
      Collections.reverse(path);

      // Print the path without arrows after the last node
      for (int i = 0; i < path.size(); i++) {
        System.out.print(path.get(i));
        if (i < path.size() - 1) {
          System.out.print(" -> ");
        }
      }
      System.out.println();
    }

    private static String getNodeName(Graph graph, int index) {
      for (Map.Entry<String, Integer> entry : graph.nodeIndices.entrySet()) {
        if (entry.getValue() == index) {
          return entry.getKey();
        }
      }
      return null;
    }
  }
  
            Graph graph = new Graph();

    // Adding nodes with custom names
    graph.addNode("Home");
    graph.addNode("Mirpur");
    graph.addNode("Agergaon");
    graph.addNode("Mogbazar");
    graph.addNode("Uttara");
    graph.addNode("ECB");
    graph.addNode("Police");
    graph.addNode("FireService");
    graph.addNode("Ambulance");
    graph.addNode("Ride");

    // Adding predefined edges and weights with custom node names
    graph.addEdge("Home", "Mirpur", 0);
    graph.addEdge("Mirpur", "Agergaon", 2);
    graph.addEdge("Mirpur", "Mogbazar", 4);
    graph.addEdge("Agergaon", "Mogbazar", 1);
    graph.addEdge("Agergaon", "Uttara", 7);
    graph.addEdge("Mogbazar", "ECB", 3);
    graph.addEdge("Uttara", "ECB", 1);
    graph.addEdge("ECB", "Police", 0);
    graph.addEdge("Uttara", "FireService", 0);
    graph.addEdge("Mogbazar", "Ambulance", 0);
    graph.addEdge("Agergaon", "Ride", 0);

    // Get source and destination nodes from user input
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Dispatch Department: ");
    String sourceNode = scanner.nextLine().toLowerCase();
    System.out.print("\nDispatch to?\n<> Mirpur\n<> Agergaon\n<> Mogbazar\n<> Uttara\n<> ECB\n\nType Here: ");
    String destinationNode = scanner.nextLine().toLowerCase();
    
    graph.addNode(sourceNode);
    graph.addNode(destinationNode);
    
    // Print all paths between source and destination
    System.out.println("\nAll paths between " + sourceNode + " and " + destinationNode + ":");
    graph.calculateTotalDistance(sourceNode, destinationNode);
    
    System.out.println("\nDo you want to sort the path(s)?");
    System.out.println("\n1) Ascending order");
    System.out.println("\n2) Descending order");
    
    System.out.println("\nEnter your input: ");
    
    int ask = scanner.nextInt();
    
    if(ask == 1){
        // Print all paths and distances in ascending order
        System.out.println("\nAll paths and distances between " + sourceNode + " and " + destinationNode + " in ascending order:");
        graph.printAllPathsInOrder(sourceNode, destinationNode, true);

    }
    else if (ask ==2){
        // Print all paths and distances in descending order
        System.out.println("\nAll paths and distances between " + sourceNode + " and " + destinationNode + " in descending order:");
        graph.printAllPathsInOrder(sourceNode, destinationNode, false);
    }      
    
    else{
       break; 
    }
    
    
    
    // Calculate and print the shortest distance from source to destination
    int[] shortestDistances = graph.dijkstra(sourceNode);
    int destinationIndex = graph.nodeIndices.get(destinationNode);
    int shortestDistance = shortestDistances[destinationIndex];
        
    System.out.println("\nDo you want to check shortest path?");
    System.out.println("1)Yes \n2)No");
    
    int choice;
    
    System.out.println("Enter your input: ");
    
    int Choice = scanner.nextInt();
    
    if(Choice == 1){
           
    System.out.println("\nShortest distance from " + sourceNode + " to " + destinationNode + ": " + shortestDistance + " KM ");

    // Print the shortest path
    System.out.println("\nShortest path:");
    Graph.printPath(graph, sourceNode, destinationNode, shortestDistances);
  
    }
    
    else{
        System.out.println("\nThank you for visiting");
    }
       
            System.out.println("\nOptions:");
            System.out.println("1) Start from the login interface");
            System.out.println("2) Exit program");

        System.out.println("\nEnter your input: ");
            
        int choose = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choose == 1) {
            break;
        }
        else if (choose == 2) {
                System.out.println("\nExiting program...");
                System.exit(0);
            }
        scanner.close();
        } 
    }
}
