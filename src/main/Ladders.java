package main;

/*
 * responsible for 
 * - finding the ladder for Bottom cell
 * - getting the top for a botton cell
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
