package main;

import java.util.HashMap;

/*
 * Snake class is responsible for
 * - holding the snakes mapping
 * - finding a position has snake head or not
 * - getting position of the tail of a snake's head
 * - displaying all the snakes
 * */
public class Snakes extends HashMap<Integer, Integer> {
	public boolean isSnakePresent(Integer position) {
		return keySet().contains(position);
	}

	public int getTail(Integer head) {
		return get(head);
	}

	public void display() {
		for (Integer head : keySet()) {
			System.out.println(head + " - " + getTail(head));
		}
	}
}
