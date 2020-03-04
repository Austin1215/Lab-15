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
	
	public Card loseDraw() // If you lose the drawing match
	{
		return hand.remove(activeCard);
	}
	
	public void tieDraw() // When there is a tied draw
	{
		ArrayList<Card> tempHand = new ArrayList<Card>(3);
		
		for (int i = 2 ; i >= 0 ; i--)
		{
			Card c = hand.loseDraw();
			tempHand.add(i, c);
		}
		
		activeCard = tempHand.get(0);
		activeCard.play();
		
	}
	
	public Card getActiveCard()
	{
		return activeCard;
	}
}