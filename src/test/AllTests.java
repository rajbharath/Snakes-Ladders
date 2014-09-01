package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BoardBuilderTest.class, BoardTest.class, DieTest.class,
		SnakesRuleTest.class, SnakesTest.class })
public class AllTests {

}
