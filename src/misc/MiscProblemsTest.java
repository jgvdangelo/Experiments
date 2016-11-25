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
	
	@Test
	public void testTicTaceToe() {
		int[][] game1 = new int[3][];
		game1[0] = new int[] {1, 0, 2};
		game1[1] = new int[] {1, 1, 2};
		game1[2] = new int[] {1, 0, 2};
		assertTrue(MiscProblems.ticTacToe(game1));
		int[][] game2 = new int[3][];
		game2[0] = new int[] {1, 0, 2};
		game2[1] = new int[] {2, 1, 2};
		game2[2] = new int[] {1, 0, 1};
		assertTrue(MiscProblems.ticTacToe(game2));
		game2[2] = new int[] {1, 0, 0};
		assertFalse(MiscProblems.ticTacToe(game2));
	}
}
