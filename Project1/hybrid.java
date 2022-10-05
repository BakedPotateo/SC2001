package SC2001.Project1;

import java.util.*;
import java.util.Scanner;

public class hybrid {
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
      long A1Tot = 0;
      long A2Tot = 0;
      long A3Tot = 0;
      long A4Tot = 0;
      long A5Tot = 0;

      
      int[] userArray1 = new int[1000];
      int[] userArray2 = new int[10000];
      int[] userArray3 = new int[100000];
      int[] userArray4 = new int[1000000];
      int[] userArray5 = new int[10000000];
      
      // System.out.printf("Enter value for S: ");
      // S =sc.nextInt();

      System.out.printf("Enter value for X: ");
      X = sc.nextInt();
        
      System.out.println("Please wait...");
      for(S = 1; S <= 100; S++){
        
        // userArray1 = Arrays.copyOfRange(Array1, 0, Array1.length + 1);
        // userArray2 = Arrays.copyOfRange(Array2, 0, Array2.length + 1);
        // userArray3 = Arrays.copyOfRange(Array3, 0, Array3.length + 1);
        // userArray4 = Arrays.copyOfRange(Array4, 0, Array4.length + 1);
        // userArray5 = Arrays.copyOfRange(Array5, 0, Array5.length + 1);
        
        for(j = 0; j < 100; j++){
          for(j = 0; j < userArray1.length; j++)
            userArray1[j] = (int)(Math.random()*(X - 1) + 1);
          mergeSort(userArray1, 0, userArray1.length - 1);
          A1Tot += comp;
          System.out.println(A1Tot);
          comp = 0;
        }
  
        for(j = 0; j < 100; j++){
          for(j = 0; j < userArray2.length; j++)
            userArray2[j] = (int)(Math.random()*(X - 1) + 1);
          mergeSort(userArray2, 0, userArray2.length - 1);
          A2Tot += comp;
          comp = 0;
        }
  
        for(j = 0; j < 100; j++){
          for(j = 0; j < userArray3.length; j++)
            userArray3[j] = (int)(Math.random()*(X - 1) + 1);
          mergeSort(userArray3, 0, userArray3.length - 1);
          A3Tot += comp;
          comp = 0;
        }
  
        for(j = 0; j < 100; j++){
          for(j = 0; j < userArray4.length; j++)
            userArray4[j] = (int)(Math.random()*(X - 1) + 1);
          mergeSort(userArray4, 0, userArray4.length - 1);
          A4Tot += comp;
          comp = 0;
        }
  
        for(j = 0; j < 100; j++){
          for(j = 0; j < userArray5.length; j++)
            userArray5[j] = (int)(Math.random()*(X - 1) + 1);
          mergeSort(userArray5, 0, userArray5.length - 1);
          A5Tot += comp;
          comp = 0;
        }
  
        System.out.println();

        System.out.println("Run " + S + ":");
        // System.out.println("Total comparisons (1):   " + (A1Tot));
        System.out.println("Average comparisons (1): " + (A1Tot/100));
  
        // System.out.println("Total comparisons (2):   " + (A2Tot));
        System.out.println("Average comparisons (2): " + (A2Tot/100));
  
        // System.out.println("Total comparisons (3):   " + (A3Tot));
        System.out.println("Average comparisons (3): " + (A3Tot/100));
  
        // System.out.println("Total comparisons (4):   " + (A4Tot));
        System.out.println("Average comparisons (4): " + (A4Tot/100));
  
        // System.out.println("Total comparisons (5):   " + (A5Tot));
        System.out.println("Average comparisons (5): " + (A5Tot/100));

        A1Tot = 0;
        A2Tot = 0;
        A3Tot = 0;
        A4Tot = 0;
        A5Tot = 0;
      }
    }
  }
}