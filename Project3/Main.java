package Project3;

import java.util.*;

public class Main {
    public static int bottomUpDP(int[][] DP_Arr, knapsackItem[] KArr, int capacity){
        int i, j;
        int size;
        for (i = 1; i <= KArr.length - 1; i++)
            for (j = 0; j <= capacity; j++){
        
                size = KArr[i].getWeight();
                if (size <= j)
                    DP_Arr[i][j] = max(DP_Arr[i - 1][j], DP_Arr[i - 1][j - size] + KArr[i].getProfit());
                else
                    DP_Arr[i][j] = DP_Arr[i - 1][j];
            }
        return DP_Arr[KArr.length - 1][capacity];
    }

    public static int max(int a, int b){
        if (a > b)
            return a;
        else return b;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        System.out.println("Enter the capacity of the knapsack: ");
        int C = sc.nextInt();

        int[][] DP_Arr = new int[n+1][C+1];

        for (int i = 0; i < n; i++)
            for(int j = 0; j <= C; j++)
                DP_Arr[i][j] = 0;
        
        knapsackItem[] knapsackItems = new knapsackItem[n + 1];

        for(int i = 0; i <= n; i++)
            knapsackItems[i] = new knapsackItem();
        
        knapsackItems[0] = new knapsackItem(0,0);
        System.out.println("Enter the weight of items in order: ");
        for(int i = 1; i <= n; i++)
            knapsackItems[i].setWeight(sc.nextInt());
        System.out.println("Enter the profit of items in order: ");
        for(int i = 1; i <= n; i++)
            knapsackItems[i].setProfit(sc.nextInt());

        System.out.println("The maximum value is " + bottomUpDP(DP_Arr, knapsackItems, C));
        sc.close();
    }
}