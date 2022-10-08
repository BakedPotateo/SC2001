import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int source = 0;
        int numVertices = 50;
        Graph[] arr = new Graph[20];
        
        // construct graph
        System.out.println("AdjMatrix");
        for(int i = 0; i < 20; i++){
            Graph g = new Graph(numVertices, 20);
            arr[i] = g;
            // g.printGraph();

            // AdjMatrix
            ShortestPath graph = new ShortestPath(numVertices, source);
            long time1 = System.nanoTime();
            graph.Dijkstra(g.adjMatrix, source);
            long time2 = System.nanoTime();
            System.out.println(numVertices+" "+g.maxEdges+" "+(time2-time1));
            numVertices += 50;
        }

        numVertices = 50;
        System.out.println();
        System.out.println("AdjList");
        for(int k = 0; k < 20; k++){
            // adjacency list representation of graph
            List<List<GraphNode> > adjList = new ArrayList<List<GraphNode>>();
            for (int i = 0; i < numVertices; i++) { 
                List<GraphNode> item = new ArrayList<GraphNode>(); 
                adjList.add(item); 
            } 

            // convert AdjMatrix to AdjList
            Graph g = arr[k];
            for(int i = 0; i < numVertices; i++)
                for(int j = 0; j < numVertices; j++)
                    if(g.adjMatrix[i][j] != 0)
                        adjList.get(i).add(new GraphNode(j, g.adjMatrix[i][j]));

            // AdjList
            PQGraph testGraph = new PQGraph(numVertices); 
            long time3 = System.nanoTime();
            testGraph.Dijkstra(adjList, source); 
            long time4 = System.nanoTime();

            System.out.println(numVertices+" "+g.maxEdges+" "+(time4-time3));
            numVertices += 50;
            adjList.clear();
        }

        sc.close();
    }
}