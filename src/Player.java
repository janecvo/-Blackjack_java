import java.util.Scanner;

public class Player extends Person {

    // static int playerMoney;
    Scanner scanner = new Scanner(System.in);


    //Create new Player
    public Player(){
        super.setName("Player");
    
    }

// public static int playerMoney(){
//     Scanner scanner = new Scanner(System.in);
//     System.out.println("How much money would you like to add to your account?");
//     int playerMoney = Integer.valueOf(scanner.nextLine());
//     return playerMoney;
// }

    // public static void playerLoses(int playerBet){
    //     playerMoney -= playerBet;
    // }

    // public static void playerWins(int playerBet){
    //     playerMoney += (2*playerBet);
    // }

    // public static void setPlayerMoney(int playerMoney) {
    //     Player.playerMoney = playerMoney;
    // }

    // public static int getPlayerMoney(){
    //     return playerMoney;
    // }


    // public void printOut(){
    //     System.out.println("Player currently has $" +playerMoney+ "left." );
    // }

    public void makeDecision(Deck deck, Deck discardDeck){
        int playerDecision = 0;
        boolean getDecision = true;

        while(getDecision){

            try{
                System.out.println("What would you like to do : \n 1- Hit or \n 2-Stand");
                playerDecision = Integer.valueOf(scanner.nextLine());
                getDecision = false;
            }
            catch(Exception e){
                System.out.println("Invalid");
                scanner.next();
            }
        }
        //lets hit
        if (playerDecision == 1){
            this.hit(deck, discardDeck);
        if(this.getHand().totalHandValue()>20){
            return;
        }else{
            this.makeDecision(deck, discardDeck);
        }
        }else {
            System.out.println("You stand.");
        }


        System.out.println("You selected: " +playerDecision);
    }
}



