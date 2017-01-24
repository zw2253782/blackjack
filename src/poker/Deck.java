package poker;

import java.util.ArrayList;
import java.util.Random;

import ultility.Log;

public class Deck {

	//change to LinkedList
	//  [1, 2, 3]
	// remove(0) [2, 3]
	//linkedList [2] [3]
	private ArrayList<PokerCard> deck;//represents a deck of cards
	private int shuffle_point_ = 0;
	
	//change to number of decks
	public Deck(int num)    
	{
		deck = new ArrayList<PokerCard>();
		for(int i=0; i<4; i++) 
		{
	        for(int j=1; j<=13; j++) 
	           {
	               deck.add(new PokerCard(i,j));
	               //Log.d(i, j);
	           }
	       }
	    shuffle_point_ = 20;
	   }

	//change to one time shuffle
	   public void shuffle() {
		
		   Random rand = new Random();
		 for(int i=0; i<500; i++) 
	       {
			 int index1 = rand.nextInt(deck.size()-1);
		     int index2 = rand.nextInt(deck.size()-1);
		     PokerCard temp = deck.get(index2);
		     deck.set(index2, deck.get(index1));
		     deck.set(index1, temp);
		     
	       }

	  }	

		
	/*
	 * Draws a card from the deck.
	 */
	public PokerCard drawCard()
	{
		//judge how many cards left, 
	    return deck.remove(0);
	}
	
	//check if the deck is need to be shuffled
	
	public boolean shouldBeShuffled() {
		return false;
	}
}
   
  
