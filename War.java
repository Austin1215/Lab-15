// Lab 15: War
// Justin Varga

import java.util.*;

public class War
{	
	public static void main(String[] args)
	{
		// Initialize necessary variables
		Scanner reader = new Scanner(System.in);
		
		// Make deck
		Deck warDeck = new Deck();
		warDeck.shuffle();
		
		// Initialize Players
		WarHand[] players = new WarHand[2];
		players[0] = new WarHand("Opponent", warDeck);
		
		// TODO: try-catch and if statements for valid input
		System.out.print("Please input the player\'s name: ");
		String playerName = reader.next();
		players[1] = new WarHand(playerName, warDeck);
		
		// Play the game
		for (int i = 0 ; players[0].size() > 0 && players[1].size() > 0 ; i++)
		{
			System.out.println("\n----Turn " + i + "----");
			players[1].play();
			players[0].playWar();
			
			Card c1 = players[1].getActiveCard();
			Card c2 = players[0].getActiveCard();
			
			if (c1.getFaceInt() > c2.getFaceInt()) // You win
			{
				
			}
			else if (c2.getFaceInt() > c1.getFaceInt()) // Opponent wins 
			{
				
			}
			else // TIE!!!
			{
				
			}
		}
		
		// Declare the victor
		WarHand victor;
		if (players[0].size() > 0)
		{
			victor = players[0];
		}
		else
		{
			victor = players[1];
		}
		
		System.out.println(victor.getName() + " won with " + victor.size() + " cards remaining!");
	}
}
