package deckofcardgame;

/**
 * a class represents a single card, holding its suit and rank
 */
public class Card {

  private String suit;
  private String rank;

  public Card(String suit, String rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public String getSuit() {
    return suit;
  }

  public String getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return rank + " of " + suit;
  }

}
