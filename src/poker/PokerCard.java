package poker;

public class PokerCard {
	
	private int index_ = 0;
	//remove
	private int value_ = 0;
	
	private int color_ = 0;
	private static String[] colors_ = { "Clubs", "Diamonds", "Hearts", "Spades" };
	
	////
	private static String[] values_ = {"Joker","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    
	public PokerCard(int color_, int values_) 
	{
	    this.index_=values_;
		this.color_=color_;
	}
	
	public String toString()
	{
	    return values_[index_]+" of "+colors_[color_];
	}
	
	public void setValue(int i) 
	{
		this.value_ = i;
	}
	
	public int getRank()
	{
		return value_;
	}
	public int getColor(int i)
	{
		return color_;	
	}
	public int getValue() {
		return this.value_;
	}
	
	public boolean equalValue(PokerCard card) {
		return card.getValue() == this.value_;
	}
}
