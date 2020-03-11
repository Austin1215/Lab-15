// Lab 15: Suit
// Justin Varga

public enum Suit
{
	CLUBS("clubs", '\u2660'), 
	HEARTS("hearts", '\u2665'), 
	DIAMONDS("diamonds", '\u2666'), 
	SPADES("spades", '\u2663');
	
	public final String string;
	public final char character;
	
	private Suit(String s, char c)
	{
		string = s;
		character = c;
	}
}
