//package main;
//
//import java.util.Random;
///*
// * BoardBuilder is responsible for
// * - building a board
// * - inside it has to setup the snakes
// * - inside it has to setup the ladders
// * */
//public class BoardBuilder {
//	int maximumPosition;
//	Random random = new Random();
//	private Snakes snakes;
//	private Ladders ladders;
//
//	public Board build(int boardSize, int snakeCount, int ladderCount) {
//		maximumPosition = boardSize * boardSize;
//		snakes = setUpSnakes(snakeCount);
//		Ladders ladders = setUpLadders(ladderCount);
//		Board board = new Board(boardSize, snakes, ladders);
//		return board;
//	}
//
//	private Snakes setUpSnakes(int snakeCount) {
//		Snakes snakes = new Snakes();
//		int snakesAdded = 0;
//		while (snakesAdded < snakeCount) {
//			int head = random.nextInt(maximumPosition) + 1;
//			if (snakes.keySet().contains(head))
//				continue;
//			int tail = random.nextInt(head) + 1;
//			snakes.put(head, tail);
//			snakesAdded = snakes.keySet().size();
//		}
//		return snakes;
//	}
//
//	private Ladders setUpLadders(int ladderCount) {
//		ladders = new Ladders();
//		int laddersAdded = 0;
//		while (laddersAdded < ladderCount) {
//			int top = random.nextInt(maximumPosition) + 1;
//			if (snakes.keySet().contains(top) || snakes.values().contains(top))
//				continue;
//			int bottom = random.nextInt(top) + 1;
//			if (snakes.keySet().contains(top) || snakes.values().contains(top)
//					|| ladders.keySet().contains(bottom))
//				continue;
//			ladders.put(bottom, top);
//			laddersAdded = ladders.keySet().size();
//		}
//		return ladders;
//	}
//}