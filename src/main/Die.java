package main;

import java.util.Random;

/*
 * Die is responsible for
 * - getting the random number between 1-6
 * */
public class Die {

	private static Random random = new Random();;
	private static final int MAX_DIE_POSSIBILITY = 6;

	public static int roll() {
		return random.nextInt(MAX_DIE_POSSIBILITY) + 1;
	}

}
