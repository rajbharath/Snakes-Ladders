package main;

import java.util.HashMap;

public class Snakes extends HashMap<Cell, Cell> {
	public boolean isSnakePresent(Cell cell) {
		return keySet().contains(cell);
	}

	public int getTail(Cell cell) {
		return get(cell).getPosition();
	}
}
