public enum Suit {
    CLUB ("Clubs"),
    DIAMOND("Diamonds"),
    HEART ("Hearts"),
    SPADE ("Spades");

    String suitName;

    //constructor of Suit
    Suit(String suitName){
        this.suitName = suitName;
    }

    //toString to print out
    public String toString(){
        return suitName;
    }
}
