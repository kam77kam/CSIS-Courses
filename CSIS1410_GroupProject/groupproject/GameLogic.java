/**
 * Assignment: A10
 * Program: GameLogic
 * Created: Apr 20, 2019
 * @author Zachary Funk
 *
 * Notes:
 *
 *
 **/



package groupproject;

import java.util.ArrayList;
import groupproject.Deck.DECK;

/**
 * @author Zachary Funk
 * @author Kamdon Bird
 *
 * @param <DeckCard> the card you are passing
 */
public class GameLogic <DeckCard> {
	//fields
	private ArrayList<DeckCard> deck = new ArrayList<DeckCard>();
	private ArrayList<DeckCard> playerHand = new ArrayList<DeckCard>();
	private ArrayList<DeckCard> dealerHand = new ArrayList<DeckCard>();
	private int playerScore = 0;
	private int dealerScore = 0;
	private int totCards = 51;
	//Constr
	/**
	 * Used only to instantiate the class
	 */
	public GameLogic() {
	}
	//Methods
	/**
	 * Draw will pick a random card and add it to a hand and will remove that card from the deck
	 * @param list the hand that the card is being added to.
	 */
	public void draw(ArrayList<DeckCard> list) {
		int card = Deck.rand.nextInt(totCards);	//Selects a random card from the remaining cards
		totCards--;								//removes that card from the total cards
		list.add(deck.get(card));				//adds that card to what ever hand assigned
		deck.remove(deck.get(card));			//removes that card from the whole deck to prevent dupilicates
	}
	/**
	 * At the end of a round the all hands are cleared and the deck is shuffled
	 * the cards for all players are drawn.
	 */
	public void newRound() {
		//Resets the deck and the total cards
		totCards = 51;
		deck.clear();
		playerHand.clear();
		dealerHand.clear();
		Deck.getDeck().clear();
		Deck.createDeck();
		Deck.shuffleDeck();
		
		//Shuffles the deck and gets it for use
		Deck.shuffleDeck();
		deck = Deck.getDeck();

		draw(playerHand);
		draw(dealerHand);
		draw(playerHand);
		draw(dealerHand);
	}
	/**
	 * @return false if the player would bust
	 */
	public boolean pOver21() {
		int pBust = curPoints(playerHand);	//Retrieves the total points for player
		//if over 21 bust
		if(pBust > 21) {
			return false;
		}
		return true;
	}
	/**
	 * @return false if the dealer would bust
	 */
	public boolean dOver21() {
		int dBust = curPoints(dealerHand);//Retrieves the total points for dealer
		//if over 21 bust		
		if(dBust > 21) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @return the deck
	 */
	public ArrayList<DeckCard> getDeck() {
		return deck;
	}
	/**
	 * @return the playerHand
	 */
	public ArrayList<DeckCard> getPlayerHand() {
		return playerHand;
	}
	/**
	 * @return the dealerHand
	 */
	public ArrayList<DeckCard> getDealerHand() {
		return dealerHand;
	}
	/**
	 * @return the playerScore
	 */
	public int getPlayerScore() {
		return playerScore;
	}
	/**
	 * @return the dealerScore
	 */
	public int getDealerScore() {
		return dealerScore;
	}
	/**
	 * @return the totCards
	 */
	public int getTotCards() {
		return totCards;
	}
	/**
	 * @param list the hand you are selecting from
	 * @return the total current points
	 */
	public int curPoints(ArrayList<DeckCard> list) {
		int out = 0;

		//Ignores all aces they are handled later
		for (DeckCard deckCard : list) {
			DECK myCard = (DECK) deckCard;
			int card = (myCard.ordinal() % 13)+1;
			
			
			if (card + 1 > 10) {
				card = 10;
			}
			out += card;
		}

		//checks for ace and adds the needed points
		for (DeckCard deckCard : list) {
			if (0 == (((DECK) deckCard).ordinal()) % 13 ) {
				out -= 1;
				int temp = out + 11;
				if (temp > 21) {
					out += 1;
				} 
				else {
					out += 11;
				}
			}
		}	
		return out;
	}






	//Testing Methods -- For testing purposes not used in final product
	@SuppressWarnings("javadoc")
	public void printDeck() {
		for (DeckCard deckCard : deck) {
			System.out.println(deckCard);
		}
	}

	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		GameLogic myGame = new GameLogic();
		myGame.newRound();
		DECK myObject = (DECK) myGame.dealerHand.get(0);

		int something = myObject.ordinal();
		System.out.println(myObject);
		System.out.println(something);
		System.out.println((something % 13)+1);
		System.out.println();
		
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < myGame.playerHand.size(); i++) {
				System.out.println(myGame.playerHand.get(i));
			}
			
			System.out.println(myGame.curPoints(myGame.playerHand));
			myGame.newRound();
			System.out.println();
		}
		//		myGame.printDeck();
	}
}
