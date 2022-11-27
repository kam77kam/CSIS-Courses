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
	
	private int n; //Counts size of Queue
	private Node<Item> first; //First Item in LinkedList Structure 
	private Node<Item> last; //Last Item in LinkedList Structure
	
	private static class Node<Item> { //Nested class created (statically used within Deque class)
		private Item item; //Stores Item of type Item type
		private Node<Item> next; //The 'next' Node of type 'Item type' will point to the next node in the LinkedList structure
		private Node<Item> prev; //The 'prev' Node of type 'Item type' will point to the previous node in the LinkedList structure
	}
	/** @see Constructs an empty Queue/Deque*/
	public Deque() {
		first = null;
		last = null;
		n = 0;
	}
	/** @see Checks if the Deque is empty 
	  *	@return boolean
	  */
	public boolean isEmpty() {
		return n == 0;
	}
	/** @return Number of items on the deque/LinkedList structure*/
	public int size() {
		return n;
	}
	/**@see Inserts an item at the front of the deque LinkedList structure
	  *@throws NullPointerException if item is null
	  *@param item
	  */
	public void addFirst(Item item) {
		if (item == null) throw new NullPointerException();
	    Node<Item> oldFirst = first; //store the current first element
	    first = new Node<Item>(); //the new first node is created
	    first.item = item; //item saved to new first node
	    first.next = null; //newly created Nodes that are going into the front will be null
	    first.prev = oldFirst; //points the new node in front of the old node
	    if (oldFirst != null) oldFirst.next = first; //points the old node to the new node
	    else last = first; //if this is the first added node it will also be the last node
	    n++; //increment count
	}
	/**@see Inserts an item at the end of the deque LinkedList structure
	  *@throws NullPointerException if item is null
	  *@param item
	  */
	public void addLast(Item item) {
		if (item == null) throw new NullPointerException();
	    Node<Item> oldLast = last; //store the current last element
	    last = new Node<Item>(); //the new last node is created
	    last.item = item; //item saved to new last node
	    last.prev = null; //newly created Nodes that are going into the front will be null
	    last.next = oldLast; //points the new node to the old node
	    if (oldLast != null) oldLast.prev = last; //points the old node to the new node
	    else first = last; //if this is the first added node it will also be the first node
	    n++; //increment count
	}
	/**@return Delete and returns the item at the front
	  *@throws NoSuchElementException if Deque/LinkedList structure is empty*/
	public Item removeFirst() {
		if(isEmpty()) throw new NoSuchElementException("Nothing to Dequeue"); //checks if list is empty
		Node<Item> oldFirst = first; //store the first node in the list
		if(first.prev == null) { //if there is nothing previous of the first node
			first = null; //nothing exists previous of the first, set first to null		
		}else {
			first = oldFirst.prev; //the new first node is now the previous node in the list
			first.next = null; //the next node (first node) is gone and now points to null
		}
		n--; //decrement count
		return oldFirst.item; //returns the item of previous node to the first node which might be null
	}
	/**@return Delete and returns the item at the end
	  *@throws NoSuchElementException if Deque/LinkedList structure is empty*/
	public Item removeLast() {
		if(isEmpty()) throw new NoSuchElementException("Nothing to Dequeue"); //checks if list is empty
		if(last == first) removeFirst();
		Node<Item> oldLast = last; //store the last node in the list
		if(last.next == null) { //if there is nothing next of the last node
			last = null; //nothing exists next of the last, set last to null	
		}else{
			last = oldLast.next; //last is now the next node
			last.prev = null; // nothing exists previous the last, set previous to null
		}
		n--; //decrement count
		return oldLast.item; //returns the item of next node to the last node which might be null
	}
	// Returns an iterator that iterates over the items in this queue in FIFO order.
	public Iterator<Item> iterator() {
		return new IItemIterator();
	}
	/**@param <Item> the type of elements returned by this iterator*/
	private class IItemIterator implements Iterator<Item> {
		private Node<Item> current = first; //store the first node
		
		/** @return boolean. checks if the iteration has more elements*/
		public boolean hasNext() {
			return current != null;
		}
	     /** @throws UnsupportedOperationException if the {@code remove}        
	       * operation is not supported by this iterator
	       */
		public void remove() {
			throw new java.lang.UnsupportedOperationException("remove");
		}
		/**
	     * Returns the next element in the iteration.
	     * @param <Item> the type of elements returned by this iterator
	     * @return the next element in the iteration
	     * @throws UnsupportedOperationException if the iteration has no elements
	     */
		public Item next() {
			if (current == null) 
				throw new java.lang.UnsupportedOperationException();
			Item item = current.item;
			current = current.prev;
			return item;
		}
	}
	// Unit testing
	public static void main(String[] args) {
		Deque<String> myNameArray = new Deque<String>();
		myNameArray.addFirst("Bird");
		myNameArray.addFirst("Troy");
		myNameArray.addFirst("Kamdon");
		Iterator<String> iterator = myNameArray.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();
		Deque<String> myNameArray2 = new Deque<String>();
		myNameArray2.addFirst("Barton");
		myNameArray2.addFirst("Sami");
		Iterator<String> iterator2 = myNameArray2.iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
		System.out.println();
		System.out.println("Size of myNameArray: " + myNameArray.size());
		System.out.println("Size of myNameArray2: " + myNameArray2.size());
		
	}
	
}
