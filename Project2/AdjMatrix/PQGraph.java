import java.util.*;

public class PQGraph {
    int V; // no. of vertices
    int dist[]; // array to store dist from source node
    Set<Integer> visited; // "array" that contains no duplicate elements, to see if node has been traversed
    PriorityQueue<GraphNode> PQueue; // priority queue structure
    List<List<GraphNode>> adjList; // adjacency list using LL
    

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

        while(visited.size() != V){
            // add source node to visited list
            int u = PQueue.remove().node;
            visited.add(u);
            adjGraphNodes(u);
        }
    }

    // process neighbouring nodes
    private void adjGraphNodes(int u){
        int edgeDistance = -1; 
        int newDistance = -1; 
   
        // process all neighbouring nodes of u 
        for (int i = 0; i < adjList.get(u).size(); i++) { // adjList.get(u) returns a LL with root node u
            GraphNode v = adjList.get(u).get(i); // returns whole node linked to u, note node number/cost
   
            // proceed only if current node is not in 'visited'
            if (!visited.contains(v.node)) { 
                edgeDistance = v.cost; 
                newDistance = dist[u] + edgeDistance; 
   
                // compare distances 
                if (newDistance < dist[v.node]) 
                    dist[v.node] = newDistance; 
   
                // Add the current vertex to the PriorityQueue 
                PQueue.add(new GraphNode(v.node, dist[v.node])); 
            }
        }
    }
}

