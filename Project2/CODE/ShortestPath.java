public class ShortestPath {
    private int V;
    private int source;

    public ShortestPath(int V, int source){
        this.V = V;
        this.source = source;
    }
    
    int findMinDist(int pathArr[], Boolean shortestPathSet[]){
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;

        // shortestPathSet contains vertices with the shortest path from the source
        // pathArr contains shortest distance from source to pathArr[i]
        for (int i = 0; i < V; i++){
            if (shortestPathSet[i] == false && pathArr[i] <= minDist){
                minDist = pathArr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    void Dijkstra(int weightedGraph[][]){
        int pathArr[] = new int[V];
        Boolean shortestPathSet[] = new Boolean[V];

        for(int i = 0; i < V; i++){
            pathArr[i] = Integer.MAX_VALUE;
            shortestPathSet[i] = false;
        }

        pathArr[source] = 0;

        for(int count = 0; count < V -  1; count++){
            int u = findMinDist(pathArr, shortestPathSet);
            shortestPathSet[u] = true;

            for(int v = 0; v < V; v++)
                if(!shortestPathSet[v] && weightedGraph[u][v] != 0 && pathArr[u] != Integer.MAX_VALUE && pathArr[u] + weightedGraph[u][v] < pathArr[v])
                    pathArr[v] = pathArr[u] + weightedGraph[u][v];
        }
    }
}
