// Lab 15: Hand
// Austin Barr, Tim Do, Steven Hampton, Justin Varga

import java.util.*;

public class Hand
{
	// Variables
	private ArrayList<Card> hand = new ArrayList<Card>(5);
	private Deck activeDeck;
	private String name = "";
	
	// Constructors
	public Hand(String name, int numberOfCards, Deck d)
	{
		this.name = name;
		
		activeDeck = d;
		
		hand = new ArrayList<Card>(numberOfCards);
		draw(numberOfCards);
	}
	
	// Methods
	public void play(Card theCard)
	{
		theCard.play();
	}
	
	public String printHand()
	{
		// TODO: Specify which cards to show
		String handString = "";
		
		for (int i = 0 ; i < hand.size() ; i++)
		{
			handString += hand.get(i).toString();
			if (i != hand.size() - 1) handString += " ";
		}
		
		return handString;
	}
	
	public void draw(Deck deck)
	{
		// Draw one card
		draw(1);
	}
	
	public void draw(int numberOfCards)
	{
		// Handle weird numbers
		String errorMessage = String.format(" attempted draw of %3d cards :: ",numberOfCards);
		if (numberOfCards < 0)					errorMessage += "can't draw a negative number";
		else if (numberOfCards = 0)				errorMessage += "don't use draw if requesting 0 cards";
		else if (numberOfCards > hand.size())	errorMessage += "active deck only has (" + activeDeck.size() + ") cards";
		
		// Add # of cards to the hand
		for (int i = 0 ; i < numberOfCards ; i++)
		{
			hand.add(activeDeck.deal());
		}
	}
}
