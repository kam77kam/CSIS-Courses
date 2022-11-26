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
	// Construct an empty deque
	public Deque() {
		first = null;
		last = null;
		n = 0;
	}
	// Is the deque empty?
	public boolean isEmpty() {
		return first == null;
	}
	// Return the number of items on the deque
	public int size() {
		return n;
	}
	// Insert the item at the front
	public void addFirst(Item item) {
		if (item == null) throw new NullPointerException();
	    Node<Item> oldfirst = first;
	    first = new Node<Item>();
	    first.item = item;
	    first.next = oldfirst;
	    first.prev = null;
	    if (oldfirst != null) oldfirst.prev = first;
	    else last = first;
	    n++;
	}
	// Insert the item at the end
	public void addLast(Item item) {
		if (item == null) throw new NullPointerException();
	    Node<Item> oldLast = last;
	    last = new Node<Item>();
	    last.item = item;
	    last.next = null;
	    last.prev = oldLast;
	    if (oldLast != null) oldLast.next = last;
	    else first = last;
	    n++;
	}
	// Delete and return the item at the front
	public Item removeFirst() {
		if(n == 0) 
			throw new NoSuchElementException("Nothing to Dequeue");
		Node<Item> oldFirst = first;
		first = oldFirst.next;
		if (first == null) last = null;
		n--;
		return oldFirst.item;
	}
	// Delete and return the item at the end
	public Item removeLast() {
		if(n == 0) 
			throw new NoSuchElementException("Nothing to Dequeue");
		Node<Item> oldLast = last;
		last = oldLast.prev;
		if(last == null) first = null;
		n--;
		return oldLast.item;
	}
	// Returns an iterator that iterates over the items in this queue in FIFO order.
	public Iterator<Item> iterator() {
		return new IItemIterator();
	}
	
	
	
	private class IItemIterator implements Iterator<Item> {
		private Node<Item> current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
			throw new java.lang.UnsupportedOperationException("'Remove' is not acceptable ");
		}
		public Item next() {
			if (current == null) 
				throw new java.lang.UnsupportedOperationException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	// Unit testing
	public static void main(String[] args) {
		Deque<String> myNameArray = new Deque<String>();
		myNameArray.addFirst("Kamdon");
		myNameArray.addLast("Troy");
		myNameArray.addLast("Bird");
		myNameArray.removeLast();
		Iterator<String> iterator = myNameArray.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
	
}
