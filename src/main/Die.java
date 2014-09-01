package main;

import java.util.Random;

/*
 * Die is responsible for
 * - getting the random number between 1-6
 * */
public class Die {

	DieListener dieListener;
	int face;

	private Random random;
	private static final int MAX_DIE_POSSIBILITY = 6;

	public Die() {
		random = new Random();
	}

	public void roll() {
		face = random.nextInt(MAX_DIE_POSSIBILITY) + 1;
		notifyDieListener();
	}

	public void notifyDieListener() {
		dieListener.onDieRolled(face);
	}
}
