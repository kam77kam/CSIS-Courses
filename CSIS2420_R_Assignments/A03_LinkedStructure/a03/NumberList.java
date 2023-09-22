package a03;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * NumberList is a singly-linked list of integers. It is designed as a practice
 * opportunity to learn how to manipulate linked structures.
 * 
 * @author Kamdon Bird, Haiyang Liu
 */
public class NumberList {
	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null
	private int n; // number of integers in the list

	/**
	 * Node of LinkedList that stores the item and a single reference to the next
	 * node.
	 */
	private static class Node {
		private double item;
		private Node next;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return value of the field <code>n</code>.
	 */
	public int size() {
		return n;
	}

	/**
	 * Determines whether the list is empty or not.
	 * 
	 * @return true if there are no elements in the list.
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Adds a node containing the new item at the end of the list.
	 * 
	 * @param item
	 */
	public void add(double item) {
		Node newNode = new Node();
		newNode.item = item;

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		n++;
	}

	/**
	 * Returns the first element of the list.
	 * 
	 * Example: [1.1, 2.5, 3.0, 4.4, 5.5] -> returns 1.1
	 * 
	 * @return first element.
	 * @throws NoSuchElementException if the list is empty.
	 */
	public double firstElement() {
		if (isEmpty())
			throw new NoSuchElementException("The list is empty");
		return head.item;
	}

	/**
	 * Determines if the last element is a positive number.
	 * 
	 * @return true if the last element is positive and false otherwise.
	 * @throws IllegalStateException if the list is empty.
	 */
	public boolean endsPositive() {
		if (isEmpty())
			throw new IllegalStateException("The list is empty");
		return tail.item > 0;
	}

	/**
	 * Calculates and returns the average of all elements in the linked list.
	 *
	 * Example: [1.1, 2.5, 3.0, 4.4, 5.5] -> returns 3.3
	 *
	 * @return The average of the elements in the linked list, or 0.0 if the list is
	 *         empty.
	 * @throws IllegalStateException if the list is empty.
	 */
	public double average() {
		if (isEmpty())
			throw new IllegalStateException("The list is empty.");

		Node current = head;
		double sum = 0.0;
		int count = 0;

		while (current != null) {
			sum += current.item;
			count++;
			current = current.next;
		}

		return sum / count;
	}

	/**
	 * Fills the linked list with the specified item value. This method sets each
	 * element in the linked list to the provided item value, effectively replacing
	 * all existing values. If the list is empty, it remains empty.
	 *
	 * @param item The item value to fill the linked list with.
	 */
	public void fill(double item) {
		if (isEmpty())
			return;
		Node current = head;
		while (current != null) {

			current.item = item;
			current = current.next;
		}
	}

	/**
	 * Inserts a new item at the specified index in the linked list. The index
	 * should be in the range [0, n], where n is the current size of the list. If
	 * the index is equal to n, the item is added to the end of the list.
	 *
	 * Example: index = 2 and item = 0.5 [1.1, 2.5, 3.0, 4.4, 5.5] -> [1.1, 2.5,
	 * 0.5, 3.0, 4.4, 5.5]
	 * 
	 * @param index The index at which the new item will be inserted.
	 * @param item  The item to be inserted into the linked list.
	 * @throws IndexOutOfBoundsException If the index is outside the valid range [0,
	 *                                   n].
	 */
	public void insert(int index, double item) {
		if (index < 0 || index > n)
			throw new IndexOutOfBoundsException("The index is outside of the valid range[0, n]");

		Node newNode = new Node();
		newNode.item = item;

		if (index == 0) {
			newNode.next = head;
			head = newNode;
			n++;
		}
		// Insert at the end
		else if (index == n) 
			add(newNode.item);
		// Insert in the middle
		else {
			Node current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			n++;
		}
	}

	/**
	 * Removes the first occurrence of the specified item from the linked list. If
	 * the item is found and removed, the method returns true. If the list is empty
	 * or the item is not found, it returns false.
	 * 
	 * Example: item = 2.2 [1.1, 4.4, 2.2, 1.1, 3.3, 2.2] -> [1.1, 4.4, 1.1, 3.3,
	 * 2.2] and returns true
	 *
	 * Example: item = 2.5 [1.1, 4.4, 2.2, 1.1, 3.3, 2.2] -> returns false and the
	 * list remains unchanged
	 *
	 * @param item The item to be removed from the linked list.
	 * @return True if the item is found and removed and false otherwise.
	 */
	public boolean remove(double item) {

		if (head == null) {
			return false;
		}
		if (head.item == item) {
			head = head.next;
			n--;
			return true;
		}
		Node current = head;
		Node previous = null;
		while (current != null && current.item != item) {
			previous = current;
			current = current.next;
		}
		if (current != null) {
			previous.next = current.next;
			n--;
			return true;

		}
		return false;
	}

	/**
	 * Removes duplicate elements from the linked list. If there are duplicate
	 * elements, the first occurrence of each duplicate element will be retained,
	 * and subsequent occurrences will be removed. The order of the remaining
	 * elements will be preserved.
	 * 
	 * Example: [1.1, 4.4, 2.2, 1.1, 3.3, 2.2, 1.1] -> [1.1, 4.4, 2.2, 3.3]
	 */
	public void removeDuplicates() {
		if (isEmpty()) {
			return;
		}
		Set<Double> seen = new HashSet<>();
		Node current = head;
		Node prev = null;

		while (current != null) {
			if (seen.contains(current.item)) {
				prev.next = current.next;
				if (current == tail) {
					tail = prev;
				}
				n--;
			} else {
				seen.add(current.item);
				prev = current;
			}
			current = current.next;
		}
	}

	/**
	 * Rotates the linked list to the right by a specified number of positions in a
	 * cyclic manner. If the list is empty or <code>positions</code> is a multiple
	 * of n, no rotation will be performed.
	 * 
	 * Example: positions = 2 [1.1, 2.2, 3.3, 4.4, 5.5] -> [4.4, 5.5, 1.1, 2.2, 3.3]
	 *
	 * Example: positions = 6 [1.1, 2.2, 3.3, 4.4, 5.5] -> [5.5, 1.1, 2.2, 3.3, 4.4]
	 * 
	 * @param positions The number of positions to rotate the linked list to the
	 *                  right.
	 * @throws IllegalArgumentException if the number of positions is not positive.
	 */
	public void rotateRight(int positions) {
		if (positions <= 0) 
			throw new IllegalArgumentException("Positive number only");
		if (isEmpty() || n == 1 || positions % n == 0) 
			return;
		Node current = head;
		int actualPositions = positions % n;
		for (int i = 1; i < n - actualPositions; i++) {
			current = current.next;
		}
		Node newHead = current.next;
		current.next = null;
		if (tail != null)
			tail.next = head;
		head = newHead;
		tail = current;
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;

		while (current != null) {
			sb.append(current.item).append(" ");
			current = current.next;

		}

		return sb.toString();
	}
}