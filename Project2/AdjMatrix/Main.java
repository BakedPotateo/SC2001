package SC2001.Project2.AdjMatrix;

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

            if(source < numVertices - 1 && source >= 0)
                break;
            else
                System.out.println("Invalid source!");
        }
        
        int weightedGraph[][] = new int[numVertices][numVertices];

        for(int i = 0; i < numVertices; i++)
            for(int j = 0; j < numVertices; j++){
                if(i == j)
                    weightedGraph[i][j] = 0;
                else
                    weightedGraph[i][j] = (int)(Math.random()*(20));
            }
        // int weightedGraph[][] = new int[][]{{0, 2, 0, 8, 7, 10, 0, 0, 0, 0, 0, 0},
        //                                     {0, 0, 3, 0, 0, 6, 0, 0, 0, 0, 0, 0},
        //                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0},
        //                                     {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2},
        //                                     {0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0},
        //                                     {0, 0, 0, 0, 0, 0, 2, 0, 6, 0, 13, 0},
        //                                     {0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        //                                     {0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
        //                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        //                                     {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0},
        //                                     {3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        //                                     {0, 0, 0, 0, 0, 0, 0, 3, 0, 1, 0, 0}};

        // for(int i = 0; i < 12; i++)
        //     for(int j = 0; j <12; j++)
        //         if (weightedGraph[i][j] != 0)
        //             weightedGraph[j][i] = weightedGraph[i][j];

        
        ShortestPath graph = new ShortestPath(numVertices, source);
        graph.Dijkstra(weightedGraph, source);
    }
}
