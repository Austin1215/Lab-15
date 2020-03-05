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
	
	public void add(Card c) // If you win the drawing match
	{
		hand.add(c);
	}
	
	public void add(ArrayList<Card> cs)
	{
		for (Card c : (Card[])cs.toArray())
		{
			add(c);
		}
	}
	
	public Card remove()
	{
		return hand.remove(0);
	}
	
	public Card remove(int index)
	{
		if (index > size() || index < 0)
		{
			System.out.println("WarHand.remove() : index out of bounds : " + index);
			return null;
		}
		
		return hand.remove(index);
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
