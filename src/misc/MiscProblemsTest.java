package misc;

import static org.junit.Assert.*;

import org.junit.Test;

public class MiscProblemsTest {

	@Test
	public void testMoveZeros() {
		int[] allZeros = new int[] {0, 0, 0, 0};
		int[] allOnes = new int[] {1, 1, 1, 1};
		int[] sorted = new int[] {1, 1, 1, 1, 0, 0, 0};
		
		assertArrayEquals(MiscProblems.moveZeros(allZeros), allZeros);
		assertArrayEquals(MiscProblems.moveZeros(allOnes), allOnes);
		assertArrayEquals(MiscProblems.moveZeros(sorted), sorted);
		
		int [] test1 = new int[] {0, 1, 2, 3};
		int [] test2 = new int[] {1, 0, 2, 3};
		int [] test3 = new int[] {1, 0, 2, 0};
		
		assertArrayEquals(MiscProblems.moveZeros(test1), new int[] {3, 1, 2, 0});
		assertArrayEquals(MiscProblems.moveZeros(test2), new int[] {1, 3, 2, 0});
		assertArrayEquals(MiscProblems.moveZeros(test3), new int[] {1, 2, 0, 0});
	}

}
