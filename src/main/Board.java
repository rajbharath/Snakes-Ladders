package main;

import java.util.List;

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
	private int endPosition;
	private List<Connectors> collectionOfConnectors;

	public Board(Cell[][] cells) {
		this.cells = cells;
		this.size = cells.length;
		this.endPosition = getSize() * getSize();
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

		for (Connectors connectors : collectionOfConnectors) {
			if (connectors.hasConnectorAt(currentCell)) {
				destinationCell = connectors.get(currentCell);
				break;
			}
		}

		updateThePlacements(player, destinationCell);
	}

	private Cell getDestinationCellFor(Cell presentCell, int distance) {
		int destinationPosition = presentCell.getPosition() + distance;
		return getCellAt(destinationPosition);
	}

	public Cell getCellAt(int position) {
		if (position > getFinishingPosition())
			position = getFinishingPosition();
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
		return endPosition;
	}

	public PlayersPlacements getPlayerPlacements() {
		return playersPlacements;
	}

	public void setCollectionOfConnectors(
			List<Connectors> collectionOfConnectors) {
		this.collectionOfConnectors = collectionOfConnectors;
	}

}
