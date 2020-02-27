// Lab 15: Game (Tester)
// Austin Barr, Tim Do, Steven Hampton, and Justin Varga

public class Game
{
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		System.out.println(deck.toString());
		
		Hand[] players = new Hand[4];
		players[0] = new Hand("Austin", 5, deck);
		players[1] = new Hand("Tim", 5, deck);
		players[2] = new Hand("Steven", 5, deck);
		players[3] = new Hand("Justin", 5, deck);
		
		for (Hand p : players)
		{
			System.out.println(p.showHand());
		}
	}
}
