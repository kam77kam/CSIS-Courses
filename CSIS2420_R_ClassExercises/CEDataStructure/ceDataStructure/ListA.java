package ceDataStructure;

import java.util.Arrays;

public class ListA {
	private int items[];
	private int n; //number of elements in the list
	
	public ListA (int capacity) {
		items = new int[capacity];
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return n ==0;
	}
	
	public void add(int newitem) {
		if (n == items.length) //list is full
			throw new IllegalStateException("Can't add to a full list.");
		items[n++] = newitem;
	}
	
	@Override
	public String toString() {
		return "ListA [items=" + Arrays.toString(items) + ", n=" + n + "]";
	}
	
	// = = = = = = Test Client = = = = = = 
	public static void main(String[] args) {
		System.out.println("List A Test Client");
		System.out.println("------------------");
		
		ListA list = new ListA(5);
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
