package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import main.Board;
import main.Cell;
import main.Player;
import main.PlayersPlacements;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BoardTest {

	@Mock
	private PlayersPlacements playersPlacements;

	private int diceFace = 5;

	@Mock
	private Player currentPlayer;

	@Mock
	private Cell cell;

	@Mock
	private Cell destinationCell;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void forward() {
		Cell[][] cells = new Cell[10][10];
		Board board = new Board(cells);

		Board spyBoard = spy(board);
		doReturn(destinationCell).when(spyBoard).getCellAt(diceFace);
		when(destinationCell.getPosition()).thenReturn(diceFace);
		when(playersPlacements.get(currentPlayer)).thenReturn(destinationCell);

		spyBoard.forward(currentPlayer, diceFace);
		verify(spyBoard).forward(currentPlayer, diceFace);
		assertEquals(destinationCell,
				spyBoard.getPlayerPlacements().get(currentPlayer));
	}

}
