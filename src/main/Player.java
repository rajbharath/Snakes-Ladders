package main;

/*
 * Player is responsible for
 * - storing the player info such as name and position
 * - manipulating the position according the die value
 * - moving to the position according the rule applied
 * - playing the game by rolling the die
 * */
public class Player {
	String name;

	public Player(String string) {
		name = string;
	}

	public void play(Die die) {
		die.roll();
	}

	public boolean reachedEnd(Board board) {
		// return getPosition() >= board.getMax();
		return false;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
