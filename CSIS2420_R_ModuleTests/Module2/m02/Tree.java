package m02;

import java.util.Comparator;

/**
 * Represents a tree that is defined by its name and mature height.
 * 
 * @author CSIS Starter Code + Kamdon Bird
 */
public class Tree implements Comparable<Tree> {
	private String name;
	private int height; // mature height of the tree
	
	public static final Comparator<Tree> BY_HEIGHT = new Friend();
	
	public Tree(String name, int age) {
		this.name = name;
		this.height = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return height;
	}
	
	@Override
	public String toString() {
		return name + ":" + height;
	}

	@Override
	public int compareTo(Tree other) {
		return this.name.compareTo(other.name);
	}
	/*
	 * Represents trees that is defined by its mature height
	 */
	private static class Friend implements Comparator<Tree> {

		@Override
		public int compare(Tree t1, Tree t2) {
			if(t1.height == t2.height) {
				return 0;
			}else if(t1.height > t2.height) {
				return 1;
			}else return -1;
		}
		
	}
}

