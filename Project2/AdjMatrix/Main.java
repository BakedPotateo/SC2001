import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int source;
        System.out.printf("Input no. of vertices: ");
        int numVertices = sc.nextInt();

        while(true){
            System.out.printf("Input source vertex: ");

            source = sc.nextInt();

            if(source <= numVertices - 1 && source >= 0)
                break;
            else
                System.out.println("Invalid source!");
        }
        
        
        // construct graph
        Graph g = new Graph(numVertices, 20, 0);
        
        // adjacency list representation of graph
        List<List<GraphNode> > adjList = new ArrayList<List<GraphNode>>();
        for (int i = 0; i < numVertices; i++) { 
            List<GraphNode> item = new ArrayList<GraphNode>(); 
            adjList.add(item); 
        } 

        // convert AdjMatrix to AdjList
        for(int i = 0; i < numVertices; i++)
            for(int j = 0; j < numVertices; j++)
                if(g.adjMatrix[i][j] != 0)
                    adjList.get(i).add(new GraphNode(j, g.adjMatrix[i][j]));


        // AdjMatrix
        ShortestPath graph = new ShortestPath(numVertices, source);
        graph.Dijkstra(g.adjMatrix, source);
  
        // AdjList
        PQGraph testGraph = new PQGraph(numVertices); 
        testGraph.Dijkstra(adjList, source); 
   
        // Print the shortest path from source node to all the nodes for AdjList
        System.out.println("The shortest path from source node to other nodes:"); 
        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
        for (int i = 0; i < testGraph.dist.length; i++) 
            System.out.println(source + " \t\t " + i + " \t\t "  + testGraph.dist[i]);
            
        sc.close();
    }
}
