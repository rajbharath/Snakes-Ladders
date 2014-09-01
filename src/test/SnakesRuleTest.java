package test;

import static org.junit.Assert.*;

import main.Board;
import main.Player;
import main.SnakesRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SnakesRuleTest {
	@Mock
	private Player player;
	@Mock
	private Board board;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		Mockito.when(player.getPosition()).thenReturn(50);
		Mockito.when(board.hasSnakeAt(50)).thenReturn(true);
		Mockito.when(board.getTail(50)).thenReturn(3);

		SnakesRule snakesRule = new SnakesRule();
		assertTrue(snakesRule.isApplicable(player, board));

		verify(player).getPosition();
		verify(player).moveTo(3);
	}
}
