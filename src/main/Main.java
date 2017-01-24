package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poker.Deck;
import poker.OneHand;
import poker.Player;
import poker.PokerCard;
import poker.Strategy;
import ultility.Log;

import com.google.gson.Gson;


public class Main {
	private static int AceCounter;//how many aces are in the user's hand
	private static int handvalue;//the value of the user's hand
	
	private static final String TAG = "Main";
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Deck deck = new Deck(1);
		deck.shuffle();
		
		//init
		int numberOfPlayers = 1;
		Player dealer = new Player();
		Player [] players = new Player[numberOfPlayers];
		
		for(int i = 0; i < numberOfPlayers; ++i) {
			players[i] = new Player();	
		}
		
		
		//one round
		
		
		/*
		Gson gson = new Gson();
		Log.d(TAG, gson.toJson(deck));		
		*/
		
		
		/*
		AceCounter=0;
		player dealer = new player(deck);
        List<PokerCard> hand = new ArrayList<PokerCard>();
        hand.add(deck.drawCard());
        hand.add(deck.drawCard());
        System.out.println("Here is your hand: ");
        System.out.println("===========================");  
        System.out.println(hand.get(0).getRank());
        System.out.println(hand);
        int handvalue = calcHandValue(hand);
        System.out.println("The dealer is showing: ");
        System.out.println("===========================");  
        dealer.showFirstCard();
        if(hasBlackJack(handvalue) && dealer.hasBlackJack())//check if both the user and dealer have blackjack.
        {
            Push();
        }
        else if(hasBlackJack(handvalue))//check if the user has blackjack.
        {
            System.out.println("You have BlackJack!");
            System.out.println("You win 2x your money back!");
            Win();
        }
        else if(dealer.hasBlackJack())//check if the dealer has blackjack.
        {
            System.out.println("Here is the dealer's hand:");
            dealer.showHand();
            Lose();
        }
        else
        {   
            System.out.println("Would you like to hit or stand?");//ask if the user will hit or stand
            Scanner hitorstand = new Scanner(System.in);
            String hitter = hitorstand.nextLine();
            while(!isHitorStand(hitter))
            {
                System.out.println("Please enter 'hit' or 'stand'.");
                hitter = hitorstand.nextLine();
            }
            while(hitter.equals("hit"))//hits the user as many times as he or she pleases.
            {
                Hit(deck, hand);
                System.out.println("Your hand is now:");
                System.out.println(hand);
                handvalue = calcHandValue(hand);
                if(checkBust(handvalue))//checks if the user busted
                {
                    Lose();
                    break;
                }
                System.out.println("Would you like to hit or stand?");
                hitter = hitorstand.nextLine();
            }
            if(hitter.equals("stand"))//lets the user stand.
            {
                int dealerhand = dealer.takeTurn(deck);//takes the turn for the dealer.
                System.out.println("");
                System.out.println("Here is the dealer's hand:");
                dealer.showHand();
                if(dealerhand>21)//if the dealer busted, user wins.
                {
                    Win();
                }
                else
                {
                    int you = 21-handvalue;//check who is closer to 21 and determine winner
                    int deal = 21-dealerhand;
                    if(you==deal)
                    {
                        Push();
                    }
                    if(you<deal)
                    {
                        Win();
                    }
                    if(deal<you)
                    {
                        Lose();
                    }
                }
            }
        }
        */
	}

	public static void OneRound(Deck deck, Player dealer, Player[] players) {
		int num = players.length;
		if(deck.shouldBeShuffled()) {
			//shuffle the card
			deck.shuffle();
		}
		for(;;) {
			
			//phase 1: 2 cards for each player
			for(int i = 0; i < 2; ++i) {
				for(int j = 0; j < num; ++j) {
					players[j].getOneHand(0).hit(deck.drawCard());
				}
				dealer.getOneHand(0).hit( deck.drawCard());
			}
			//phase 2: check blackjack
			
			//phase 3: strategy starts
			for(int j = 0; j < num; ++j) {
				Player player = players[j];
				int k = player.numberOfHands();
				for(int m = 0; m < k; ++m) {
					OneHand curhand = player.getOneHand(m);
					String stra = Strategy.PlayerStrategy(curhand, dealer.getOneHand(0).firstCard());
					//hit
					if(stra.equals("STAND")) {
						continue;
					} else if (stra.equals("fdafda")) {
						
					} else if (stra.equals("SPLIT")) {
					//if split down
						OneHand another = curhand.split();
						curhand.hit(deck.drawCard());
						another.hit(deck.drawCard());
						//restart the process
						m = 0;
						continue;
					} else {
						
					}
				}
			}
			//
			while(true) {
				OneHand hand = dealer.getOneHand(0);
				String stra = Strategy.DealerStrategy(hand);
				if(stra.equals("HIT")) {
					
				} else if(stra.equals("STAND")) {
					break;
				} else {
					
				}
			}
			
			//phase 4, compare  
			
		}
	}


/*
 * Checks if the user has blackjack.
 */
public static boolean hasBlackJack(int handValue)
{
    if(handValue==21)
    {
        return true;
    }
    return false;
}
/*
 * Calculates the value of a player's hand.
 */
public static int calcHandValue(List<PokerCard> hand)
{
    PokerCard[] aHand = new PokerCard[]{};
    aHand = hand.toArray(aHand);
    int handvalue=0;
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AceCounter++;
        }
        while(AceCounter>0 && handvalue>21)
        {
            handvalue-=10;
            AceCounter--;
        }
    }
    return handvalue;
}
/*
 * Asks the user how much he or she would like to bet.
 */
public static int Bet(int cash)
{
    Scanner sc=new Scanner(System.in);
    int bet=sc.nextInt();
    while(bet>cash)
    {
        System.out.println("You cannot bet more cash than you have!");
        System.out.println("How much would you like to bet?");
        bet=sc.nextInt();
    }
    return bet;
}
/*
 * Called if the user wins.
 */
public static void Win()
{
    System.out.println("Congratulations, you win!");
}
/*
 * Called if the user loses.
 */
public static void Lose()
{
    System.out.println("Sorry, you lose!");
}
/*
 * Called if the user pushes
 */
public static void Push()
{
    System.out.println("It's a push!");
}
/*
 * Adds a card to user's hand and calculates the value of that hand. Aces are taken into account.
 */
public static void Hit(Deck deck, List<PokerCard> hand)
{
    hand.add(deck.drawCard());
    PokerCard[] aHand = new PokerCard[]{};
    aHand = hand.toArray(aHand);
    handvalue = 0;
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AceCounter++;
        }
        while(AceCounter>0 && handvalue>21)
        {
            handvalue-=10;
            AceCounter--;
        }
    }
}
/*
 * Determines if a user has input hit or stand.
 */
public static boolean isHitorStand(String hitter)
{
    if(hitter.equals("hit") || hitter.equals("stand"))
    {
        return true;
    }
    return false;
}
/*
 * Determines if a user has busted.
 */
public static boolean checkBust(int handvalue)
{
    if(handvalue>21)
    {
        System.out.println("You have busted!");
        return true;
    }
    return false;
}
/*
 * Determines if a user has input yes or no.
 */
public static boolean isyesorno(String answer)
{
    if(answer.equals("yes") || answer.equals("no"))
    {
        return true;
    }
    return false;
}
}
		
/*		List<Deck> deck = new LinkedList<Deck>();
		Log.d(TAG, "Before shuffle");
		Gson gson = new Gson();
		for(int i = 0; i < deck.size(); ++i) {
			Deck card = deck.get(i);
			Log.d(TAG, gson.toJson(card));

     }
 */
	

	
	/*	private void Another_shuffle(deck);
		Log.d(TAG, "After shuffle");
		for(int i = 0; i < deck.size(); ++i) {
			PokerCard card = deck.get(i);
			Log.d(TAG, gson.toJson(card));
		}
	*/
	
	//Another shuffle method
/*	private static void Another_shuffle(List<PokerCard> deck) {
		List<PokerCard> Another_deck = new LinkedList<PokerCard>();
		
		
		for(int i = 0; i < 13; ++i) {
			PokerCard card = new PokerCard(i + 1, PokerCard.SPADE);
			Another_deck.add(card);
			
			
		}

		Random rand = new Random();	
		for(int i = 0; i < 13; ++i) {
			int rint = rand.nextInt(13);
			Log.d(TAG, rint);
			int Num = rand.nextInt(Another_deck.size());
			PokerCard change = Another_deck.get(Num);
			deck.set(i, change);
			Another_deck.remove(Num);
	}
  }
*/	

