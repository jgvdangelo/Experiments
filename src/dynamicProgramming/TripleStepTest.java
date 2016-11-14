package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class TripleStepTest {

	// Problem 8.1
	@Test
	public void testRunUpStairs() {
		assertEquals(TripleStep.runUpStairs(11, false, true),504);
		assertEquals(TripleStep.runUpStairs(11, false, false),504);
		assertEquals(TripleStep.runUpStairs(11, true, true),504);
	}

	// Problem 8.2
	@Test
	public void testRobotGrid() {
		assertEquals(TripleStep.robotGrid(5, 5, false, true),70);
		assertEquals(TripleStep.robotGrid(5, 5, false, false),70);
		assertEquals(TripleStep.robotGrid(5, 5, true, false),70);
	}

}
