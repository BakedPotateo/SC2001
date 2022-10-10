import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int source = 0;
        int numVertices;
        Graph[] arr = new Graph[20];
        
        int run;
        System.out.println("Input no. of runs:");
        int numRuns = sc.nextInt();
        long[][] MatxRunsArr = new long[numRuns][20];
        long[][] ListRunsArr = new long[numRuns][20];
        int[][] EdgeArray = new int[numRuns][20];

        // construct graph
        for(run = 0; run < numRuns; run++){
            System.out.println("Run " + (run + 1));
            numVertices = 50;
            // System.out.println("AdjMatrix");
            for(int i = 0; i < 20; i++){
                Graph g = new Graph(numVertices, 20, false);
                arr[i] = g;
                // g.printGraph();

                // AdjMatrix
                ShortestPath graph = new ShortestPath(numVertices, source);
                long time1 = System.nanoTime();
                graph.Dijkstra(g.adjMatrix);
                long time2 = System.nanoTime();
                // System.out.println(numVertices+" "+g.randEdges+" "+(time2-time1));
                MatxRunsArr[run][i] = time2 - time1;
                EdgeArray[run][i] = g.randEdges;

                numVertices += 50;
            }

            numVertices = 50;
            // System.out.println();
            // System.out.println("AdjList");
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

                // System.out.println(numVertices+" "+g.randEdges+" "+(time4-time3));
                ListRunsArr[run][k] = time4 - time3;
                numVertices += 50;
                adjList.clear();
            }
        }
        
        long[] MatxRunsAvg = new long[20];
        long[] ListRunsAvg = new long[20];
        int[] EdgeAvg = new int[20];

        for(int i = 0; i < 20; i++){
            long sum1 = 0;
            long sum2 = 0;
            int sum3 = 0;
            for(int j = 0; j < numRuns; j++){
                sum1 += MatxRunsArr[j][i];
                sum2 += ListRunsArr[j][i];
                sum3 += EdgeArray[j][i];
            }
            MatxRunsAvg[i] = sum1/numRuns;
            ListRunsAvg[i] = sum2/numRuns;
            EdgeAvg[i] = sum3/numRuns;
        }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("AdjMatrix");
        for(int i = 0; i < 20; i++)
            System.out.println((i + 1)*50+" "+EdgeAvg[i]+" "+MatxRunsAvg[i]);
        
        System.out.println("AdjList");
        for(int i = 0; i < 20; i++)
            System.out.println((i + 1)*50+" "+EdgeAvg[i]+" "+ListRunsAvg[i]);
        sc.close();
    }
}