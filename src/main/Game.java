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
public class Game implements DieListener {
	List<Player> players;
	boolean completed;
	private Board board;
	private Die die;
	private Player currentPlayer;

	public Game(int boardSize, int snakeCount, int ladderCount) {
		players = new LinkedList<Player>();
		die = new Die();
		// board = new BoardBuilder().build(boardSize, snakeCount, ladderCount);
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
				currentPlayer = player;
				player.play(die);
				if (player.reachedEnd(board)) {
					completed = true;
					break;
				}
			}
		}
	}

	public void getStatus() {
		for (Player player : players) {
			// System.out.println(player.getName() + "" + player.getPosition());
		}

	}

	@Override
	public int onDieRolled(int dieFace) {
		board.forward(currentPlayer, dieFace);
		return dieFace;
	}
}
