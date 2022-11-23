/*
 * Created by: Kamdon Bird
 * Created date: Nov 22, 2022
 * Course class: CSIS 2420
 * Assignment: A02 - RandomizedQueuesAndDeques
 */
package a02;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.lang.NullPointerException;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private int n;
	private Node<Item> first;
	private Node<Item> last;
	
	private static class Node<Item> { //nested class created (statically used within Deque class)
		private Item item;
		private Node<Item> next;
		private Node<Item> prev;
	}
	// construct an empty deque
	public Deque() {
		first = null;
		last = null;
		n = 0;
	}
	// is the deque empty?
	public boolean isEmpty() {
		return first == null;
	}
	// return the number of items on the deque
	public int size() {
		return n;
	}
	// insert the item at the front
	public void addFirst(Item item) {
		if (item == null) throw new NullPointerException();
	    Node<Item> oldfirst = first;
	    first = new Node<Item>();
	    first.item = item;
	    first.next = oldfirst;
	    first.prev = null;
	    if (oldfirst != null) {
	      oldfirst.prev = first;
	    } else {
	      last = first;
	    }
	    n++;
	}
	// insert the item at the end
	public void addLast(Item item) {
		if (item == null) throw new NullPointerException();
	    Node<Item> oldLast = last;
	    last = new Node<Item>();
	    last.item = item;
	    last.next = null;
	    last.prev = oldLast;
	    if (oldLast != null) {
	      oldLast.next = last;
	    } else {
	      first = last;
	    }
	    n++;
	}
	//delete and return the item at the front
	public Item removeFirst() {
		if(first == null) throw new NoSuchElementException("No Queue");
	}
	// delete and return the item at the end
	public Item removeLast() {
		if(last == null) throw new NoSuchElementException("No Queue");
	}
	//Returns an iterator that iterates over the items in this queue in FIFO order.
	public Iterator<Item> iterator() {
		
	}

	// unit testing
	public static void main(String[] args) {
		Deque<String> myNameArray = new Deque<String>();
		myNameArray.addFirst("Kamdon");
		myNameArray.addFirst("Bird");
		myNameArray.addLast("Troy");
		for(String c : myNameArray) {
			StdOut.print(c + " ");
		}
		
	}
}
