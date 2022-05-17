public class Person {
    private Hand hand;
    private String name;

    //constructor of person
    public Person(){
        this.hand = new Hand();
        this.name = "";
    }

    public Hand getHand(){
        return this.hand;
    }

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean hasBlackjack(){
        if (this.getHand().totalHandValue() == 21){
            return true;
        }else{
            return false;
        }
    }

    public void hit(Deck deck, Deck discardDeck){
        //no cards left in the deck
        if (!deck.hasCards()){
            deck.reloadDeckWithDiscardDeck(discardDeck);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        this.printHand();

    }

    public void printHand(){
        System.out.println(this.name+ "'s hand looks like this: ");
        System.out.println(this.hand + " Valued at:  " + this.hand.totalHandValue());
    }

}
