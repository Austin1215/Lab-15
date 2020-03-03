// Lab 15: War
// Justin Varga

import java.util.*;

public class War
{
	public class WarHand extends Hand
	{	
		private Card activeCard;
		
		public WarHand(String n, Deck d)
		{
			super(n, 26, d);
		}
		
		public void play()
		{
			final String menu = "Choose an option:\n[0]: Play\n[1]: Check Cards\n[2]: QUIT";
			
			Scanner reader = new Scanner(System.in);
			int input;
			
			do
			{
				input = reader.nextInt();	
				
				switch(input)
				{
					case 0: // Play
						playWar();
						break;
						
					case 1: // Check Cards
						System.out.println(toString());
						break;
						
					case 2:	// Quit
						System.out.println("Have a nice day!");
						System.exit(0);
						break;
						
					default: // Invalid Input
						System.out.println("Please input 0, 1, or 2.");
						continue;
				}
			}
			while(false);
		}
		
		public void playWar()
		{
			activeCard = hand.get(0);
			
			System.out.println(name + " drew " + activeCard.toString());
		}
		
		public Card getActiveCard()
		{
			return activeCard;
		}
	}
	
	public static void main(String[] args)
	{
		// Initialize necessary variables
		Scanner reader = new Scanner(System.in);
		
		// Create Players and Deck
		Deck warDeck = new Deck();
		WarHand[] players = new WarHand[2];
		players[0] = new WarHand("Opponent", warDeck);
		// TODO: try-catch for valid input
		System.out.print("Please input the player\'s name: ");
		String playerName = reader.next();
		players[1] = new WarHand(playerName, warDeck);
		
		// Play the game
		for (int i = 0 ; players[0].size() > 0 && players[1].size() > 0 ; i++)
		{
			
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
