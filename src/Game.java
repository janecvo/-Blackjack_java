import java.util.Scanner;

public class Game {

    private Deck deck, discardDeck;
    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes;

    // Game constructor
    public Game() {

        // creaters new deck of 52 cards
        deck = new Deck(true);
        // Create empty deck for discarded cards
        discardDeck = new Deck();

        // creater People in game
        dealer = new Dealer();
        player = new Player();

        // shuffle deck and start the game
        deck.shuffle();
        startRound();

        //set scores to default
        wins = 0;
        losses = 0;
        pushes = 0;
    }

    // this method will handle how each round happens
    private void startRound() {

        Scanner scanner = new Scanner (System.in);

        System.out.println("How much money is in your account?");
        int playerMoney = Integer.valueOf(scanner.nextLine());
        System.out.println("You have $" +playerMoney+ " in your account." );
        System.out.println(  "Let's play Blackjack! What would you like to bet?");
        int playerBet = Integer.valueOf(scanner.nextLine());


        if (wins > 0  ||  losses > 0 || pushes > 0){
            System.out.println();
            System.out.println("Next round coming up...Where we stand: Wins - " +wins+ ";  Losses - " +losses+ ";  Pushes - " +pushes);
            dealer.getHand().discardHandToDeck(discardDeck);
            player.getHand().discardHandToDeck(discardDeck);
        }

    //check to see if playing deck has enough cards for next round
    if (deck.cardsLeft() <4){
        deck.reloadDeckWithDiscardDeck(discardDeck);
    }

        // two cards to dealer
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        // two cards to player
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        // print hands of each player
        dealer.printFirstHand();
        player.printHand();

        // check for dealer blackjack at beginning
        if (dealer.hasBlackjack()) {
            dealer.printHand();

            // check for player blackjact at beginning
            if (player.hasBlackjack()) {
                System.out.println("Both of you have Blackjack (21) - Push!");
                pushes++;
                startRound();
            } else {
                System.out.println("Dealer has Blackjack(21). You lose! =( ");
                dealer.printHand();
                losses++;
                // Player.playerLoses(playerBet);
                // Player.setPlayerMoney(playerMoney);
                // System.out.println(playerMoney);
                playerMoney -= playerBet;
                System.out.println("Your balance is now $" + playerMoney);
                startRound();
            }
        }

            if (player.hasBlackjack()) {
                System.out.println("You have Blackjack(21). You win! =D ");
                wins++;
                playerMoney += playerBet;
                System.out.println("Your balance is now $" + playerMoney);
                // Player.playerWins(playerBet);
                // Player.setPlayerMoney(playerMoney);
                // System.out.println(playerMoney);
                startRound();
            }

            player.makeDecision(deck, discardDeck);
        
        //check if busted
        if (player.getHand().totalHandValue()>21){
            System.out.println("You are over 21! Busted! You lose!");
            losses++;
            playerMoney -= playerBet;
            System.out.println("Your balance is now $" + playerMoney);
            // Player.playerLoses(playerBet);
            // Player.setPlayerMoney(playerMoney);
            // System.out.println(playerMoney);
            
            startRound();
        }

        dealer.printHand();
        while(dealer.getHand().totalHandValue() <17){ 
            dealer.hit(deck, discardDeck);
        }

        //check who wins
        if(dealer.getHand().totalHandValue( )> 21){
            System.out.println("Dealer busts! You win!");
            wins++;
            playerMoney += playerBet;
            System.out.println("Your balance is now $" + playerMoney);
            
            // Player.playerWins(playerBet);
            // Player.setPlayerMoney(playerMoney);
            // System.out.println(playerMoney);

        }else if(dealer.getHand().totalHandValue() > player.getHand().totalHandValue()){
            System.out.println("You lose!");
            losses++;
            playerMoney -= playerBet;
            System.out.println("Your balance is now $" + playerMoney);
            // Player.playerLoses(playerBet);
            // Player.setPlayerMoney(playerMoney);
            // System.out.println(playerMoney);

        }else if (dealer.getHand().totalHandValue() < player.getHand().totalHandValue()){
            System.out.println("You win!");
            wins++;
            playerMoney += playerBet;
            System.out.println("Your balance is now $" + playerMoney);
            // Player.playerWins(playerBet);
            // Player.setPlayerMoney(playerMoney);
            // System.out.println(playerMoney);
        }else  {
            System.out.println("PUSH!");
            pushes++;
        }
        startRound();
    }
    }
