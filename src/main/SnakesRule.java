package main;

public class SnakesRule implements IRule {
	/*
	 * Snake Rule is responsible for 
	 * - moving the player to a particular position according to snake position
	 */
	@Override
	public boolean isApplicable(Player player, Board board) {
		int position = player.getPosition();
		if (board.hasSnakeAt(position)) {
			player.moveTo(board.getTail(position));
			return true;
		}
		return false;
	}

}
