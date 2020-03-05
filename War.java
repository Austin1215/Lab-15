// Lab 15: War
// Justin Varga

import java.util.*;

public class War
{	
	public static void main(String[] args)
	{
		// Initialize necessary variables
		Scanner reader = new Scanner(System.in);
		int turn = 1;
		
		// Make deck
		Deck warDeck = new Deck();
		warDeck.shuffle();
		
		// Initialize Players
		WarHand foe = new WarHand("Opponent", warDeck);
		WarHand you = new WarHand("Player", warDeck);
		
		// Play the game
		for (; foe.size() > 0 && you.size() > 0 ; turn++)
		{
			System.out.println("\n----Turn " + turn + "----");
			
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
			ArrayList<Card> spoils = new ArrayList<Card>(10);
			do
			{
				you.play();
				foe.play();
			
				Card youCard = you.getActiveCard();
				Card foeCard = foe.getActiveCard();
			
				System.out.println("Opponent drew " + foeCard.toString());
				System.out.println("Player drew " + youCard.toString());
				
				// Determine Draw Winner
				int foeCardValue = foeCard.getFaceInt();
				int youCardValue = youCard.getFaceInt();
			
				if (foeCardValue == youCardValue) // TIE!!
				{
					System.out.println(foeCard.getFace() + " = " + youCard.getFace() + " :: TIE!");
			
					// Draw the spoils cards
					int spoilsCount = 3;
					
					if (foe.size() < spoilCount && foe.size() <= you.size())
					{
						spoilsCount = foe.size();
					}
					else if (you.size() < spoilCount && you.size() < foe.size())
					{
						spoilsCount = you.size();
					}
					
					for (int i = 0 ; i < spoilsCount ; i++)
					{
						spoils.add(foe.remove(i));
						spoils.add(you.remove(i));
					}
					
					// Draw again
					continue;
				}
				else if (foeCardValue < youCardValue) // You win
				{
					System.out.printf("\n%1s > %1s :: Player wins!\n", youCard.getFace(), foeCard.getFace());
					spoils.add(foe.remove());
					you.winDraw(spoils);
				}
				else // Opponent wins 
				{
					System.out.printf("\n%1s > %1s :: Opponent wins!\n", foeCard.getFace(), youCard.getFace());
					spoils.add(you.remove());
					foe.winDraw(spoils);
				}
			}
			while(false);
			
			System.out.println("\n------------------");
		}
		
		// Declare the victor
		System.out.println("\n~~~~ VICTORY ~~~~\n");
		
		WarHand victor;
		if (foe.size() > 0)
		{
			victor = foe;
		}
		else
		{
			victor = you;
		}
		
		System.out.println(victor.getName() + " won the War in " + turn + "!");
	}
}
