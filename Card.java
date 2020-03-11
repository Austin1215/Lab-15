// Lab 15: Card
// Austin Barr, Tim Do, Steven Hampton, Justin Varga

import java.util.*;

public class Card
{	
	private String face;
	private int faceInt;
	private Suit suit;
	private boolean isPlayed = false;
	
	// Constructors
	public Card(int f, Suit s)
	{
		switch(f)
		{
			// Face Cards
			case 1: case 14:
				face = "A";
				break;
			
			case 11:
				face = "J";
				break;
				
			case 12:
				face = "Q";
				break;
				
			case 13:
				face = "K";
				break;
				
			// Non-Face Cases
			case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
				face = "" + f;
				break;
				
			default:
				System.out.println("Card can not be made \'" + f + "\' is not a valid card!");
				return;
		}
		
		suit = s;

		if (f == 1) faceInt = 14;
		else 		faceInt = f;
	}
	
	public void play()
	{
		isPlayed = true;
	}
	
	public boolean getPlayed()
	{
		return isPlayed;
	}
	
	public String getFace()
	{
		return face;
	}
	
	public int getFaceInt()
	{
		return faceInt;
	}
	
	public Suit getSuit()
	{
		return suit;
	}
	
	public String toString()
	{
		return face + " " + suit.character;
	}
}
