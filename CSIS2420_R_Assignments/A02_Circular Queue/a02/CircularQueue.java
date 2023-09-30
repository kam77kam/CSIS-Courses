package a02;

import java.util.Iterator;

/**
 * Utilizes an Circular Queue Array data structure.
 * 
 * @author Valor Goff, Kamdon Bird, Jordan Johnson
 * @param <Item>
 */

public class CircularQueue<Item> implements Iterable<Item> {
	private Object[] queue;
	private int cap; // capacity
	private int sizeN; // number of elements in queue
	private int front, rear; // index of front and rear of queue

	CircularQueue(int capacity) {
		if (capacity < 1)
			throw new IllegalArgumentException("Queue size can't be less than 1");
		queue = new Object[capacity];
		cap = capacity;
		sizeN = 0;
		front = -1;
		rear = -1;
	}

	public boolean isFull() {
		return (sizeN == cap);
	}

	public boolean isEmpty() {
		return (sizeN == 0);
	}

	public int size() { // number of elements in queue
		return sizeN;
	}

	public void enqueue(Item item) {
		if (isFull()) {
			System.out.println("Overflow, Queue is full!!");
		} else {
			if (front == -1)
				front = 0;
			rear = (rear + 1) % cap;
			queue[rear] = item;
			sizeN++; // Increment the size after adding an element
		}
	}

	@SuppressWarnings("unchecked")
	public Item dequeue() {
		Item element;
		if (isEmpty()) {
			System.out.println("Underflow, Queue is empty!!");
			return null;
		} else {
			element = (Item) queue[front];

			if (front == rear) { // only where there is one item
				front = -1;
				rear = -1;
			} else {
				front = (front + 1) % cap;
			}
			sizeN--; // Decrement the size after removing an element

			return element;
		}
	}

	@SuppressWarnings("unchecked")
	public Item peek() {
		return (Item) queue[front];
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Item item : this) {
			result.append(item + " ");
		}
		return result.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new CircularQueueIterator();
	}

	private class CircularQueueIterator implements Iterator<Item> {
		private int i = front;
		private int count = 0;

		@Override
		public boolean hasNext() {
			return count < size();
		}

		@SuppressWarnings("unchecked")
		@Override
		public Item next() {
			Item item = (Item) queue[i];
			i = (i + 1) % cap;
			count++;
			return item;
		}
	}

	// = = = = = Test Client = = = = =

	public static void main(String[] args) {
		// Invalid Queue try case test
		System.out.println("= = Creating Invalid Queue...");
		try {
			new CircularQueue<Integer>(-1);
		} catch (Exception e) {
			System.out.println("Something went wrong. " + e.getMessage());
		}

		// Empty queue test
		System.out.println("\n= = Creating Empty Queue (cap 5)...");
		CircularQueue<Integer> queueTest = new CircularQueue<Integer>(5);
		System.out.println("Queue Empty? " + queueTest.isEmpty());

		// Queue size test
		System.out.println("\n= = Testing size..");
		System.out.println("Adding Element 10");
		queueTest.enqueue(10);
		System.out.println("Queue size after element added: " + queueTest.size());

		// Full queue test
		System.out.println("\n= = Check is current queue is full: " + queueTest.isFull());
		System.out.println("= = Check is current queue is empty: " + queueTest.isEmpty());

		// Peak queue test
		System.out.println("\n= = Peek of queue: " + queueTest.peek());

		// Enqueue Items into queue
		System.out.println("\n= = Adding elements to queue... (20)(30)(40)(50)(60)");
		queueTest.enqueue(20);
		queueTest.enqueue(30);
		queueTest.enqueue(40);
		queueTest.enqueue(50);
		// Overflow test
		queueTest.enqueue(60);
		System.out.println("Queue: " + queueTest.toString());
		System.out.println("Check is current queue is full: " + queueTest.isFull());

		// Dequeue Items
		System.out.println("\n= = item dequeued: " + queueTest.dequeue());
		System.out.println("item dequeued: " + queueTest.dequeue());
		System.out.println("Queue: " + queueTest.toString());

		// Circular Test
		System.out.println("\n= = Adding elements to queue... (20)(30)");
		queueTest.enqueue(20);
		queueTest.enqueue(30);
		System.out.println("Queue: " + queueTest.toString());

		// Underflow Test
		System.out.println("\n= = Emptying Queue");
		System.out.println("item dequeued: " + queueTest.dequeue());
		System.out.println("item dequeued: " + queueTest.dequeue());
		System.out.println("item dequeued: " + queueTest.dequeue());
		System.out.println("item dequeued: " + queueTest.dequeue());
		System.out.println("item dequeued: " + queueTest.dequeue());
		System.out.println("item dequeued: " + queueTest.dequeue());
		System.out.println("Queue: " + queueTest.toString());
	}
}