public class Dealer extends Person{
    //create new Dealer
    public Dealer(){
        super.setName("Dealer");
    }

    //prints dealer's hand with one card hidden
    public void printFirstHand(){
        System.out.println("The dealer's hand: ");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down.");
    }

}
