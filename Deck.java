// Lab 15: Card
// Austin Barr, Tim Do, Steven Hampton, Justin Varga

import java.util.*;

public class Deck
{
	private ArrayList<Card> cards = new ArrayList<Card>(52);
	
	// Constructor(s)
	public Deck() // Standard Deck
	{
		for(Suit suit : Suit.values())
		{
			for (int i = 1 ; i <= 13 ; i++)
			{	
				cards.add(new Card(i, suit));	
			}
		}
	}
	
	//deal hand of a specified (not fixed) number of cards to four players
	public Card deal()
	{
		return deal(1).get(0);
	}
	
	public ArrayList<Card> deal(int numberOfCards)
	{
		if (numberOfCards > size())
		{
			System.out.println("Hey! You can't do that! (There aren\'t that many cards, you greedy pig)");
			return null;
		}

		ArrayList<Card> dealtCards = new ArrayList<Card>(numberOfCards);

		for (int i = 0 ; i < numberOfCards ; i++)
		{
			dealtCards.add(cards.remove(0));
		}
		
		return dealtCards;
	}
	
	public void shuffle()
	{
		Random prng = new Random(); // Pringle
		for (int i = 0 ; i < size() ; i++)
		{
			// Making sure the random number is not the same as the current index
			int n;

			do 
			{ 
				n = prng.nextInt(size());
			} 
			while (n == i);

			// Swap the cards
			Card temp = cards.get(i);
			cards.set(i, cards.get(n));
			cards.set(n, temp);
		}
	}
	
	public int size()
	{
		return cards.size();
	}
	
	public String toString()
	{
		return "DECK: " + size() + " cards";
	}
}
