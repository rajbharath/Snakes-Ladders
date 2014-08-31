package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardBuilder {
	int maximumPosition;

	public Board build(int boardSize, int snakeCount, int ladderCount) {
		Board board = new Board(boardSize);
		maximumPosition = boardSize * boardSize;
		List<Connector> connectors;
		List<Snake> snakes = setUpSnakes(snakeCount);
		List<Ladder> ladders = setUpLadders(ladderCount);
		// board.setConnectors();
		return null;
	}

	private List<Ladder> setUpLadders(int ladderCount) {
		List<Ladder> ladders = new ArrayList<Ladder>();
		for (int i = 0; i < ladderCount; i++) {
			ladders.add(LadderBuilder.build(maximumPosition));
		}
		return ladders;
	}

	private Snakes setUpSnakes(int snakeCount) {
		Snakes snakes = new Snakes();
		for (int i = 0; i < snakeCount; i++) {
			snakes.add(SnakeBuilder.build(maximumPosition));
		}
		return snakes;
	}
}