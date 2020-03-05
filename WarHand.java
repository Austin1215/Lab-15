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
		activeCard = hand.get(0);
		activeCard.play();
	}
	
	public void winDraw(Card c) // If you win the drawing match
	{
		hand.add(c);
	}
	
	public void winDraw(Card[] cs)
	{
		for (Card c : cs)
		{
			winDraw(c);
		}
	}
	
	public Card loseDraw() // If you lose the drawing match
	{
		return hand.remove(0);
	}
	
	public Card getActiveCard()
	{
		return activeCard;
	}
}