package ceHeapSort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MaxPQ;
/**
 * The DemoHeap class showcases the underlying idea of heapsort. It does not implement 
 * the full heapsort algorithm but provides insight into its fundamental concepts. 
 * 
 * The steps demonstrated in this class:
 * 1. Efficiently convert the array into a binary heap by heapifying the array
 * 2. Repeatedly extract elements from the heap, printing them one at a time, to obtain 
 *    the desired sorted order.
 *
 * @author CSIS + Kamdon Bird
 * s
*/
public class DemoHeap {

	public static void main(String[] args) {
//      Create an array of 25 random Mail objects and print it.
		StdOut.println("Random Mail:");
		StdOut.println("------------");
		Mail[] mailArray = new Mail[25];
		for(int i = 0; i < 25; i++) {
			Mail m = new Mail();
			mailArray[i] = m;
			StdOut.println(m.toString());
		}
		StdOut.println();
		
		StdOut.println("Ordered Mail:");
		StdOut.println("-------------");
		
		// List the mail from most urgent to least urgent in linear time.
		// Steps:
		// a) Determine whether you need a min heap or a max heap
		//    to list the most urgent mail first.
		// b) Use MinPQ or MaxPQ to create the appropriate priority queue.
		//    Choose the constructor that heapifies the array.
		// c) Remove and print the elements from the priority queue - one at a time.

	}
}
