package main;

import java.util.Random;

/*
 * Dice is responsible for
 * - getting the random number between 1-6
 * */
public class Dice {

	DiceListener diceListener;
	int face;

	private Random random;
	private static final int MAX_DICE_POSSIBILITY = 6;

	public Dice(DiceListener diceListener) {
		this.diceListener = diceListener;
		random = new Random();
	}

	public void roll() {
		face = random.nextInt(MAX_DICE_POSSIBILITY) + 1;
		notifyDiceListener();
	}

	public void notifyDiceListener() {
		diceListener.onDiceRolled(face);
	}
}
