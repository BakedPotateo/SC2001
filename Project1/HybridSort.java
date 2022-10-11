package Project1;

import java.util.*;

public class HybridSort {
  public static int S;
  public static int X;
  public static long comp = 0;

  public static void insertionSort(int [] arr, int left, int right) {
      for (int i = left; i < right; i++) {
          
        int current = arr[i + 1];
        int j = i + 1;
          
        while (j > left && arr[j - 1] > current) {
          comp++;
          arr[j] = arr[j - 1];
          j--;
        }
        arr[j] = current;
      }
  }
  
  public static void merge(int [] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] L = Arrays.copyOfRange(arr, left, mid + 1);
    int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);
      
    int rightIndex = 0;
    int leftIndex = 0;
      
    for (int i = left; i < right + 1; i++) {
      if (rightIndex == n2) {
        comp++;
        arr[i] = L[leftIndex];
        leftIndex++;
      } 
      else if (leftIndex == n1) {
        comp++;
        arr[i] = R[rightIndex];
        rightIndex++;
      } 
      else if (R[rightIndex] > L[leftIndex]) {
        comp++;
        arr[i] = L[leftIndex];
        leftIndex++;
      } 
      else {
        comp++;
        arr[i] = R[rightIndex];
        rightIndex++;
      }
    }
  }

  public static void mergeSort(int [] arr, int left, int right) {
    if (right - left > S) {
      comp++;
      int mid = (left + right) / 2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    } 
    
    else 
      insertionSort(arr, left, right);
  }
  
  public static void main(String [] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int j;
      int k;

      long A1Tot = 0;
      long A2Tot = 0;
      long A3Tot = 0;
      long A4Tot = 0;
      long A5Tot = 0;

      long A1Time = 0;
      long A2Time = 0;
      long A3Time = 0;
      long A4Time = 0;
      long A5Time = 0;

      long startTime;
      long endTime;
      

      int[] Array1 = new int[1000];
      int[] Array2 = new int[10000];
      int[] Array3 = new int[100000];
      int[] Array4 = new int[1000000];
      int[] Array5 = new int[10000000];

      int[] userArray1 = new int[1000];
      int[] userArray2 = new int[10000];
      int[] userArray3 = new int[100000];
      int[] userArray4 = new int[1000000];
      int[] userArray5 = new int[10000000];
      
      System.out.printf("Enter value for X: ");
      X = sc.nextInt();

      for(k = 0; k < userArray1.length; k++)
        Array1[k] = (int)(Math.random()*(X - 1) + 1);

      for(k = 0; k < userArray2.length; k++)
        Array2[k] = (int)(Math.random()*(X - 1) + 1);

      for(k = 0; k < userArray3.length; k++)
        Array3[k] = (int)(Math.random()*(X - 1) + 1);

      for(k = 0; k < userArray4.length; k++)
        Array4[k] = (int)(Math.random()*(X - 1) + 1);

      for(k = 0; k < userArray5.length; k++)
        Array5[k] = (int)(Math.random()*(X - 1) + 1);
      // System.out.printf("Enter value for S: ");
      // S =sc.nextInt();

      
        
      System.out.println("Please wait...");
      System.out.println();
      System.out.println("S:Comparisons:Time:ArrSize");
      for(S = 1; S <= 80; S++){
        
        for(j = 0; j < 1; j++){
          startTime = System.nanoTime();

          userArray1 = Arrays.copyOf(Array1, Array1.length);
          mergeSort(userArray1, 0, userArray1.length - 1);

          endTime = System.nanoTime();
          A1Time += endTime - startTime;
          startTime = 0;
          endTime = 0;

          A1Tot += comp;
          comp = 0;
        }
  
        for(j = 0; j < 1; j++){
          userArray2 = Arrays.copyOf(Array2, Array2.length);

          startTime = System.nanoTime();

          mergeSort(userArray2, 0, userArray2.length - 1);

          endTime = System.nanoTime();
          A2Time += endTime - startTime;
          startTime = 0;
          endTime = 0;

          A2Tot += comp;
          comp = 0;
        }
  
        for(j = 0; j < 1; j++){
          userArray3 = Arrays.copyOf(Array3, Array3.length);

          startTime = System.nanoTime();

          mergeSort(userArray3, 0, userArray3.length - 1);

          endTime = System.nanoTime();
          A3Time += (endTime - startTime);
          startTime = 0;
          endTime = 0;

          A3Tot += comp;
          comp = 0;
        }
  
        for(j = 0; j < 1; j++){
          userArray4 = Arrays.copyOf(Array4, Array4.length);

          startTime = System.nanoTime();

          mergeSort(userArray4, 0, userArray4.length - 1);

          endTime = System.nanoTime();
          A4Time += endTime - startTime;
          startTime = 0;
          endTime = 0;

          A4Tot += comp;
          comp = 0;
        }
  
        for(j = 0; j < 1; j++){
          userArray5 = Arrays.copyOf(Array5, Array5.length);

          startTime = System.nanoTime();
          
          mergeSort(userArray5, 0, userArray5.length - 1);

          endTime = System.nanoTime();
          A5Time += endTime - startTime;
          startTime = 0;
          endTime = 0;

          A5Tot += comp;
          comp = 0;
        }
  
        // System.out.println();
        
        // System.out.println("Run " + S + ":");
        // System.out.println("Total comparisons (1):   " + (A1Tot));
        System.out.println(S+":"+(A1Tot/1) + ":" + A1Time/1000 + ":1000");
  
        // System.out.println("Total comparisons (2):   " + (A2Tot));
        System.out.println(S+":"+(A2Tot/1) + ":" + A2Time/1000 + ":10000");

        // System.out.println("Total comparisons (3):   " + (A3Tot));
        System.out.println(S+":"+(A3Tot/1) + ":" + A3Time/1000 + ":100000");

        // System.out.println("Total comparisons (4):   " + (A4Tot));
        System.out.println(S+":"+(A4Tot/1) + ":" + A4Time/1000 + ":1000000");

        // System.out.println("Total comparisons (5):   " + (A5Tot));
        System.out.println(S+":"+(A5Tot/1) + ":" + A5Time/1000 + ":10000000");

        A1Tot = 0;
        A2Tot = 0;
        A3Tot = 0;
        A4Tot = 0;
        A5Tot = 0;

        A1Time = 0;
        A2Time = 0;
        A3Time = 0;
        A4Time = 0;
        A5Time = 0;
      }
    }
  }
}