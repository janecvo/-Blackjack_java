public class Card {

    // variables for Card
    private Suit suit;
    private Value value;

    // create a constructor of card with a suit and value
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Card(Card card){
        this.suit = card.getSuit();
        this.value = card.getValueName();
    }

    // get value of card (numeric)
    public int getValue() {
        return value.value;
    }

    // return value of card
    public Suit getSuit() {
        return suit;
    }

    // return value (name) of card
    public Value getValueName() {
        return value;
    }

    public String toString(){
        return ("["+value+" of "+ suit + "] ("+this.getValue()+")");
    }

}
