package main;

import java.util.Random;

public class SnakeBuilder {
	static Random random = new Random();

	public static Snake build(int maximumDistance) {
		int head = random.nextInt(maximumDistance) + 1;
		int tail = random.nextInt(head) + 1;
		return new Snake(head, tail);
	}
}
