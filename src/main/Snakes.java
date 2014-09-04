package main;

/*
 * responsible for 
 * - finding the snake for a head
 * - getting the tail for a snake's head
 * 
 * */

public class Snakes extends Connectors {

	public boolean hasSnakeAt(Cell currentCell) {
		return keySet().contains(currentCell);
	}

	@Override
	public Cell decideConnectingDirection(Cell lowerPositionedCell,
			Cell higherPositionedCell) {
		return super
				.putWithDirection(higherPositionedCell, lowerPositionedCell);

	}

}
