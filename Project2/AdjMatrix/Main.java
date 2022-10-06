package SC2001.Project2.AdjMatrix;

public class Main {
    public static void main(String[] args) {
        int weightedGraph[][] = new int[][]{{0, 2, 0, 8, 7, 0, 0, 0, 0, 0, 0, 0},
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

        // for(int i = 0; i < 12; i++)
        //     for(int j = 0; j <12; j++)
        //         if (weightedGraph[i][j] != 0)
        //             weightedGraph[j][i] = weightedGraph[i][j];
        // int weightedGraph[][] = new int[][]{{0, 2, 1, 0, 0, 0}, 
        //                                     {2, 0, 7, 0, 8, 4}, 
        //                                     {1, 7, 0, 7, 0, 3}, 
        //                                     {0, 0, 7, 0, 8, 4}, 
        //                                     {0, 8, 0, 8, 0, 5}, 
        //                                     {0, 4, 3, 4, 5, 0}};
        int source = 0;
        ShortestPath graph = new ShortestPath(12, source);
        graph.Dijkstra(weightedGraph, source);
    }
}
