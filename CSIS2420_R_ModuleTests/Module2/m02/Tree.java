package m02;

/**
 * Represents a tree that is defined by its name and mature height.
 * 
 * @author CSIS Starter Code + ...............  ( TODO replace the dots with your name )
 */
public class Tree implements Comparable<Tree> {
	private String name;
	private int height; // mature height of the tree
	
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
	
}

