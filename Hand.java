// Lab 15: Hand
// Austin Barr, Tim Do, Steven Hampton, Justin Varga

import java.util.*;

public class Hand
{
	private ArrayList<Card> hand = new ArrayList<Card>(5);
	private Deck activeDeck;
	
	private String name = "";
	
	// Constructor(s)
	public Hand(String name, int numberOfCards, Deck d)
	{
		this.name = name;
		
		activeDeck = d;
		
		hand = new ArrayList<Card>(numberOfCards);
		draw(numberOfCards);
	}
	
	public void play(Card theCard)
	{
		theCard.play();
	}
	
	public void showCards()
	{
		
	}
	
	public void draw(Deck deck)
	{
		draw(1);
	}
	
	public void draw(int numberOfCards)
	{
		// TODO: Handle weird numbers
		
		for (int i = 0 ; i < numberOfCards ; i++)
		{
			hand.add(activeDeck.deal());
		}
	}
}