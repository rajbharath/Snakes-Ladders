package main;

import java.util.HashMap;

/*
 * responsible for 
 * - finding the ladder for Bottom cell
 * - getting the top for a botton cell
 * 
 * */
public class Ladders extends HashMap<Cell, Cell> {

	public boolean hasLadderAt(Cell currentCell) {
		return keySet().contains(currentCell);
	}

}
