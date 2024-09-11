package microsoft;

import java.util.*;

public class ShortestPathUnweightedGraph {

    // Function to find the shortest path between node S and node T in an unweighted graph
    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());  // Each house has its own list of neighbors
        }

        // Add edges to the adjacency list
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];  // Starting point of the road
            int v = edges[i][1];  // End point of the road
            adjList.get(u).add(v);  // Add v to u's adjacency list
            adjList.get(v).add(u);  // Since the road is bidirectional, also add u to v's list
        }

        // Call BFS function to get the shortest path from s to t
        return bfs(s, t, adjList, n);
    }

    // BFS function to find the shortest path
    private static LinkedList<Integer> bfs(int s, int t, ArrayList<ArrayList<Integer>> adjList, int n) {
        // Parent array to track the path and backtrack from t to s
        int[] parent = new int[n + 1];  // Parent of each node in the shortest path
        Arrays.fill(parent, -1);  // Initialize parent array with -1 (no parent)

        // Queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);  // Start BFS from house S

        // Visited array to track whether a house has been visited or not
        boolean[] visited = new boolean[n + 1];  // Keep track of visited nodes
        visited[s] = true;  // Mark the start house as visited

        // BFS loop to explore neighbors level by level
        while (!queue.isEmpty()) {
            int current = queue.poll();  // Get the current house (node)

            // If we have reached the target house T, break the loop
            if (current == t) {
                break;
            }

            // Explore all neighbors of the current house
            for (int neighbor : adjList.get(current)) {
                // If the neighbor has not been visited
                if (!visited[neighbor]) {
                    visited[neighbor] = true;  // Mark the neighbor as visited
                    queue.offer(neighbor);  // Add it to the queue for further exploration
                    parent[neighbor] = current;  // Set the current house as the parent of the neighbor
                }
            }
        }

        // Reconstruct the path from T back to S using the parent array
        LinkedList<Integer> path = new LinkedList<>();
        for (int at = t; at != -1; at = parent[at]) {
            path.addFirst(at);  // Add the current node to the front of the path list
        }

        // Check if we could actually reach the start node S; otherwise, return an empty path
        if (path.get(0) != s) {
            return new LinkedList<>();  // No valid path found
        }

        return path;  // Return the reconstructed path
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of test cases
        int T = sc.nextInt();  // Number of test cases

        // Loop through each test case
        for (int test = 0; test < T; test++) {
            int n = sc.nextInt();  // Number of houses (nodes)
            int m = sc.nextInt();  // Number of roads (edges)

            int[][] edges = new int[m][2];  // To store the roads (edges)
            
            // Input the roads
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();  // Starting house
                edges[i][1] = sc.nextInt();  // Ending house
            }

            int s = sc.nextInt();  // Starting house for the path
            int t = sc.nextInt();  // Target house for the path

            // Get the shortest path from s to t
            LinkedList<Integer> result = shortestPath(edges, n, m, s, t);

            // Print the result path
            System.out.print("(");
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i != result.size() - 1) {
                    System.out.print(" , ");
                }
            }
            System.out.println(")");
        }

        sc.close();  // Close the scanner
    }
}

