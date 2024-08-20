package treeQuestions;

import java.util.ArrayList;
import java.util.List;

/*
 * You have given a tree T of size N you are given a 2D array E of size M where there exists an edge between E[I][C] and E[I][1] for all 1<=i <=M

You have also given an array A of size N where node U has value A[U]

A path P is called a good path of greatest common division gcd of all values present on the path P is equal to 1 Two paths P1 and P2 are considered the same if they have the same number of nodes and each node X of path P1 belong to P2

Find the total number of possible good path present in T

Note The path (U,U) is valid for alll nodes U

Input format The first line contain and integer N denoting number of elements in A

The second line contain and integer M denoting the number of rows in E

The next line contain the integer two Denoting the number roof column in E

Each line I of N subsequent lines where 0<<i<=N contain integer describe A[i]

Each line 1 of M subsequent lines where 1<<i<=M contain two space separate integer each describing the row E[i]
 */
public class FindGoodPath{
        
    private static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    public static int countGoodPaths(int n, int[][] edges, int[] A) {
        // Create an adjacency list representation of the tree
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Perform DFS to count good paths
        int totalGoodPaths = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            totalGoodPaths += dfs(adjList, visited, i, A[i], A);
        }
        return totalGoodPaths;
    }

    private static int dfs(List<List<Integer>> adjList, boolean[] visited, int node, int currentGcd, int[] A) {
        visited[node] = true;
        int count = 0;

        if (currentGcd == 1) {
            count++;
        }

        // Explore all unvisited neighbors
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(adjList, visited, neighbor, gcd(currentGcd, A[neighbor]), A);
            }
        }

        visited[node] = false; // Reset visited for the next starting node
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { {1, 2}, {1, 3}, {2, 4}, {3, 5} };
        int[] A = {2, 3, 5, 7, 11};
        int goodPaths = countGoodPaths(n, edges, A);
        System.out.println("Total good paths: " + goodPaths);
    }

}
