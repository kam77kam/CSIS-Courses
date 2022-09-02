/**
 * Assignment: A01
 * Program: Menu
 * @author Zach Funk
 * @author Kamdon Bird
*/

package a01;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;

/**
 * @author Kamdon Bird
 * @author Zachary Funk
 */
public class Menu {
	
	/**
	 * The ArrayList that is used to contain all of the bike created
	 */
	public static ArrayList<DirtBike> items = new ArrayList<>();
	/**
	 * Scanner for user input
	 */
	private static Scanner input = new Scanner(System.in);
	/**
	 * The players choice within the menu
	 */
	private static String choice;
	
	/**
	 * the main method
	 * @param args not used
	 * @author Zachary Funk
	 * @author Kamdon Bird
	 */
	public static void main(String[] args) {
		//creating the premade bikes
		DirtBike d1 = new DirtBike(2004, "Honda", "CRF", 450);
		items.add(d1);
		DirtBike d2 = new DirtBike(2012, "Yamaha", "WR", 450);
		items.add(d2);
		DirtBike d3 = new DirtBike(2009, "KTM", "SX", 125);
		items.add(d3);
		DirtBike d4 = new DirtBike(2018, "Yamaha", "YZ", 250);
		items.add(d4);
		DirtBike d5 = new DirtBike(2016, "Honda", "Grom", 125);
		items.add(d5);
		DirtBike d6 = new DirtBike(2003, "KTM", "SXF", 350);
		items.add(d6);
		

		//loop for the menu allows you to manipulate the bikes
		while(choice != "6") {
			if(choice != "6") {
				System.out.println("1. Display all items");
				System.out.println("2. Add an item");
				System.out.println("3. Find an item");
				System.out.println("4. Delete an item");
				System.out.println("5. Numbers of items in list");
				System.out.println("6. Exit");
				System.out.print("Enter your selection: ");
				choice = input.nextLine();
			}
			switch(choice){
				//prints out all bikes within items
				case "1":
					printList();
					break;
				//creates a new bike
				case "2":
					createBike();
					break;
				//Find an item
				case "3":
					findItem();
					break;
				//Delete item
				case "4":	
					deleteItem();
					break;
				//Number of items within list
				case "5":
					System.out.println("\nNumber of bikes: "+ DirtBike.getBikeCount());
					break;
				//Exit
				case "6":
					System.out.println();
					System.out.print("Good bye");
					choice = "6";
					break;
				default:
					System.out.println("\nEnter a selection 1 - 6");
			}
			System.out.println("");
		}
	}

	/**
	 * Creates a bike
	 * @author Zachary Funk
	 */
	private static void createBike() {
		System.out.println();
		System.out.print("Enter year of dirtbike: ");
		int year = input.nextInt();
		System.out.print("Enter make of dirtbike: ");
		input.nextLine();
		String make = input.nextLine();					
		System.out.print("Enter model of dirtbike: ");
		String model = input.nextLine();
		//input.next();
		System.out.print("Enter CC of dirtbike: ");
		int cc = input.nextInt();
		DirtBike knew = new DirtBike(year, make, model, cc);
		items.add(knew);
		input.nextLine();
	}
	/**
	 * Prints out complete list of items
	 * @author Zachary Funk
	 */
	private static void printList() {
		System.out.println();
		for(DirtBike d : items) {
			System.out.print(d);
		}
		
	}
	/**
	 * Finds a bike when provided the id
	 * @author Zachary Funk
	 */
	private static void findItem() {
		System.out.println();
		System.out.print("ID: ");
		int id = input.nextInt();
		int realID = DirtBike.getBikeId(id);
		if(realID == -1) {
			System.out.printf("The id %s could not be found%n", id);
		}
		else {
			System.out.print(items.get(realID));
		}
		input.nextLine();
	}
	/**
	 * Deletes a bike from items
	 * @author Zachary Funk
	 */
	private static void deleteItem() {
		StringBuilder removeID = new StringBuilder();
		System.out.print("\nID: ");
		int id = input.nextInt();
		int realID = DirtBike.getBikeId(id);

		if(realID == -1) {
			System.out.printf("The id %s couldnot be found%n", id);
		}
		else {
			removeID.append(items.get(realID));
			removeID.replace(removeID.length()-13, removeID.length(), "has been deleted.");
			System.out.println(removeID);
			items.remove(realID);
			DirtBike.findId.remove(realID);
			DirtBike.setBikeCount(DirtBike.getBikeCount() - 1);
		}
		input.nextLine();
	}
}
