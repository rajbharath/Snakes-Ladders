package main;

import java.util.LinkedList;
import java.util.List;

/*
 * Game class responsibilities are
 * - adding players
 * - removing players
 * - giving turns to players
 * - deciding the game ends or not
 * */
public class Game implements DiceListener {
	List<Player> players;
	boolean completed;
	private Board board;
	private Dice dice;
	private Player currentPlayer;
	private Player winner;

	public Game(int boardSize, int snakeCount, int ladderCount) {
		players = new LinkedList<Player>();
		dice = new Dice(this);
		board = new BoardBuilder().build(boardSize, snakeCount, ladderCount);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public void start() {
		while (winner == null) {
			for (Player player : players) {
				currentPlayer = player;
				IOUtil.print("Hey! " + player.getName()
						+ " Press Enter to roll the dice");
				IOUtil.read();
				player.play(dice);
				if (board.isFinished(player)) {
					winner = currentPlayer;
					break;
				}
			}
		}
	}

	@Override
	public int onDiceRolled(int diceFace) {
		board.forward(currentPlayer, diceFace);
		return diceFace;
	}
}
