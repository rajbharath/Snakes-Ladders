package main;

import java.util.Random;

public class BoardBuilder {
	int maximumPosition;
	Random random = new Random();

	public Board build(int boardSize, int snakeCount, int ladderCount) {
		maximumPosition = boardSize * boardSize;
		Snakes snakes = setUpSnakes(snakeCount);
		Board board = new Board(boardSize, snakes);
		return board;
	}

	private Snakes setUpSnakes(int snakeCount) {
		Snakes snakes = new Snakes();
		int snakesAdded = 0;
		while (snakesAdded < snakeCount) {
			int head = random.nextInt(maximumPosition) + 1;
			int tail = random.nextInt(head) + 1;
			snakes.put(head, tail);
			snakesAdded = snakes.keySet().size();
		}
		return snakes;
	}
}