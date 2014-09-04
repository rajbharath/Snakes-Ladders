package main;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*
 * BoardBuilder is responsible for
 * - building a board
 * */
public class BoardBuilder {
	int maximumPosition;
	Random random = new Random();
	private List<Connectors> collectionOfConnectors;
	private Board board;
	private Snakes snakes;
	private Ladders ladders;

	public Board build(int boardSize, int snakesCount, int laddersCount) {
		maximumPosition = boardSize * boardSize;

		Cell[][] cells = new Cell[boardSize][boardSize];
		int position = 1 - boardSize;
		for (int row = 0; row < boardSize; row++) {
			boolean oddRow = row % 2 == 0 ? false : true;
			if (oddRow)
				position += boardSize + 1;
			else
				position += boardSize - 1;
			for (int column = 0; column < boardSize; column++) {
				if (oddRow)
					position--;
				else
					position++;
				cells[row][column] = new Cell(position, row, column);
			}
		}
		board = new Board(cells);

		collectionOfConnectors = new ArrayList<Connectors>();
		snakes = new Snakes();
		ladders = new Ladders();

		setUpConnectors(snakesCount, laddersCount);

		collectionOfConnectors.add(snakes);
		collectionOfConnectors.add(ladders);

		board.setCollectionOfConnectors(collectionOfConnectors);
		return board;
	}

	private void setUpConnectors(int snakesCount, int laddersCount) {

		List<Integer> connectingPoints = new ArrayList<Integer>();
		connectingPoints.addAll(getConnectingPoints(snakesCount, laddersCount));

		List<Integer> snakeConnectingPoints = connectingPoints.subList(0,
				snakesCount * 2);
		List<Integer> ladderConnectingPoinst = connectingPoints.subList(
				snakesCount * 2, connectingPoints.size());

		for (int i = 0; i < snakesCount * 2 - 1; i += 2) {
			snakes.put(board.getCellAt(snakeConnectingPoints.get(i)),
					board.getCellAt(snakeConnectingPoints.get(i + 1)));
		}

		for (int i = 0; i < laddersCount * 2 - 1; i += 2) {
			ladders.put(board.getCellAt(ladderConnectingPoinst.get(i)),
					board.getCellAt(ladderConnectingPoinst.get(i + 1)));
		}

	}

	private Set<Integer> getConnectingPoints(int snakesCount, int laddersCount) {
		Set<Integer> connectingPoints = new LinkedHashSet<Integer>();

		int totalConnectingPointsCount = snakesCount * 2 + laddersCount * 2;

		while (connectingPoints.size() != totalConnectingPointsCount) {
			int randomNumber = random.nextInt(maximumPosition) + 1;
			if (randomNumber != 1 && randomNumber != maximumPosition)
				connectingPoints.add(randomNumber);
		}
		return connectingPoints;
	}

}