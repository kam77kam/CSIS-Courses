package a05;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;


public class A05_Old {

 public static void main(String[] args) {
     int N = 10000;
     Double[] data = new Double[N];

     for (int i = 0; i < N; i++) {
         data[i] = StdRandom.uniform(); // Generate random double values
     }

     System.out.println("Random data timings:");
     displayTimings(data.clone());

     // Sorted data
     Arrays.sort(data);
     System.out.println("\nSorted data timings:");
     displayTimings(data.clone());

     // Reverse sorted data
     Double[] reversed = new Double[N];
     for (int i = 0; i < N; i++) {
         reversed[i] = data[N - 1 - i];
     }
     System.out.println("\nReverse sorted data timings:");
     displayTimings(reversed);

     // Nearly sorted data (5% shuffled)
     for (int i = 0; i < N * 0.05; i++) {
         int idx1 = StdRandom.uniform(N);
         int idx2 = StdRandom.uniform(N);
         double temp = data[idx1];
         data[idx1] = data[idx2];
         data[idx2] = temp;
     }
     System.out.println("\nNearly sorted data timings (5% shuffled):");
     displayTimings(data.clone());

     // Duplicate data (only 10 unique values)
     for (int i = 0; i < N; i++) {
         data[i] = (double) StdRandom.uniform(10);
     }
     System.out.println("\nDuplicate data timings (only 10 unique values):");
     displayTimings(data.clone());
 }

 private static void displayTimings(Double[] data) {
     double time1 = timeSortMethod(data.clone(), "sort1");
     double time2 = timeSortMethod(data.clone(), "sort2");
     double time3 = timeSortMethod(data.clone(), "sort3");
     double time4 = timeSortMethod(data.clone(), "sort4");

     System.out.println("Time for sort1: " + time1);
     System.out.println("Time for sort2: " + time2);
     System.out.println("Time for sort3: " + time3);
     System.out.println("Time for sort4: " + time4);
 }




    private static double timeSortMethod(Double[] data, String methodName) {
        Stopwatch timer = new Stopwatch();

        switch (methodName) {
            case "sort1":
                Mystery.sort1(data);
                break;
            case "sort2":
                Mystery.sort2(data);
                break;
            case "sort3":
                Mystery.sort3(data);
                break;
            case "sort4":
                Mystery.sort4(data);
                break;
            default:
                throw new IllegalArgumentException("Invalid method name: " + methodName);
        }

        return timer.elapsedTime();
    }
}