package main;

import java.util.Random;

public class LadderBuilder {
	static Random random = new Random();

	public static Ladder build(int maximumDistance) {
		int top = random.nextInt(maximumDistance) + 1;
		int bottom = random.nextInt(top) + 1;
		return new Ladder(bottom, top);
	}
}
