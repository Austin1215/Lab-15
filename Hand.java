// Lab 15: Hand
// Austin Barr, Tim Do, Steven Hampton, Justin Varga

import java.util.*;

public class Hand
{
	// Variables
	protected ArrayList<Card> hand = new ArrayList<Card>(5);
	protected Deck activeDeck;
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
		// This method should be overwritten by a sub-class.
		// However, hand is not abstract, and I don't want to make it so
		// if all that will be abstract is this one method.
		play(-1); 
	}
	
	public void play(int index)
	{
		int cardIndex = index;
		
		if(index < 0 || index >= size())
		{
			String prompt = "Pick a card, any card:"
			Scanner reader = new Scanner(System.in);
			
			do
			{
				System.out.println(prompt);

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
					prompt = "Card does not exist at that index!\nPick a different card:";
					continue;
				}
				catch(Error err)
				{
					prompt = "Card already in play!\nPick a different card:";
					continue;
				}

				break;
			}
			while(true);
		}
		
		hand.get(cardIndex).play();
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
	
	public void draw()
	{
		// Draws one card
		draw(1);
	}
	
	public void draw(int numberOfCards)
	{
		// Handle weird numbers
		String errorMessage = String.format(" attempted draw of %3d cards :: ",numberOfCards);
		if (numberOfCards < 0)
		{
			errorMessage += "can't draw a negative number";
		}
		else if (numberOfCards == 0)
		{
			errorMessage += "don't use draw if requesting 0 cards";
		}
		else if (numberOfCards > hand.size())
		{
			errorMessage += "active deck only has (" + activeDeck.size() + ") cards";
		}
		
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
