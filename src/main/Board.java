package main;

/*
 * Board class is responsible for 
 * -display ladders
 * -display snakes
 * -getTail() of a snake head
 * - getTop() of a ladder bottom
 * - finds a position has ladder
 * - finds a position has snake
 * */
public class Board {
	int[] positions;
	private Snakes snakes;
	private Ladders ladders;
	private int size;

	public Board(int boardSize, Snakes snakes, Ladders ladders) {
		calculateMaxIndex(boardSize);
		positions = new int[getMax()];
		this.snakes = snakes;
		this.ladders = ladders;
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

	public boolean hasLadderAt(int position) {
		return ladders.isLadderPresent(position);
	}

	public int getTop(int position) {
		return ladders.getTop(position);
	}

	public int getMax() {
		return size;
	}

	public void displaySnakes() {
		snakes.display();
	}

	public void displayLadders() {
		ladders.display();
	}
}
