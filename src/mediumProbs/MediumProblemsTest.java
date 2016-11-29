package mediumProbs;

import static org.junit.Assert.*;
import misc.MiscProblems;

import org.junit.Test;

public class MediumProblemsTest {

	@Test
	public void testTicTaceToe() {
		int[][] game1 = new int[3][];
		game1[0] = new int[] {1, 0, 2};
		game1[1] = new int[] {1, 1, 2};
		game1[2] = new int[] {1, 0, 2};
		assertTrue(MediumProblems.ticTacToe(game1));
		int[][] game2 = new int[3][];
		game2[0] = new int[] {1, 0, 2};
		game2[1] = new int[] {2, 1, 2};
		game2[2] = new int[] {1, 0, 1};
		assertTrue(MediumProblems.ticTacToe(game2));
		game2[2] = new int[] {1, 0, 0};
		assertFalse(MediumProblems.ticTacToe(game2));
	}

}
