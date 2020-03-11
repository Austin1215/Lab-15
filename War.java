// Lab 15: War
// Justin Varga

import javax.swing.*;
import java.util.*;

public class War
{
	public static void main(String[] args) throws InterruptedException
	{
		// Initialize necessary variables
		Scanner reader = new Scanner(System.in);
		int turn;
		boolean autorun = false;
		final int MAX_TURNS = 10000;

		// Make deck
		Deck warDeck = new Deck();
		warDeck.shuffle();
		
		// Initialize Players
		Hand foe = new Hand("Opponent", 26, warDeck);
		Hand you = new Hand("Player", 26, warDeck);
		
		// Play the game
		for (turn = 1; foe.size() > 0 && you.size() > 0 && turn <= MAX_TURNS ; turn++)
		{
			System.out.println("\n----Turn " + turn + "----");
			
			// Player Input
			do
			{
				if (autorun)
				{
					System.out.println(you.toString());
					System.out.println(foe.toString());
					break;
				}

				System.out.println("[0]: Play\n[1]: Check Cards\n[2]: Enable Auto-Run (Can not be undone!)\n[3]: QUIT");
				int input = reader.nextInt();

				System.out.println();

				boolean again;

				switch(input)
				{
					case 2: // Enable Auto-Run
						autorun = true;

					case 0: // Play
						again = false;
						break;
					
					case 1: // Check Cards
						System.out.println(you.toString());
						System.out.println(foe.toString());
						again = true;
						break;

					case 3: // QUIT
						System.out.println("Have a nice day!\n");
						System.exit(0);
						again = false;
						break;

					default: // Invalid Input
						System.out.println("Please input 0, 1, 2, or 3.");
						again = true;
						break;
				}
				if (!again) break;
			}
			while(true);
			
			// Players draw
			ArrayList<Card> spoils = new ArrayList<Card>(10);
			do
			{
				you.play();
				foe.play();

				Card youCard = you.remove();
				Card foeCard = foe.remove();

				spoils.add(youCard);
				spoils.add(foeCard);

				System.out.println("Player drew " + youCard.toString());
				System.out.println("Opponent drew " + foeCard.toString());
				
				// Determine Draw Winner
				String youOutcome = "Player's " + youCard.toString();
				String foeOutcome = "Opponent's " + foeCard.toString();

				int youCardValue = youCard.getFaceInt();
				int foeCardValue = foeCard.getFaceInt();
			
				if (foeCardValue == youCardValue) // TIE!!
				{
					System.out.println(youOutcome + " ties " + foeOutcome);
			
					// Make sure both sides have enough cards to war with
					int spoilsCount = 3; // Defaults to three spoils cards
					
					if (foe.size() < spoilsCount && foe.size() <= you.size())
					{
						spoilsCount = foe.size();
					}
					else if (you.size() < spoilsCount && you.size() < foe.size())
					{
						spoilsCount = you.size();
					}

					if (spoilsCount == 0) continue;

					// Add to the spoils and provide a message
					String cardBlanks = "";

					for (int i = 0 ; i < spoilsCount ; i++)
					{
						cardBlanks += "*** ";

						spoils.add(foe.remove());
						spoils.add(you.remove());
					}

					System.out.println(cardBlanks + "\n" + cardBlanks);
				}
				else if (youCardValue > foeCardValue) // You win
				{
					System.out.println(youOutcome + " beats " + foeOutcome);
					System.out.println("Player wins!");
					you.add(spoils);
					break;
				}
				else // Opponent wins
				{
					System.out.println(foeOutcome + " beats " + youOutcome);
					System.out.println("Opponent wins!");
					foe.add(spoils);
					break;
				}
			}
			while(true);

			System.out.println("------------------");
		}
		
		// Declare the victor
		System.out.println("\n~~~~ VICTORY ~~~~\n");
		
		Hand victor;
		if (foe.size() > you.size())
		{
			victor = foe;
		}
		else if (foe.size() < you.size())
		{
			victor = you;
		}
		else
		{
			System.out.println("Tied Game!");
			return;
		}
		
		System.out.println(victor.getName() + " won the War in " + turn + " turns!");
	}
}
