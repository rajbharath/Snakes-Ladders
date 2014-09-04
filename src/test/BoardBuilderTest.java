package test;

import static org.junit.Assert.*;

import main.Board;
import main.BoardBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void build() {
		BoardBuilder builder = new BoardBuilder();

		int boardSize = 10;
		int snakeCount = 10;
		int ladderCount = 10;
		assertTrue(builder.build(boardSize, snakeCount, ladderCount) instanceof Board);
	}

}
