import java.util.*;

public class PQGraph {
    int V; // no. of vertices
    int dist[]; // array to store dist from source node
    Set<Integer> visited; // "array" that contains no duplicate elements, to see if node has been traversed
    PriorityQueue<GraphNode> PQueue; // priority queue structure
    List<List<GraphNode>> adjList; // adjacency list using List structure
    

    // constructor
    public PQGraph(int V){
        this.V = V;
        dist = new int[V];
        visited = new HashSet<Integer>(); // uses hash table to store data
        PQueue = new PriorityQueue<GraphNode>(V, new GraphNode());
    }

    public void Dijkstra(List<List<GraphNode>> adjList, int source){
        this.adjList = adjList;

        // set initial distance for all nodes from source node to infinity
        for(int i = 0; i < V; i++) 
            dist[i] = Integer.MAX_VALUE;
        
        // add source vertex to priority queue
        PQueue.add(new GraphNode(source, 0));
        dist[source] = 0;

        while (PQueue.size() > 0) {
            GraphNode current = PQueue.poll();
 
            for (GraphNode n :adjList.get(current.node)) {
                if (dist[current.node] + n.cost < dist[n.node]) {
                    dist[n.node] = n.cost + dist[current.node];
                    PQueue.add(new GraphNode(n.node, dist[n.node]));
                }
            }
        }
    }
}

