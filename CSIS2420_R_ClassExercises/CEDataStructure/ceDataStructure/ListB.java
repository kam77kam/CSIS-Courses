package ceDataStructure;

public class ListB {
	private Node head;
	private Node tail;
	private int n; //number of elements in the list
	
	private static class Node{
		private int item;
		private Node next;
		
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int lastItem() {
		if (isEmpty())
			throw new IllegalStateException("Can't access last item of empty list.");
		return tail.item;
	}
	
	public void add(int item) {
		Node newNode = new Node();
		newNode.item = item;
		
		if (isEmpty()) {
			head = newNode;
		}
		else 
			tail.next = newNode;
		
		tail = newNode;
		n++;
	}
	
	// = = = = = = Test Client = = = = = = 
		public static void main(String[] args) {
			System.out.println("List A Test Client");
			System.out.println("------------------");
			
			ListB list = new ListB(5);
			System.out.println("size: " + list.size());
			System.out.println(list);
			System.out.println("The list "
				+(list.isEmpty() ? "is" : "is not") + " empty.");
			System.out.println();
			
			list.add(5);
			System.out.println("size: " + list.size());
			System.out.println(list);
			System.out.println("The list "
					+(list.isEmpty() ? "is" : "is not") + " empty.");
			System.out.println();
			
			list.add(10);
			list.add(15);
			list.add(20);
			list.add(25);
			System.out.println("size: " + list.size());
			System.out.println(list);
			System.out.println("The list "
					+(list.isEmpty() ? "is" : "is not") + " empty.");
			System.out.println();
		}
	
}
