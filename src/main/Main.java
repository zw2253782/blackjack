package main;

import java.util.LinkedList;
import java.util.List;

import poker.PokerCard;
import ultility.Log;

import com.google.gson.Gson;

public class Main {
	private static String TAG = "Main";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<PokerCard> deck = new LinkedList<PokerCard>();
		for(int i = 0; i < 13; ++i) {
			PokerCard card = new PokerCard(i + 1, PokerCard.SPADE);
			deck.add(card);
		}
		
		Log.d(TAG, "Before shuffle");
		Gson gson = new Gson();
		for(int i = 0; i < deck.size(); ++i) {
			PokerCard card = deck.get(i);
			Log.d(TAG, gson.toJson(card));
		}
		shuffle(deck);
		Log.d(TAG, "After shuffle");
		for(int i = 0; i < deck.size(); ++i) {
			PokerCard card = deck.get(i);
			Log.d(TAG, gson.toJson(card));
		}
	}
	
	private static void shuffle(List<PokerCard> deck) {
		for(int i = 0; i < deck.size(); ++i) {
			PokerCard card = deck.get(i);
			card.setValue(i - 1);
		}
	}

}
