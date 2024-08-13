import java.util.ArrayList;

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
     */



     static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
     }

     public static void createGraph(ArrayList<Edge> graph[]){
        for (int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
     }
     public static void main(String args[]){
        int V =4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        //print 2's neighbors
        for(int i = 0; i< graph[1].size(); i++){
            Edge e = graph[1].get(i);
            System.out.println(e.dest+" ");
        }
     }

}
