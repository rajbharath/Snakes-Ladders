package test;

import static org.junit.Assert.fail;

import main.Snake;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class SnakeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getDestination() {
		int head=20;
		int tail = 10;
		Snake snake = new Snake(head, tail);
		Assert.assertEquals(tail, snake.getDestination(head));
		Assert.assertEquals(tail, snake.getDestination(tail));
		Assert.assertEquals(15, snake.getDestination(15));

	}

}
