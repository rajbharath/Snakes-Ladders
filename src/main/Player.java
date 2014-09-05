package main;

/*
 * Player is responsible for
 * - storing the player info such as name
 * - playing the game by rolling the dice
 * 
 * */
public class Player {
	String name;

	public Player(String string) {
		name = string;
	}

	public void play(Dice dice) {
		dice.roll();
	}

	public String getName() {
		return name;
	}

}
