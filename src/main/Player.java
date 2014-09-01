package main;
/*
 * Player is responsible for
 * - storing the player info such as name and position
 * - manipulating the position according the die value
 * - moving to the position according the rule applied
 * - playing the game by rolling the die
 * */
public class Player {
	String name;
	int position;

	public Player(String string) {
		name = string;
	}

	public int play() {
		int stepsToMoveAhead = Die.roll();
		System.out.println(name + "-"+stepsToMoveAhead);
		moveAhead(stepsToMoveAhead);
		return position;
	}

	private void moveAhead(int stepsToMoveAhead) {
		position = position + stepsToMoveAhead;
	}

	public int getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	public boolean reachedEnd(Board board) {
		return getPosition() >= board.getMax();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void moveTo(int tail) {
		// TODO Auto-generated method stub
		position=tail;
	}
}
