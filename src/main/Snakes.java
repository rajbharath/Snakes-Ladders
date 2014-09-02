package main;

import java.util.HashMap;

/*
 * responsible for 
 * - finding the snake for a head
 * - getting the tail for a snake's head
 * 
 * */

public class Snakes extends HashMap<Cell, Cell> {

	public boolean hasSnakeAt(Cell currentCell) {
		return keySet().contains(currentCell);
	}
}
