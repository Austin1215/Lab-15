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
			// Players Draw
			final String menu = "\nChoose an option:\n[0]: Play\n[1]: Check Cards\n[2]: QUIT";
			
			int input;
			do
			{
				System.out.println(menu);
				input = reader.nextInt();	
			
				switch(input)
				{
					case 0: // Play
						break;
					
					case 1: // Check Cards
						System.out.println(players[1].toString());
						continue;
					
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
			
			players[1].play();
			players[0].play();
			
			Card c0 = players[0].getActiveCard();
			Card c1 = players[1].getActiveCard();
			
			System.out.printf("\n%1s drew %4s", players[0].getName(), c0.toString());
			System.out.printf("\n%1s drew %4s", players[1].getName(), c1.toString());
			
			// Determine Draw Winner
			int f0 = c0.getFaceInt();
			int f1 = c1.getFaceInt();
			
			if (f0 == f1) // TIE!!!
			{
				System.out.println(f0 + " = " + f1);
				 
				
			}
			else // Someone Won
			{
				if (f0 < f1) // You win
				{
					System.out.printf("\n%2d > %2d :: %1s wins!", f1, f0, players[1].getName());
					players[1].winDraw(players[0].loseDraw());
				}
				else if (f0 > f1) // Opponent wins 
				{
					System.out.printf("\n%2d > %2d :: %1s wins!", f0, f1, players[0].getName());
					players[0].winDraw(players[1].loseDraw());
				}
			}
			
			System.out.println("\n------------------\n");
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
