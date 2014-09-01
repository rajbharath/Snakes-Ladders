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
public class Board implements PlayerPlacementChangedListener {
	Cell[][] cells;
	PlayersPlacements playersPlacements;

	public void forward(Player currentPlayer, int dieFace) {
		// find the resulting cell to place the player on it
		Cell presentCell = playersPlacements.get(currentPlayer);
		Cell cellToPlace = findDistantCell(presentCell, dieFace);
		updateThePlacements(currentPlayer, cellToPlace);
	}

	private void updateThePlacements(Player currentPlayer, Cell cellToPlace) {
		playersPlacements.put(currentPlayer, cellToPlace);
	}

	private Cell findDistantCell(Cell presentCell, int distance) {
		Cell cellAtDistance = null;
		return cellAtDistance;
	}

	@Override
	public void placementsUpdated(Player player) {
		Cell destinationCell = null;
		/*
		 * if the cellTo place has any snake/ladder update the placement again
		 * according to the snakes
		 */
		updateThePlacements(player, destinationCell);
	}
}
