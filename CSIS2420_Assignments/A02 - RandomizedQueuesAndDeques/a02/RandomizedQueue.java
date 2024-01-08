/*
 * Created by: Kamdon Bird
 * Created date: Nov 27, 2022
 * Course class: CSIS 2420
 * Assignment: A02 - RandomizedQueuesAndDeques
 */
package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	
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
	private int n; //Counts size of Queue
	private Node<Item> first; //First Item in LinkedList Structure 
	private Node<Item> last; //Last Item in LinkedList Structure
	
	private static class Node<Item> { //Nested class created (statically used within Deque class)
		private Item item; //Stores Item of type Item type
		private Node<Item> next; //The 'next' Node of type 'Item type' will point to the next node in the LinkedList structure
		private Node<Item> prev; //The 'prev' Node of type 'Item type' will point to the previous node in the LinkedList structure
	}
	
	public RandomizedQueue() {
		
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
	public void enqueue(Item item) {
		if(item == null) throw new NullPointerException(); 
	}
	public void dequeue() {
		if(isEmpty()) throw new NoSuchElementException();
		
	}
	public void sample() {
		if(isEmpty()) throw new NoSuchElementException();
	}
	@Override
	public Iterator<Item> iterator() {
		return new IItemIterator();
	}
	
}
