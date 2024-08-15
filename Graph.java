import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    // Graph is network of nodes.
    /*
     * APplications of Graphs:
     *  - Maps. Social Network, Delivery Networks
     * 
     * Basics of Graph: unidirectional Bidirectional
     * 
     * Weighted Edge is basically the travel time/cost of going through an edge for going one node to another.
     * 
     * Storing a Graph
     * - Adjency list or matrix, edge list , 2d matrix (implicit graph)
     * 
     * Adjacency List: list of lists
     * 
     * BFS can also be called indirect level order travesal.
     */



     static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
     }

     public static void createGraph(ArrayList<Edge> graph[]){
        for (int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1, 2));
        graph[0].add(new Edge(0,2, 2));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0, 2));
        graph[2].add(new Edge(2,4, 0));
        // graph[2].add(new Edge(2,3, -1));

        graph[3].add(new Edge(3,1, 0));
        graph[3].add(new Edge(3,4, 0));
        graph[3].add(new Edge(3,5, 0));

        graph[3].add(new Edge(4,2, 0));
        graph[3].add(new Edge(4,5, 0));
        graph[3].add(new Edge(4,3, 0));

        graph[3].add(new Edge(5,3, 0));
        graph[3].add(new Edge(5,4, 0));
        graph[3].add(new Edge(5,6, 0));
     }
     // BFS :breadth first search
     public static void bfs(ArrayList<Edge> graph[], int V){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;

                for(int i =0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
     }

     public static void dfs(ArrayList<Edge> graph[], int curr,boolean vis[]){
        System.out.print(curr+" "); 
        vis[curr] = true;

        for(int i = 0; i <graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){dfs(graph, e.dest, vis);}
            
        }
     }
     
     public static void main(String args[]){
        int V =7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        //print 2's neighbors
        for(int i = 0; i< graph[1].size(); i++){
            Edge e = graph[1].get(i);
            System.out.println(e.dest+", "+e.weight);
        }

        System.out.println("BFS Traversal");
        bfs(graph, V);
        System.out.println();
        System.out.println("DFS Traversal");
        boolean vis[] = new boolean[V];
        dfs(graph, 0, vis);
     }

}
