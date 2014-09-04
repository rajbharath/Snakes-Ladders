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
				IOUtil.print(board.getPlayerPlacements().toString());
				IOUtil.print("Hey! " + player.getName()
						+ " Press Enter to roll the dice");
				IOUtil.read();
				player.play(dice);

				if (board.isFinished(player)) {
					winner = currentPlayer;
					IOUtil.println(winner.getName() + " is the winner");
					break;
				}
			}
		}
	}

	@Override
	public void onDiceRolled(int diceFace) {
		board.forward(currentPlayer, diceFace);
	}
}
