package SC2001.Project2.PriorityQueue;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int V = 12;
        int source = 0;

        // adjacency list representation of graph
        List<List<GraphNode> > adjList = new ArrayList<List<GraphNode>>();

        // Initialise adjacency list for each node
        for (int i = 0; i < V; i++) { 
            List<GraphNode> item = new ArrayList<GraphNode>(); 
            adjList.add(item); 
        } 

        // create graph
        adjList.get(0).add(new GraphNode(1, 2));
        adjList.get(0).add(new GraphNode(3, 8));
        adjList.get(0).add(new GraphNode(4, 7));
        adjList.get(0).add(new GraphNode(5, 10));

        adjList.get(1).add(new GraphNode(2, 3));
        adjList.get(1).add(new GraphNode(5, 6));

        adjList.get(2).add(new GraphNode(10, 17));

        adjList.get(3).add(new GraphNode(5, 1));
        adjList.get(3).add(new GraphNode(11, 2));

        adjList.get(4).add(new GraphNode(7, 16));

        adjList.get(5).add(new GraphNode(6, 2));
        adjList.get(5).add(new GraphNode(8, 6));
        adjList.get(5).add(new GraphNode(10, 13));

        adjList.get(6).add(new GraphNode(2, 5));

        adjList.get(7).add(new GraphNode(3, 2));

        adjList.get(8).add(new GraphNode(11, 1));

        adjList.get(9).add(new GraphNode(5, 2));
        adjList.get(9).add(new GraphNode(10, 1));

        adjList.get(10).add(new GraphNode(0, 3));
        adjList.get(10).add(new GraphNode(6, 1));

        adjList.get(11).add(new GraphNode(7, 3));
        adjList.get(11).add(new GraphNode(9, 1));
 

        // call Dijkstra's algo method  
        PQGraph testGraph = new PQGraph(V); 
        testGraph.Dijkstra(adjList, source); 
   
        // Print the shortest path from source node to all the nodes 
        System.out.println("The shorted path from source node to other nodes:"); 
        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
        for (int i = 0; i < testGraph.dist.length; i++) 
            System.out.println(source + " \t\t " + i + " \t\t "  + testGraph.dist[i]);
    }
}
