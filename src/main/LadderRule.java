package main;
/*
 * LadderRule is responsible for
 * - applying the rule of game with respect to a ladder
 * - it will move the player from bottom to top
 * */
public class LadderRule implements IRule {

	@Override
	public boolean isApplicable(Player player, Board board) {
		int position = player.getPosition();
		if (board.hasLadderAt(position)) {
			player.moveTo(board.getTop(position));
			return true;
		}
		return false;
	}

}
