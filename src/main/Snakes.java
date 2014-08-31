package main;

import java.util.HashMap;

public class Snakes extends HashMap<Integer, Integer> {
	public boolean isSnakePresent(Integer position) {
		return keySet().contains(position);
	}

	public int getTail(Integer head) {
		return get(head);
	}
	
	public void display(){
		for (Integer head : keySet()) {
			System.out.println(head + " - " + getTail(head));
		}
	}
}
