package main;

/*
 * Board class is responsible for 
 * - forwarding the player
 * - updating the placements
 * - has cells and its position mapping
 * */

public class Board implements PlayerPlacementChangedListener {
	Cell[][] cells;
	PlayersPlacements playersPlacements;
	Snakes snakes;
	Ladders ladders;
	private int size;

	public Board(Cell[][] cells) {
		this.cells = cells;
		this.size = cells.length;
		playersPlacements = new PlayersPlacements(this);
	}

	public void setSnakes(Snakes snakes) {
		this.snakes = snakes;
	}

	public void setLadders(Ladders ladders) {
		this.ladders = ladders;
	}

	public void forward(Player currentPlayer, int diceFace) {
		Cell presentCell = playersPlacements.get(currentPlayer);
		Cell cellToPlace = getDestinationCellFor(presentCell, diceFace);
		updateThePlacements(currentPlayer, cellToPlace);
	}

	private void updateThePlacements(Player currentPlayer, Cell cellToPlace) {
		playersPlacements.put(currentPlayer, cellToPlace);
	}

	@Override
	public void placementsUpdated(Player player) {
		Cell currentCell = playersPlacements.get(player);
		Cell destinationCell = currentCell;
		if (snakes.hasSnakeAt(currentCell)) {
			destinationCell = snakes.get(currentCell);
		} else if (ladders.hasLadderAt(currentCell)) {
			destinationCell = ladders.get(currentCell);
		}

		updateThePlacements(player, destinationCell);
	}

	private Cell getDestinationCellFor(Cell presentCell, int distance) {
		int destinationPosition = presentCell.getPosition() + distance;
		return getCellAt(destinationPosition);
	}

	public Cell getCellAt(int position) {
		for (int row = 0; row < getSize(); row++) {
			for (int column = 0; column < getSize(); column++) {
				if (cells[row][column].getPosition() == position)
					return cells[row][column];
			}
		}
		return null;
	}

	private int getSize() {
		return size;
	}

	public boolean isFinished(Player player) {
		return playersPlacements.get(player).getPosition() == getFinishingPosition();
	}

	private int getFinishingPosition() {
		return getSize() * getSize();
	}

}
