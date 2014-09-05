package main;

/*
 * responsible for 
 * - deciding the direction of ladder (from bottom to top)
 * 
 * */
public class Ladders extends Connectors {

	public boolean hasLadderAt(Cell currentCell) {
		return keySet().contains(currentCell);
	}

	@Override
	public Cell decideConnectingDirection(Cell lowerPositionedCell,
			Cell higherPositionedCell) {
		return super
				.putWithDirection(lowerPositionedCell, higherPositionedCell);
	}

}
