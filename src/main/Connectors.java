package main;

import java.util.HashMap;
/*
 * responsibilities are
 * - holding connections between two cells
 * */
public abstract class Connectors extends HashMap<Cell, Cell> {
	public boolean hasConnectorAt(Cell cell) {
		return keySet().contains(cell);
	}

	@Override
	public Cell put(Cell connectingPoint1, Cell connectingPoint2) {

		Cell lowerPositionedCell = connectingPoint1;
		Cell higherPositionedCell = connectingPoint2;
		if (connectingPoint1.getPosition() > connectingPoint2.getPosition()) {
			lowerPositionedCell = connectingPoint2;
			higherPositionedCell = connectingPoint1;

		}
		return decideConnectingDirection(lowerPositionedCell,
				higherPositionedCell);
	}

	public abstract Cell decideConnectingDirection(Cell lowerPositionedCell,
			Cell higherPositionedCell);

	protected Cell putWithDirection(Cell connectingPoint1, Cell connectingPoint2) {
		return super.put(connectingPoint1, connectingPoint2);
	}
}
