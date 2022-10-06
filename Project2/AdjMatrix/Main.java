package SC2001.Project2.AdjMatrix;

public class Main {
    public static void main(String[] args) {
        int weightedGraph[][] = new int[][]{{0, 2, 0, 8, 7, 10, 0, 0, 0, 0, 0, 0},
                                            {0, 0, 3, 0, 0, 6, 0, 0, 0, 0, 0, 0},
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0},
                                            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2},
                                            {0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0},
                                            {0, 0, 0, 0, 0, 0, 2, 0, 6, 0, 13, 0},
                                            {0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                            {0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                            {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0},
                                            {3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                            {0, 0, 0, 0, 0, 0, 0, 3, 0, 1, 0, 0}};

        
        int source = 0;
        ShortestPath graph = new ShortestPath(12, source);
        graph.Dijkstra(weightedGraph, source);
    }
}
