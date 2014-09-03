package test;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import main.Dice;
import main.DiceListener;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.core.AnyOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DieTest {

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
