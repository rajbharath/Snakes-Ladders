package main;

/*
 * responsible for 
 * - deciding the direction of ladder (from head to tail)
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
