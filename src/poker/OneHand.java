package poker;

import java.util.List;

public class OneHand {
	
	List<PokerCard> hand_ = null;
	private double bet_ = 0.0;
	
	public OneHand() {
		
	}
	
	
	public PokerCard firstCard() {
		return hand_.get(0);
	}
	
	public List<PokerCard> getCards() {
		return hand_;
	}
	
	public void hit(PokerCard card) {
		
	}
	
	public OneHand split() {
		OneHand anotherhand = new OneHand();
		
		return anotherhand;
	}

	public void DoubleDown() {
		
	}
	
	public boolean isBlackJack() {
		return false;
	}
	
	//the one close to 21
	public int number() {
		int res = 0;
		
		return res;
	}
}
