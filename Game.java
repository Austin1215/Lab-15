// Lab 15: Game (Tester)
// Austin Barr, Tim Do, Steven Hampton, and Justin Varga

public class Game
{
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		System.out.println(deck.toString());
		
		Hand h = new Hand("Austin", 5);
	}
}