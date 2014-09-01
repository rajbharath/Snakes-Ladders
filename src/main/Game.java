package main;

import java.util.LinkedList;
import java.util.List;

/*
 * Game class responsibilities are
 * - adding players
 * - removing players
 * - printing the game status
 * - giving turns to players
 * - deciding the game ends or not
 * - it will tell who is winner
 * */
public class Game {
	List<Player> players;
	List<IRule> rules;
	boolean completed;
	private Board board;

	public Game(int boardSize, int snakeCount, int ladderCount) {
		players = new LinkedList<Player>();
		board = new BoardBuilder().build(boardSize, snakeCount, ladderCount);
		rules = new LinkedList<IRule>();
		rules.add(new SnakesRule());
		rules.add(new LadderRule());
		board.displaySnakes();
		board.displayLadders();
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public void start() {
		while (!completed) {
			for (Player player : players) {
				player.play();
				for (IRule rule : rules) {
					rule.isApplicable(player, board);
				}
				printGameStatus();
				if (player.reachedEnd(board)) {
					completed = true;
					break;
				}
			}
		}
	}

	public void printGameStatus() {
		for (Player player : players) {
			System.out.println(player.getName() + "" + player.getPosition());
		}

	}
}
