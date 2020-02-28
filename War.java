// Lab 15: War
// Justin Varga

import java.util.*;

public class War
{
	public class WarHand extends Hand
	{
		public void play()
		{
			Scanner reader = new Scanner(System.in);
			final String menu = "Choose an option:\n[0]: Play\n[1]: Check Cards\n[2]: QUIT";
			int input;
			
			do
			{
				input = reader.nextInt();	
				
				switch(input)
				{
					case 0: // Play
						
						break;
						
					case 1: // Check Cards
						
						break;
						
					case 2:	// Quit
						System.exit(0);
						
					default: // Invalid Input
						System.out.println("Please input 0, 1, or 2.");
						continue;
				}
			}
			while(false);
			
		}
	}
	
	public static void main(String[] args)
	{
		// Initialize necessary variables
		Scanner reader = new Scanner(System.in);
		
		WarHand[] players = new WarHand[2];
		players[1] = 
		
		// Begin Turns
		while (victor.equals(null))
		{
			
		}
	}
}
