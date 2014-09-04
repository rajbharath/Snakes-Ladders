package test;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Matchers.intThat;
import static org.mockito.Mockito.verify;
import main.Dice;
import main.DiceListener;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DiceTest {

	@Mock
	DiceListener diceListener;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void roll() {
		Dice die = new Dice(diceListener);
		die.roll();

		verify(diceListener).onDiceRolled(
				intThat(anyOf(equalTo(1), equalTo(2), equalTo(3), equalTo(4),
						equalTo(5), equalTo(6))));
	}
}
