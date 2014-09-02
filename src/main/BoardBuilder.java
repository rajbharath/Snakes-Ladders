package main;

import java.util.Random;

/*
 * BoardBuilder is responsible for
 * - building a board
 * */
public class BoardBuilder {
	int maximumPosition;
	Random random = new Random();
	private Snakes snakes;
	private Ladders ladders;
	private Board board;

	public Board build(int boardSize, int snakeCount, int ladderCount) {
		maximumPosition = boardSize * boardSize;

		Cell[][] cells = new Cell[boardSize][boardSize];
		int position = 1;
		for (int row = 0; row < boardSize; row++) {
			boolean oddRow = row % 2 == 0 ? false : true;
			if (oddRow)
				position += boardSize;
			for (int column = 0; column < boardSize; column++) {
				cells[row][column] = new Cell(position, row, column);
				if (oddRow)
					position--;
				else
					position++;
			}
		}
		board = new Board(cells);

		snakes = setUpSnakes(snakeCount);
		ladders = setUpLadders(ladderCount);
		board.setSnakes(snakes);
		board.setLadders(ladders);
		return board;
	}

	private Snakes setUpSnakes(int snakeCount) {
		Snakes snakes = new Snakes();
		int snakesAdded = 0;
		while (snakesAdded < snakeCount) {
			int head = random.nextInt(maximumPosition) + 1;
			if (snakes.keySet().contains(head))
				continue;
			int tail = random.nextInt(head) + 1;
			snakes.put(board.getCellAt(head), board.getCellAt(tail));
			snakesAdded = snakes.keySet().size();
		}
		return snakes;
	}

	private Ladders setUpLadders(int ladderCount) {
		ladders = new Ladders();
		int laddersAdded = 0;
		while (laddersAdded < ladderCount) {
			int top = random.nextInt(maximumPosition) + 1;
			if (snakes.keySet().contains(top) || snakes.values().contains(top))
				continue;
			int bottom = random.nextInt(top) + 1;
			if (snakes.keySet().contains(top) || snakes.values().contains(top)
					|| ladders.keySet().contains(bottom))
				continue;
			ladders.put(board.getCellAt(bottom), board.getCellAt(top));
			laddersAdded = ladders.keySet().size();
		}
		return ladders;
	}
}