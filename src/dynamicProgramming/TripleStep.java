package dynamicProgramming;

import java.util.Arrays;

// taken from Cracking the Coding Interview, chapter 8

public class TripleStep {
	
	// problem 8.1
	private static int runUpStairsTabMem(int n, int[] arr) {
		int Vim1 = 1;
		int Vim2 = 1;
		int Vim3 = 1;
		int i = 2;
		int V = 2;
		
		while (i != n) {
			Vim3 = Vim2;
			Vim2 = Vim1;
			Vim1 = V;
			i++;
			V = Vim1 + Vim2 + Vim3;
		}
		return V;
	}
	
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
	
	public static int runUpStairs(int n, boolean memo, boolean saveSpace) {
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
			else if (!saveSpace)
				return runUpStairsTab(n, arr);
			else 
				return runUpStairsTabMem(n, arr);
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
	
	private static int robotGridTabMem(int r, int c) {
		int[] vals = new int[c];
		int currIndex = 0;
		int V = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0 && j != 0) {
					V = 1;
				} else if (i != 0 && j == 0) {
					V = 1;
				} else if (i == 0 && j == 0) {
					V = 0;
				} else {
					V = vals[(currIndex - 1 + vals.length) % vals.length] + vals[currIndex];
				}
				vals[currIndex] = V;
				currIndex = (currIndex + 1) % vals.length; 
			}
		}
		return V;
	}
	
	public static int robotGrid(int r, int c, boolean memo, boolean saveSpace) {
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
			else if (!saveSpace) {
				return robotGridTab(r - 1, c - 1, mat);
			} else {
				return robotGridTabMem(r, c);
			}
		}
	}
	
	public static void main(String[] args) {
		// problem 8.2
		System.out.println(robotGrid(5, 5, false, true));
	}
}
