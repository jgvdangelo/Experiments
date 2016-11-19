package bitManipulation;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitManProblemsTest {

	@Test
	public void testGetBit() {
		assertTrue(BitManProblems.getBit(-1, 2));
		assertTrue(BitManProblems.getBit(7, 2));
		assertFalse(BitManProblems.getBit(7, 3));
	}

	@Test
	public void testSetBit() {
		assertEquals(BitManProblems.setBit(2, 2), 6);
		assertEquals(BitManProblems.setBit(1, 4), 17);
		assertEquals(BitManProblems.setBit(-2, 0), -1);
		assertEquals(BitManProblems.setBit(-7, 2), -3);
	}

	@Test
	public void testClearBit() {
		assertEquals(BitManProblems.clearBit(7, 2), 3);
	}

	@Test
	public void testUpdateBit() {
		assertEquals(BitManProblems.updateBit(7, 2, true), 7);
		assertEquals(BitManProblems.updateBit(7, 2, false), 3);
		assertEquals(BitManProblems.updateBit(-7, 31, false), 2147483641);
	}

	@Test
	public void testInsertion() {
		fail("Not yet implemented");
	}

}
