package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
		
		Random rand = new Random();

		for(int i = 0; i < deck.size(); ++i) {
			int rint = rand.nextInt(13);
			Log.d(TAG, rint);
			
			PokerCard card = deck.get(i);
			card.setValue(i - 1);
			
			PokerCard first = deck.get(0);
			PokerCard fifth = deck.get(4);
			deck.set(0, fifth);
			deck.set(4, first);
		}
	}

}
