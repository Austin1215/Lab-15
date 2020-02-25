// Lab 15: Card
// Austin Barr, Tim Do, Steven Hampton, Justin Varga

import java.util.*;

public class Deck //holds cards
{
	private ArrayList<Card> cards = new ArrayList<Card>(52);
	
	public Deck()
	{
		String[] suits = {"spades", "hearts", "diamonds", "clubs"};
		
		for(String suit : suits)
		{
			for (int i = 1 ; i <= 13 ; i++)
			{
				String face = "";
				
				switch(i)
				{
					case 1:
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
					
					default:
						face += i;
						break;
				}
				
				cards.add(new Card(face, suit));
				
			}
		}
	}
	
	//deal hand of a specified (not fixed) number of cards to four players
	public ArrayList<Card> deal(int numberOfCards)
	{
		if (numberOfCards > cards.size())
		{
			System.out.println("Hey! You can't do that! (Error in Deck > deal())");
			return;
		}
		
		ArrayList<Card> dealtCards = new ArrayList<Card>(numberOfCards);
		
		for (int i = 0 ; i < numberOfCards ; i++)
		{
			dealtCards.add(cards.remove(i));
		}
		
		return dealtCards;
	}
	
	public void shuffle()
	{
		Random prng = new Random(); // Pringle
		
		for (int bridges = 0 ; bridges <= 7 ; bridges++) // 7 is absolutely arbitrary
		{
			for (int i = 0 ; i < cards.size() ; i++)
			{
				// Making sure the random number is not the same as the current index
				int n;
				
				while (n == i) n = prng.nextInt(cards.length);
				
				// Swap the cards
				Card temp = cards[i];
				cards[i] = cards[n];
				cards[n] = temp;
			}
		}
	}
	
	public String toString()
	{
		return "DECK: holding " + cards.size() + " cards";
	}
}