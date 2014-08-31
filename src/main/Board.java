package main;

public class Board {
	int[] positions;
	private Snakes snakes;
	private int size;

	public Board(int boardSize, Snakes snakes) {
		calculateMaxIndex(boardSize);
		positions = new int[getMax()];
		this.snakes = snakes;
	}

	private void calculateMaxIndex(int boardSize) {
		size = boardSize * boardSize;
	}

	public boolean hasSnakeAt(int position) {
		return snakes.isSnakePresent(position);
	}

	public int getTail(int position) {
		return snakes.getTail(position);
	}

	public int getMax() {
		return size;
	}

	public void displaySnakes() {
		snakes.display();
	}
}
