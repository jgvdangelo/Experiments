package dynamicProgramming;

import java.util.Arrays;

// taken from Cracking the Coding Interview, chapter 8

public class TripleStep {
	
	// problem 8.1
	private static int runUpStairsTab(int n, int[] arr) {
		for (int i = 3; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
		}
		return arr[n];
	}
	
	private static int runUpStairsMemo(int n, int[] arr) {
		if (arr[n] != -1) {
			return arr[n];
		} else {
			int value = runUpStairsMemo(n - 3, arr) + runUpStairsMemo(n - 2, arr) + runUpStairsMemo(n - 1, arr);
			arr[n] = value;
			return value;
		}
	}
	
	private static int runUpStairs(int n, boolean memo) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {	
			int[] arr = new int[n + 1];
			Arrays.fill(arr, -1);
			arr[0] = 1;
			arr[1] = 1;
			arr[2] = 2;
			
			if (memo)
				return runUpStairsMemo(n, arr);
			else
				return runUpStairsTab(n, arr);
		}
	}
	
	// problem 8.2
	private static int robotGridMemo(int r, int c, int[][] mat) {
		if (mat[r][c] != -1) {
			return mat[r][c];
		} else {
			int val = 0;
			if (c > 0)
				val += robotGridMemo(r, c - 1, mat);
			if (r > 0) 
				val += robotGridMemo(r - 1, c, mat);
			mat[r][c] = val;
			return val;
		}
	}
	
	private static int robotGridTab(int r, int c, int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (j != 0 || i != 0) {
					if (j == 0)
						mat[i][j] = 1;
					else if (i == 0) {
						mat[i][j] = 1;
					} else {
						mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
					}
				}
			}
		}
		return mat[r][c];
	}
	
	public static int robotGrid(int r, int c, boolean memo) {
		// start off with just an RxC grid (r = rows, c = columns)
		if (r == 0 || c == 0) 
			return 0;
		else if (r == 1 || c == 1) {
			return 1;
		} else {
			int[][] mat = new int[r][];
			for (int i = 0; i < mat.length; i++) {
				mat[i] = new int[c];
				Arrays.fill(mat[i], -1);
			}
			mat[0][0] = 0;
			mat[0][1] = 1;
			mat[1][0] = 1;
			
			if (memo)
				return robotGridMemo(r - 1, c - 1, mat);
			else
				return robotGridTab(r - 1, c - 1, mat);
		}
	}
	
	public static void main(String[] args) {
		// problem 8.1
		// System.out.println(runUpStairs(5, false));
		
		// problem 8.2
		System.out.println(robotGrid(5, 5, false));
	}
}
