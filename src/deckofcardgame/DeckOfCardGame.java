package deckofcardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DeckOfCardGame {

	public static final Scanner scanner = new Scanner(System.in);
	public ArrayList<Card> cards;

	/**
	 * print welcome msg
	 */
	public void welcome() {
		 System.out.println("Welcome to the Card Game");
	}

	/**
	 * initial and display the deck
	 */
	public void initializeDeck() {
		this.cards = new ArrayList<>();
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		int numOfCards = suits.length * ranks.length;
		System.out.println("\nNumber of cards in the deck:" + numOfCards);

		for (String suit : suits) {
			for (String rank : ranks) {
				cards.add(new Card(suit, rank));
			}
		}
		displayDeck(cards);
	}

	/**
	 * display the deck
	 * @param cardsDeck cards in deck
	 */
	public void displayDeck(ArrayList<Card> cardsDeck) {
		System.out.println("\nCards in Deck:");
		for (Card element : cardsDeck) {
			System.out.println(element);
		}
		System.out.println();
	}

	/**
	 * shuffle the cards
	 */
	public void shuffle() {
		Collections.shuffle(cards);
		System.out.println("Deck shuffled.");
	}

	/**
	 * get number of players
	 */
	public int numOfPlayers() {
		Scanner scanner = new Scanner(System.in);
		int player;
		while (true) {
			System.out.print("\nEnter number of players (minimum 2, maximum 4): ");
			player = scanner.nextInt();
			if (player >= 2 && player <= 4) {
				System.out.println("\n" + player + " players will play the game");
				break;
			} else {
				System.out.println("Please enter a number of players within the range.");
			}
		}
		scanner.close();
		return player;
	}

	/**
	 * distribute the cards to all players
	 * @param cardsDeck cards in deck
	 * @param player number of players
	 */
	public void cardDistribution(ArrayList<Card> cardsDeck, int player) {
		int cardsPerPlayer = 9;
		int totalCardsNeeded = player * cardsPerPlayer;

		if (cardsDeck.size() < totalCardsNeeded) {
			System.out.println("Not enough cards to distribute.");
			return;
		}

		for (int i = 0; i < player; i++) {
			System.out.print("\nPlayer " + (i + 1) + " got cards:\n");
			for (int j = 0; j < 9; j++) {
				Card dealtCard = cardsDeck.remove(0);  // Remove and get the first card
				System.out.print("\t" + dealtCard);
			}
		}
	}

	/**
	 * deal a card
	 * @return the removed card(the last card in the cards list)
	 */
	public Card dealCard() {
		if (cards.isEmpty()) {
			System.out.println("Out of cards.");
			return null;
		}
		return cards.remove(cards.size() - 1);
	}

	/**
	 * reset the deck
	 */
	public void resetDeck() {
		cards.clear();
		initializeDeck();
		shuffle();
	}

}