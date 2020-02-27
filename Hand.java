// Lab 15: Hand
// Austin Barr, Tim Do, Steven Hampton, Justin Varga

import java.util.*;

public class Hand
{
	// Variables
	public ArrayList<Card> hand = new ArrayList<Card>(5);
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
	public Deck getDeck()
	{
		return activeDeck;
	}
	
	public void setDeck(Deck d)
	{
		activeDeck = d;
	}
	
	public void play()
	{
		Scanner reader = new Scanner(System.in);
		
		int cardIndex = -1;
		
		do
		{
			System.out.println("Pick a card, any card:");
				
			for (int i = 0 ; i < hand.size() ; i++)
				System.out.printf("[%1d]:\t%4s\n", i, hand.get(i));
			
			try
			{
				cardIndex = reader.nextInt();
				
				if (hand.get(cardIndex).getPlayed())
				{
					throw new Error();
				}
			}
			catch(Exception err)
			{
				System.out.println("Card does not exist at that index!\n");
				continue;
			}
			catch(Error err)
			{
				System.out.println("Card already in play!\n");
				continue;
			}
			
			hand.get(cardIndex).play();
			break;
		}
		while(true);
		
	}
	
	public String showHand()
	{
		String handString = "";
		
		for (int i = 0 ; i < hand.size() ; i++)
		{
			Card c = hand.get(i);
			
			if (c.getPlayed())
			{
				handString += hand.get(i).toString();
			}
			else
			{
				handString += "***";
			}
			
			if (i != hand.size() - 1)
			{
				handString += "\t";
			}
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
		if (numberOfCards < 0)						errorMessage += "can't draw a negative number";
		else if (numberOfCards == 0)				errorMessage += "don't use draw if requesting 0 cards";
		else if (numberOfCards > hand.size())		errorMessage += "active deck only has (" + activeDeck.size() + ") cards";
		
		// Add # of cards to the hand
		for (int i = 0 ; i < numberOfCards ; i++)
		{
			hand.add(activeDeck.deal());
		}
	}
	
	public int size()
	{
		return hand.size();
	}
	
	public String toString()
	{
		return name + " has " + size() + " cards";
	}
}
