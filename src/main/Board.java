package main;

import java.util.List;

public class Board {
	int[][] positions;
	List<Connector> connectors;

	public Board(int boardSize) {
		positions = new int[boardSize][boardSize];
	}

	public boolean hasConnectorAt() {
		return false;
	}

	public int getDestinationFor(int position) {
		return -1;
	}

}
