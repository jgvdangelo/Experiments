package mediumProbs;

import java.util.*;

public class MediumProblems {

	private static List<Integer> getPrimes(int x) {
		List<Integer> primes = new ArrayList<Integer>();

		boolean[] isKnownNotPrime = new boolean[x + 1];

		boolean addCurrent = true;
		for (int i = 2; i <= x; i++) {
			addCurrent = true;
			
			if (!isKnownNotPrime[i]) {
					for (int j = 3; j < i; j++) {
							System.out.println("j = " + j + ", i = " + i);
							if (i % j == 0) {
								addCurrent = false;
								break;
							}
						}
					}

			if (addCurrent) {
				primes.add(i); 
				
				int factor = 1;
				
				while (factor * i <= x) {
					isKnownNotPrime[factor * i] = true;
					factor++;
				}
			}
		}

		return primes;
	}
	
	// Problem 16.4: Validating a game of tic-tac-toe
	public static boolean ticTacToe(int[][] game) {
		// 1 = X, 2 = O, and 0 = blank in game matrix
		// in cols/rows/dags, -1 = no possible way to win in that permute
		int[] cols = new int[game[0].length];
		int[] rows = new int[game.length];
		int[] diags = new int[2];
		
		int val;
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[0].length; j++) {
				val = game[i][j];
				if (val == 0) {
					cols[j] = -1;
					rows[i] = -1;
					if (i == j) {
						diags[0] = -1;
					} else if (i == game.length - 1 - j) { // TODO: double check this
						diags[1] = -1;
					}
				} else {
					if (i == 0) {
						cols[j] = val;
					} else {
						if (cols[j] != val) {
							cols[j] = -1;
						}
					}
					if (j == 0) {
						rows[i] = 1;
					} else {
						if (rows[i] != val) {
							rows[i] = -1;
						}
					}
					if (i == 0 && j == 0) {
						diags[0] = val;
					} else if (i == 0 && j == 2) {
						diags[1] = val;
					} else if (i == j ) {
						if (diags[0] != val)
							diags[0] = -1;
					} else if (i == game.length - 1 - j) {
						if (diags[1] != val)
							diags[1] = -1;
					}
				}
			}
		}
		
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] != -1) 
				return true;
			if (cols[i] != -1)
				return true;
		}

		for (int i = 0; i < diags.length; i++) {
			if (diags[i] != -1)
				return true;
		}

		return false;
	}
	
	// Problem 16.6
	public static int smallestInt(int[] arr1, int[] arr2) {
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(getPrimes(17));
	}
}
