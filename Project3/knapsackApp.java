package Project3;

import java.util.*;

public class knapsackApp {
    public static int bottomUpDP(int[][] DP_Arr, knapsackItem[] ItemArr, int capacity){
        for (int i = 0; i <= ItemArr.length; i++)
            for (int j = 0; j <= capacity; j++){
                if (i == 0 || j == 0)
                    DP_Arr[i][j] = 0;
                else if (ItemArr[i - 1].getWeight() <= j)
                    DP_Arr[i][j] = max(DP_Arr[i - 1][j], DP_Arr[i][j - ItemArr[i - 1].getWeight()] + ItemArr[i - 1].getProfit());
                else
                    DP_Arr[i][j] = DP_Arr[i - 1][j];
                
                // for (int p = 0; p <= ItemArr.length; p++){
                //     for (int q = 0; q <= capacity; q++){
                //         System.out.printf(DP_Arr[p][q] + " ");
                //     }
                //     System.out.println();
                // }
                // System.out.println();
            }
        return DP_Arr[ItemArr.length][capacity];
    }

    public static int max(int a, int b){
        if (a > b)
            return a;
        else return b;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int C = 14;

        int[][] DP_Arr_a = new int[n+1][C+1];
        int[][] DP_Arr_b = new int[n+1][C+1];

        knapsackItem[] knapsackItems_a = new knapsackItem[n];

        knapsackItems_a[0] = new knapsackItem(4, 7);
        knapsackItems_a[1] = new knapsackItem(6, 6);
        knapsackItems_a[2] = new knapsackItem(8, 9);

        knapsackItem[] knapsackItems_b = new knapsackItem[n];

        knapsackItems_b[0] = new knapsackItem(5, 7);
        knapsackItems_b[1] = new knapsackItem(6, 6);
        knapsackItems_b[2] = new knapsackItem(8, 9);

        System.out.println("a) The maximum value is " + bottomUpDP(DP_Arr_a, knapsackItems_a, C));
        System.out.println("b) The maximum value is " + bottomUpDP(DP_Arr_b, knapsackItems_b, C));
        sc.close();
    }
}