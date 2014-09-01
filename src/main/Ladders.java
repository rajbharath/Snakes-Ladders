package main;

import java.util.HashMap;
/*
 * Ladders is responsible for
 * - holding all the ladder
 * - will give Top for a Bottom of ladder
 * - display all the ladders
 * */
public class Ladders extends HashMap<Integer, Integer> {

	public boolean isLadderPresent(int position) {
		return keySet().contains(position);
	}

	public int getTop(int bottom) {
		return get(bottom);
	}

	public void display() {
		for (Integer bottom : keySet()) {
			System.out.println(bottom + " - " + getTop(bottom));
		}
	}
}
