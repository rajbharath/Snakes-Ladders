package test;

import static org.junit.Assert.*;

import main.Snakes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SnakesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Snakes snakes = new Snakes();
		snakes.put(55, 10);
		snakes.put(60, 12);
		assertEquals(10, snakes.getTail(55));
		assertEquals(12, snakes.getTail(60));
		
		assertTrue(snakes.isSnakePresent(55));
		assertFalse(snakes.isSnakePresent(5));
	}

}
