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
		WarHand foe = new WarHand("Opponent", warDeck);
		WarHand you = new WarHand("Player", warDeck);
		
		// Play the game
		for (int i = 0 ; foe.size() > 0 && you.size() > 0 ; i++)
		{
			System.out.println("\n----Turn " + i + "----");
			
			// Your Input
			boolean inputBool = false; // A condition for the input
			do
			{
				System.out.println("\nChoose an option:\n[0]: Play\n[1]: Check Cards\n[2]: QUIT");
				int input = reader.nextInt();
				System.out.println();
				
				switch(input)
				{
					case 0: // Play
						break;
					
					case 1: // Check Cards
						System.out.println(you.toString());
						System.out.println(foe.toString());
						inputBool = true;
						break;
					
					case 2:	// Quit
						System.out.println("Have a nice day!\n");
						System.exit(0);
						break;
					
					default: // Invalid Input
						System.out.println("Please input 0, 1, or 2.");
						inputBool = true;
						break;
				}
			}
			while(inputBool);
			
			// Players draw
			do
			{
				you.play();
				foe.play();
			
				Card youCard = you.getActiveCard();
				Card foeCard = foe.getActiveCard();
			
				System.out.println("Opponent drew " + foeCard.toString());
				System.out.println("Player drew " + youCard.toString());
				
				ArrayList<Card> spoils = new ArrayList<Card>(52);
				int spoilCounter = 2;
				
				// Determine Draw Winner
				int foeCardValue = foeCard.getFaceInt();
				int youCardValue = youCard.getFaceInt();
			
				if (foeCardValue == youCardValue) // TIE!!
				{
					System.out.println(foeCard.getFace() + " = " + youCard.getFace() + " :: TIE!");
			
					// Draw the spoil cards
					for (int i = 0 ; i < spoilCounter / 2 ; i++)
					{
						spoils.add(foe.loseDraw());
						spoils.add(you.loseDraw());
					}
					
					// Draw again
					continue;
				}
				else if (foeCardValue < youCardValue) // You win
				{
					System.out.printf("\n%1s > %1s :: Player wins!\n", youCard.getFace(), foeCard.getFace());
					you.winDraw(spoils.toArray());
				}
				else // Opponent wins 
				{
					System.out.printf("\n%1s > %1s :: Opponent wins!\n", foeCard.getFace(), youCard.getFace());
					foe.winDraw(spoils.toArray());
				}
			}
			while(false);
			
			System.out.println("\n------------------\n");
		}
		
		// Declare the victor
		WarHand victor;
		if (foe.size() > 0)
		{
			victor = foe;
		}
		else
		{
			victor = you;
		}
		
		System.out.println(victor.getName() + " won with " + victor.size() + " cards remaining!");
	}
}
