package poker;

public class PokerCard {
	
	private int index_ = 0;
	private int value_ = 0;
	private String color_ = "";
	
	public static String SPADE = "spade";
	public static String HEART = "heart";
	public static String DIAMOND = "diamond";
	public static String CLUB = "club";
	
	public PokerCard() {
		
	}
	
	public PokerCard(int i, String color) {
		this.index_ = i;
		this.color_ = color;
		this.value_ = i;
	}
	
	public void setValue(int i) {
		this.value_ = i;
	}

}
