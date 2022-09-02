/*  Assignment: GroupProjectgroupproject
 	Program: GroupProject
	Created: Apr 10, 2019
	Author: Melissa Clark
 */
package groupproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Melissa Clark
 * The class for handling all of the deck logic
 */
public class Deck {

	private static ArrayList<DECK> deck = new ArrayList<DECK>(); //creating a hashmap so we can find out cards with the number,
	//the value (Integer) will be the same as the location in the Enum
	/**
	 * the random value to be used throughout the program
	 */
	public static Random rand = new Random();
	
	/**
	 * @author Melissa Clark
	 * The enum for the deck.
	 */
	public static enum DECK {SPADE_ACE, SPADE_2, SPADE_3, SPADE_4, SPADE_5, SPADE_6, SPADE_7, SPADE_8, SPADE_9, SPADE_10, SPADE_JACK, 
		SPADE_QUEEN, SPADE_KING, DIAMOND_ACE, DIAMOND_2, DIAMOND_3, DIAMOND_4, DIAMOND_5, DIAMOND_6, DIAMOND_7, DIAMOND_8, 
		DIAMOND_9, DIAMOND_10, DIAMOND_JACK, DIAMOND_QUEEN, DIAMOND_KING, HEART_ACE, HEART_2, HEART_3, HEART_4, HEART_5, 
		HEART_6, HEART_7, HEART_8, HEART_9, HEART_10, HEART_JACK, HEART_QUEEN, HEART_KING, CLUB_ACE, CLUB_2, CLUB_3, CLUB_4,
		CLUB_5, CLUB_6, CLUB_7, CLUB_8, CLUB_9, CLUB_10, CLUB_JACK, CLUB_QUEEN, CLUB_KING}

	/**
	 * This initializes the deck, the deck is sorted 
	 * Spade, Diamond, Heart, and club, in ascending order
	 */
	public static void createDeck() {
		deck.add(DECK.SPADE_ACE);
		deck.add(DECK.SPADE_2);
		deck.add(DECK.SPADE_3);
		deck.add(DECK.SPADE_4);
		deck.add(DECK.SPADE_5);
		deck.add(DECK.SPADE_6);
		deck.add(DECK.SPADE_7);
		deck.add(DECK.SPADE_8);
		deck.add(DECK.SPADE_9);
		deck.add(DECK.SPADE_10);
		deck.add(DECK.SPADE_JACK);
		deck.add(DECK.SPADE_QUEEN);
		deck.add(DECK.SPADE_KING);
		deck.add(DECK.DIAMOND_ACE);
		deck.add(DECK.DIAMOND_2);
		deck.add(DECK.DIAMOND_3);
		deck.add(DECK.DIAMOND_4);
		deck.add(DECK.DIAMOND_5);
		deck.add(DECK.DIAMOND_6);
		deck.add(DECK.DIAMOND_7);
		deck.add(DECK.DIAMOND_8);
		deck.add(DECK.DIAMOND_9);
		deck.add(DECK.DIAMOND_10);
		deck.add(DECK.DIAMOND_JACK);
		deck.add(DECK.DIAMOND_QUEEN);
		deck.add(DECK.DIAMOND_KING);
		deck.add(DECK.HEART_ACE);
		deck.add(DECK.HEART_2);
		deck.add(DECK.HEART_3);
		deck.add(DECK.HEART_4);
		deck.add(DECK.HEART_5);
		deck.add(DECK.HEART_6);
		deck.add(DECK.HEART_7);
		deck.add(DECK.HEART_8);
		deck.add(DECK.HEART_9);
		deck.add(DECK.HEART_10);
		deck.add(DECK.HEART_JACK);
		deck.add(DECK.HEART_QUEEN);
		deck.add(DECK.HEART_KING);
		deck.add(DECK.CLUB_ACE);
		deck.add(DECK.CLUB_2);    
		deck.add(DECK.CLUB_3);
		deck.add(DECK.CLUB_4);
		deck.add(DECK.CLUB_5);
		deck.add(DECK.CLUB_6);
		deck.add(DECK.CLUB_7);
		deck.add(DECK.CLUB_8);
		deck.add(DECK.CLUB_9);
		deck.add(DECK.CLUB_10);
		deck.add(DECK.CLUB_JACK);
		deck.add(DECK.CLUB_QUEEN);
		deck.add(DECK.CLUB_KING);
	}
	/**
	 * This randomly shuffles the deck
	 */
	public static void shuffleDeck() {
		Collections.shuffle(deck);
	}

	/**
	 * This prints the deck in order
	 */
	public static void printDeck() {
		for (int i = 0; i < deck.size(); i++) {
			System.out.println(i);
		}
		System.out.println();
	}

	/**
	 * @return the deck for game
	 */
	public static ArrayList getDeck() {
		return deck;
	}
	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		System.out.println(DECK.values().length);
		System.out.println(DECK.CLUB_9.ordinal());
		System.out.println(DECK.CLUB_10.ordinal());
		System.out.println();
		
		createDeck();
		System.out.println(deck.get(0));
		shuffleDeck();
		System.out.println(deck.get(0));
		
//		createDeck();
//		printDeck();
//		shuffleDeck();
//		printDeck();
	}
}
