package poker;

import ultility.Log;

public class Strategy {
	
	//enum 
	public static final String H = "HIT"; 
	public static final String D = "DOUBLEDOWN";
	public static final String P = "SPLIT";
 	public static final String S = "STAND";

 	private static String TAG = "Strategy";
	
	/*H=Hit, S=Stand, P =Split, 
	 * D=Double(Hit if not allowed),
	 * DS =Double(Stand if not allowed)
	 */
	

	//column:5-18+
	private static String [][] hard = {
		 //   1   2    3     4   5    6    7   8     9   10
			{"H", "H", "H", "H", "H", "H", "H","H", "H","H"},
			{"H", "H", "H", "H", "H", "H", "H","H", "H","H"},
			{"H", "H", "H", "H", "H", "H", "H","H", "H","H"},
			{"H", "H", "H", "H", "H", "H", "H","H", "H","H"},
			{"H", "H", "D", "D", "D", "D", "H","H", "H","H"},
			{"H", "D", "D", "D", "D", "D", "D","D", "D","H"},
			{"D", "D", "D", "D", "D", "D", "D","D", "D","D"},
			{"H", "H", "H", "S", "S", "S", "H","H", "H","H"},
			{"H", "S", "S", "S", "S", "S", "H","H", "H","H"},
			{"H", "S", "S", "S", "S", "S", "H","H", "H","H"},
			{"H", "S", "S", "S", "S", "S", "H","H", "H","H"},
			{"H", "S", "S", "S", "S", "S", "H","H", "H","H"},
			{"S", "S", "S", "S", "S", "S", "S","S", "S","S"},
			{"S", "S", "S", "S", "S", "S", "S","S", "S","S"},
	};

	//column:(Ace+2)-(Ace+9)
	private static String [][] soft = {
		   //1    2    3     4    5    6    7    8    9    10
			{"H", "H", "H", "H", "D", "D", "H", "H", "H", "H"},
			{"H", "H", "H", "H", "D", "D", "H", "H", "H", "H"},
			{"H", "H", "H", "D", "D", "D", "H", "H", "H", "H"},
			{"H", "H", "H", "D", "D", "D", "H", "H", "H", "H"},
			{"H", "H", "D", "D", "D", "D", "H", "H", "H", "H"},
			{"H", "H", "D", "D", "D", "D", "D", "S", "S", "H"},
			{"S", "S", "S", "S", "S", "D", "S", "S", "S", "S"},
			{"S", "S", "S", "S", "S", "S", "S", "S", "S", "S"},
	};

	//(2,2)-(A,A)
	private static String [][] pairs = {
		   //1    2    3     4    5    6    7    8    9    10
		    {"P", "P", "P", "P", "P", "P", "P", "P", "P", "P"},
			{"H", "P", "P", "P", "P", "P", "P", "H", "H", "H"},
			{"H", "P", "P", "P", "P", "P", "P", "H", "H", "H"},
			{"H", "H", "H", "H", "P", "P", "H", "H", "H", "H"},
			{"H", "D", "D", "D", "D", "D", "D", "D", "D", "H"},
			{"H", "P", "P", "P", "P", "P", "H", "H", "H", "H"},
			{"H", "P", "P", "P", "P", "P", "P", "H", "H", "H"},
			{"P", "P", "P", "P", "P", "P", "P", "P", "P", "P"},
			{"S", "P", "P", "P", "P", "P", "S", "P", "P", "S"},
			{"S", "S", "S", "S", "S", "S", "S", "S", "S", "S"},	
	};
		
	//dealer's strategy
	public String DealerStrategy(OneHand hand) 
	{
		if(hand.softHand())
		{
			if(hand.playerCardValue() < 18)
			{
				return H;
		    }
			
			else   
			{
				return S;
			}	
		}
		else
		{
			if(hand.playerCardValue()<17)
			{
				return H;
		    }
			else   
			{
				return S;
			}	
		}
	}
	
	//player's strategy
	public String PlayerStrategy(OneHand hand, int dealerFirstCard)
	{
		if(hand.isPairs())
		{
			return pairStrategy(hand, dealerFirstCard);
		}
		else if(hand.softHand())
		{
			return softHandStrategy(hand, dealerFirstCard);
		}
		else
		{
			return hardHandStrategy(hand, dealerFirstCard);
		}
	}
	
	public String pairStrategy(OneHand pair, int dealerFirstCard) {
		if(pair.isPairs())
		{
			int playerCard = pair.firstCard().getTTValue() - 1;
			int dealerFirstCardIndex = dealerFirstCard - 1;
			String strategy = pairs[playerCard][dealerFirstCardIndex];
			if (strategy.equals("P"))
			{
			    return P;
			}
			else if (strategy.equals("H"))
			{
				return H;
			}
			else if (strategy.equals("D"))
			{
				return D;
			}
			else if (strategy.equals("S"))
			{
				return S;
			}
			else
			{
				Log.error(TAG, "lack strategy split");
				return null;
			}
		}
		else
		{
			Log.error(TAG, "not a pair");
			return null;
		}
	}
	
	public String softHandStrategy(OneHand softhand, int dealerFirstCard) {
		if(softhand.softHand())
		{
			int playerSumExcpAce = 0;
			playerSumExcpAce = softhand.playerCardValue()-2-11;
			int dealerFirstCardIndex = dealerFirstCard-1;
			if(dealerFirstCardIndex > 9)
			{
				dealerFirstCardIndex = 9;
			}
			String strategy = soft[playerSumExcpAce][dealerFirstCardIndex];
			
			if (strategy.equals("D"))
			{
				return D;
			}
			else if (strategy.equals("H"))
			{
				return H;
			}
			else if (strategy.equals("D"))
			{
				return D;
			}
			else if (strategy.equals("S"))
			{
				return S;
			}
			else
			{
				Log.error(TAG, "lack strategy softhand");
				return null;
			}
		}
		else
		{
			Log.d(TAG, "not soft");
		    return null;
		}
	}
	
	public String hardHandStrategy(OneHand hand, int dealerFirstCard) {
		if(!hand.softHand())
		{
			int playerSumCard = 0;
			if (hand.playerCardValue()<18)
			{
				playerSumCard = hand.playerCardValue()-5;
			}
			else
			{
				playerSumCard = 13;
			}
			int dealerFirstCardIndex = dealerFirstCard-1;
			String strategy = hard[playerSumCard][dealerFirstCardIndex];
			
			if (strategy.equals("H"))
			{
				return H;
			}
			else if (strategy.equals("D"))
			{
				return D;
			}
			else if (strategy.equals("S"))
			{
				return S;
			}
			else
			{
				Log.error(TAG, "lack strategy hard");
				return null;
			}
		}
		else
		{
		return null;
		}
	}
}
