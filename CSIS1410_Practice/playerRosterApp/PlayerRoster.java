/*Assignment: package playerRosterApp;
Program: PlayerRoster
Created: Apr 10, 2019
Author: Kamdon Bird
*/
package playerRosterApp;

import java.util.Scanner;
import java.util.ArrayList;

public class PlayerRoster {
	static ArrayList<Integer> jerseyList = new ArrayList<Integer>();
	static ArrayList<Integer> ratingList = new ArrayList<Integer>();
	static Scanner input = new Scanner(System.in);
	static String answer = "";
	static int jn;
	static int r;

	public static void main(String[] args) {
		for (int i = 1; i <= 1; i++) {
			System.out.println("Enter player " + i + "'s jersey number:");
			jerseyList.add(input.nextInt());
			System.out.println("Enter player " + i + "'s rating:");
			ratingList.add(input.nextInt());
			System.out.println();
		}
		printRoster();
		printMenu();
	}

	public static void printRoster() {
		// System.out.print("Player ");
		for (int i = 1; i < jerseyList.size() + 1; i++) {
			System.out.print("Player " + i + " -- Jersey number: " + jerseyList.get(i - 1).toString());
			System.out.print(", Rating: " + ratingList.get(i - 1).toString());
			System.out.println();
		}
		System.out.println();
	}

	public static void printMenu() {
		System.out.println("MENU");
		System.out.println("u - Update player rating");
		System.out.println("a - Output players above a rating");
		System.out.println("r - Replace player");
		System.out.println("o - Output roster");
		System.out.println("q - Quit");
		while (answer != "q") {
			if (answer != "q") {
				answer = input.nextLine();
			}
			switch (answer) {
			case "u":
				updateRating();
				break;
			case "a":
				aboveRating();
				break;
			case "c":
				replacePlayer();
				break;
			case "o":
				printRoster();
				break;
			// Exit
			case "q":
				answer = "q";
				break;
			}
		}
	}

	// TODO
	// needs to work
	public static void updateRating() {
		System.out.println("Enter a jersey Number:");
		jn = input.nextInt();
		if (true == jerseyList.contains(jn)) {
			int temp = jerseyList.indexOf(jn);
			System.out.println("Enter a new rating for player:");
			jn = input.nextInt();
			jerseyList.remove(temp);
			jerseyList.add(temp, jn);
			System.out.println(jerseyList.get(temp).toString());
			printMenu();
		}
	}

	public static void aboveRating() {
		System.out.println("Enter a rating:");
		r = input.nextInt();
		if (true == ratingList.contains(r)) {
			int temp = ratingList.indexOf(r);
			System.out.println("Player 1 -- Jersey number: " + ratingList.get(temp));
		}
	}

	public static void replacePlayer() {

	}
}
