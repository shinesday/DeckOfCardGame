package deckofcardgame;

public class Main {
    public static void main(String[] args) {
        DeckOfCardGame deck = new DeckOfCardGame();
        deck.welcome();
        deck.initializeDeck();
        deck.shuffle();
        deck.displayDeck(deck.cards);
        int players = deck.numOfPlayers();
        deck.cardDistribution(deck.cards, players);
    }
}