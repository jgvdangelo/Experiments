package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class DPProblemsTest {

	// Problem 8.1
	@Test
	public void testRunUpStairs() {
		assertEquals(DPProblems.runUpStairs(11, false, true),504);
		assertEquals(DPProblems.runUpStairs(11, false, false),504);
		assertEquals(DPProblems.runUpStairs(11, true, true),504);
	}

	// Problem 8.2
	@Test
	public void testRobotGrid() {
		assertEquals(DPProblems.robotGrid(5, 5, false, true),70);
		assertEquals(DPProblems.robotGrid(5, 5, false, false),70);
		assertEquals(DPProblems.robotGrid(5, 5, true, false),70);
	}
	
	// Problem 8.3
	@Test
	public void testMagicIndex() {
		assertEquals(DPProblems.findMagicIndex(new int[] {-5}, true), -1);
		assertEquals(DPProblems.findMagicIndex(new int[] {-5, -1}, true), -1);
		assertEquals(DPProblems.findMagicIndex(new int[] {-5, 1}, true), 1);
		assertEquals(DPProblems.findMagicIndex(new int[] {0, 1}, true), 0);
	}
}
