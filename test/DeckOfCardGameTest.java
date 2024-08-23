import static org.junit.Assert.*;

import deckofcardgame.Card;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import deckofcardgame.DeckOfCardGame;
import org.junit.Before;

public class DeckOfCardGameTest {

  private DeckOfCardGame deck;

  @Before
  public void setUp() {
    deck = new DeckOfCardGame();
    deck.initializeDeck();
  }

  @org.junit.Test
  public void initializeDeck() {
    assertEquals("Deck should have 52 cards after initialization.", 52, deck.cards.size());
  }

  @org.junit.Test
  public void displayDeck() {
    deck.displayDeck(deck.cards);
  }

  @org.junit.Test
  public void shuffle() {
    ArrayList<Card> originalDeck = new ArrayList<>(deck.cards);
    deck.shuffle();
    assertNotEquals("Shuffling should change the order of cards.", originalDeck, deck.cards);
  }

  @org.junit.Test
  public void numOfPlayers() {
    String input = "3\n"; // Simulate user input of "3"
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    int players = deck.numOfPlayers();
    assertEquals("Player count should be 3.", 3, players);

  }

  @org.junit.Test
  public void cardDistribution() {
    int playerCount = 3;
    deck.cardDistribution(deck.cards, playerCount);

    // Check that the correct number of cards have been dealt to players
    int expectedCardsDealt = playerCount * 9;
    assertTrue("There should be enough cards remaining after distribution.",
        deck.cards.size() == 52 - expectedCardsDealt);
  }

  @org.junit.Test
  public void dealCard() {
    Card dealtCard = deck.dealCard();
    assertNotNull("Dealt card should not be null if the deck is not empty.", dealtCard);
    assertEquals("Deck should have one less card after dealing.", 51, deck.cards.size());

    // Test dealing from an empty deck
    while (deck.dealCard() != null) {} // Empty the deck
    dealtCard = deck.dealCard();
    assertNull("Dealt card should be null if the deck is empty.", dealtCard);
  }

  @org.junit.Test
  public void resetDeck() {
    // Implementing a reset method for the deck
    deck.dealCard();  // Deal one card
    deck.initializeDeck(); // Reinitialize the deck
    assertEquals("Deck should be reset to 52 cards.", 52, deck.cards.size());
  }

}