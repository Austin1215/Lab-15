// Lab 15: Hand for War Game
// Justin Varga

import java.util.*;

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
			System.out.println("\n" + menu);
			input = reader.nextInt();	
			
			switch(input)
			{
				case 0: // Play
					playWar();
					break;
					
				case 1: // Check Cards
					System.out.println(toString());
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
	}
	
	public void playWar()
	{
		activeCard = hand.get(0);
		
		System.out.println(name + " drew " + activeCard.toString());
		
		hand.remove(activeCard);
	}
	
	public Card getActiveCard()
	{
		return activeCard;
	}
}