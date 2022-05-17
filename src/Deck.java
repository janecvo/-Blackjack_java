import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
    }

    public Deck(boolean makeFullDeck) {
        deck = new ArrayList<Card>();
        if (makeFullDeck) {
            for (Suit suit : Suit.values()) {
                for (Value value : Value.values()) {
                    deck.add(new Card(suit, value));
                }
            }
        }
    }

    public ArrayList<Card> getCards() {
        return deck;
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    // takes top card from the deck to hand and removes it from the deck
    public Card takeCard() {
        // Take a copy of the first card from the deck
        Card cardToTake = new Card(deck.get(0));
        // Remove the card from the deck
        deck.remove(0);
        // Give the card back
        return cardToTake;
    }

    public String toString() {
        // A string to hold everything we're going to return
        String holding = "";

        // for each Card "card" in the deck
        for (Card card : deck) {
            // add the card and the escape character for a new line
            holding += card;
            holding += "\n";
        }
        return holding;
    }

    public void shuffle() {
        Collections.shuffle(deck, new Random());
    }

    //sees if deck has cards
    public boolean hasCards(){
        if(deck.size()>0){
            return true;
        }else {
            return false;
        }
    }

    //empties out the deck
    public void emptyDeck(){
        deck.clear();
    }

    //adds an arraylist of cards
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

//takes discardDeck and place into play deck shuffled
    public void reloadDeckWithDiscardDeck(Deck discardDeck){
        this.addCards(discardDeck.getCards());
        this.shuffle();
        discardDeck.emptyDeck();
        System.out.println("Out of cards, shuffling discard pile to create new deck.");
    }

    public int cardsLeft(){
        return deck.size();
    }

}

// public void shuffle(){
// ArrayList<Card> shuffle = new ArrayList<Card>();
// //iterate through the deck so each card is pulled
// while(deck.size() > 0){
// //random card pulled = randomized index
// int CardPulled = (int)(Math.random() * deck.size()-1);
// //Add card to shuffled deck
// shuffle.add(deck.get(CardPulled));

// //reove cardPulled from original deck
// deck.remove(CardPulled);
// }
// //playiing deck is now the shuffled deck
// deck = shuffle;
// }
