// Lab 15: Hand for War Game
// Justin Varga

import java.util.*;

public class WarHand extends Hand
{	
	private Card activeCard;
	
	public WarHand(String n, Deck d)
	{
		super(n, 26, d);
	}
	
	public void play()
	{
		activeCard = getCard(0);
		activeCard.play();
	}
	
	public Card getActiveCard()
	{
		return activeCard;
	}
	
	public Card getCard(int index)
	{
		if (index > size() || index < 0)
		{
			System.out.println("WarHand.getCard() : index out of bounds : " + index);
			return null;
		}
		
		return hand.get(index);
	}
}
