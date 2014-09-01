package test;

import static org.junit.Assert.*;

import main.Board;
import main.BoardBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BoardBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		BoardBuilder builder = new BoardBuilder();
		Board board = builder.build(10, 10, 10);
		assertEquals(100, board.getMax());
	}

}
