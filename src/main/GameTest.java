package main;

public class GameTest {
	/*
	 * Game Test responsibilities are
	 * - creating new Game
	 * - adding players
	 * - starting the game
	 * */
	public static void main(String[] args) {
		Game game = new Game(10, 10, 5);
		game.addPlayer(new Player("Raj"));
		game.addPlayer(new Player("Priya"));
		game.start();
	}
}
