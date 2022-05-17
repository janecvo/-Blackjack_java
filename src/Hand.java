import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }

    public int totalHandValue(){
        //variables - total and number of Aces
        int value = 0;
        int numOfAces = 0;

        //for each hard in this hand
        for(Card card: hand){
            //total cards in the hand
            value += card.getValue();
            //Count the number of aces
            if (card.getValue() == 11){
                numOfAces ++;
            }
        }
        if (value > 21 && numOfAces >0){
            while (numOfAces > 0 && value > 21){
                numOfAces --;
                value -=10;
            }
        }
        return value;
    }

    public Card getCard(int index){
        return hand.get(index);
    }

    public void discardHandToDeck(Deck discardDeck){
        //copy cards in hand to discardDeck
        discardDeck.addCards(hand);

        //clear cards from hand
        hand.clear();
    }

    public String toString(){
        String holding = "";
        for (Card card: hand){
            holding+= card + " - ";
        }
        return holding;
    }

}
