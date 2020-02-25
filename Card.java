public class Card
{	
	private String face;
	private String suit;
	private boolean isPlayed = false;
	
	public Card(int n, String s)
	{
		number = n;
		suit = s;
	}
	
	public void play()
	{
		isPlayed = true;
	}
	public int getNumber()
	{
		return number;
	}
	public String getSuit()
	{
		return suit;
	}
	public String toString()
	{
		return face + " of " + suit;
	}
}