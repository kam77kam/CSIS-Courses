package m01;

/**
 * Singly-linked list to demonstrate your understanding of linked structures.
 * 
 * @author starter code + Kamdon Bird
 */
public class CharacterList {
	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null
	private int n; // number of items in the list

	/**
	 * Node of LinkedList that stores the item and a single reference to the next
	 * node.
	 */
	private class Node {
		private Character item;
		private Node next;
	}

	/**
	 * Adds a node containing the item at the end of the list.
	 * 
	 * @param item
	 */
	public void add(final Character item) {
		Node node = new Node();
		node.item = item;

		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		n++;
	}

	/**
	 * Determines whether the first element of the list is an opening bracket '['
	 * and the last element is a closing bracket ']', and returns true if that is
	 * the case. Calling hasBracketDelimiters doesn't change this list.
	 * <p>
	 * Examples: <br/>
	 * If the list includes [ H i ] the method returns true <br/>
	 * If the list includes [ ] the method returns true <br/>
	 * If the list includes [ ] [ [ ] the method returns true <br/>
	 * If the list includes a [ b ] c the method returns false <br/>
	 * If the list includes [ 1 2 ] 3 the method returns false <br/>
	 * If the list includes M 3 the method returns false <br/>
	 * If the list includes ] the method returns false <br/>
	 * If the list is empty the method returns false <br/>
	 * 
	 * @return true if the first element is '[' and the last element is ']' and
	 *         false otherwise.
	 */
	public boolean hasBracketDelimiters() {
		if (isEmpty() || head.item == null || tail.item == null) {
			return false;
		} else if (head.item == '[' && tail.item == ']')
			return true;
		else
			return false;

	}

	/**
	 * Identifies all characters in the list that are lower-case letters, duplicates
	 * them, and returns them as a String as described in the examples below. If the
	 * list includes no lower-case letters, an empty String is returned.<br/>
	 * Calling duplicateLowerCase doesn't change this list.
	 * <p>
	 * Examples: <br/>
	 * If the list includes a b c the method returns "aabbcc" <br/>
	 * If the list includes G o o d _ L U C K ! the method returns "oooodd" <br/>
	 * If the list includes 4 x 3 the method returns "xx" <br/>
	 * If the list includes z the method returns "zz" <br/>
	 * If the list includes A - 1 2 the method returns an empty String <br/>
	 * If the list is empty the method returns an empty String <br/>
	 * 
	 * @return duplicated lower-case letters
	 */
	public String duplicateLowerCase() {
		if(isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while(current != null) {
			String s = Character.toString(current.item);
			if(s.isEmpty() == false && s == s.toLowerCase()) {
				sb.append(s); sb.append(s);
			}
			current = current.next;
		}
		return sb.toString();
	}

	/**
	 * Returns the number of elements in the list
	 * 
	 * @return the number of elements
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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		Node current = head;

		while (current != null) {
			sb.append(current.item).append(" ");
			current = current.next;
		}

		return sb.toString();
	}

	/* = = = = = = = = = Test Client = = = = = = = = = */

	// The main method provides a starter code to help you get started with your own
	// testing.
	// If you prefer to write JUnit tests to test your code, that's fine, too.

	public static void main(String[] args) {

		
		System.out.println("Testing hasBracketDelimiters()");
		System.out.println("------------------------------");
		System.out.println();
		System.out.println("Creating new list with no brackets");
		System.out.println("Adding 'a' 'b' 'c' to linkedlist...");
		CharacterList list = new CharacterList();
		list.add('a');
		list.add('b');
		list.add('c');
		System.out.println("Result: " + list.hasBracketDelimiters());
		System.out.println();
		System.out.println("Creating new list with both brackets");
		System.out.println("Adding '[' 'b' ']' to linkedlist...");
		CharacterList list1 = new CharacterList();
		list1.add('[');
		list1.add('b');
		list1.add(']');
		System.out.println("Result: " + list1.hasBracketDelimiters());
		System.out.println();
		System.out.println("Creating new list with only 1 bracket");
		System.out.println("Adding 'a' 'b' ']' to linkedlist...");
		CharacterList list2 = new CharacterList();
		list2.add('a');
		list2.add('b');
		list2.add(']');
		System.out.println("Result: " + list2.hasBracketDelimiters());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Testing duplicateLowerCase()");
		System.out.println("----------------------------");
		System.out.println();
		System.out.println("Creating new list with lower-cases only");
		System.out.println("Adding 'a' 'b' 'c' to linkedlist...");
		CharacterList list3 = new CharacterList();
		list3.add('a');
		list3.add('b');
		list3.add('c');
		System.out.println("Result: " + list3.duplicateLowerCase());
		System.out.println();
		System.out.println("Creating new list with upper-cases only");
		System.out.println("Adding 'A' 'B' 'C' to linkedlist...");
		CharacterList list4 = new CharacterList();
		list4.add('A');
		list4.add('B');
		list4.add('C');
		System.out.println("Result: " + list4.duplicateLowerCase());
		System.out.println();
		System.out.println("Creating new list with random upper & lower-cases");
		System.out.println("Adding 'A' 'b' 'C' 'd' to linkedlist...");
		CharacterList list5 = new CharacterList();
		list5.add('A');
		list5.add('b');
		list5.add('C');
		list5.add('d');
		System.out.print("Result: " + list5.duplicateLowerCase());
		System.out.println();
	}

}
