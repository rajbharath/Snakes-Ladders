package test;

import static org.junit.Assert.*;

import main.Ladder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LadderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getDestination() {
		int start = 2;
		int end = 98;
		Ladder ladder = new Ladder(start, end);
		assertEquals(end, ladder.getDestination(start));
		assertEquals(15, ladder.getDestination(15));
	}

}
