package dynamicProgramming;

import java.util.*;

// taken from Cracking the Coding Interview, chapter 8

public class DPProblems {
	
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
	
	// Problem 8.3
	private static int findHelper(int[] arr, int first, int last) {
		if (last < first) {
			return -1;
		} else if (last == first && arr[first] != first) {
			return -1;
		}
		
		int mid; int left;
		while (first < last) {
			mid = (first + last) / 2;
			if (arr[mid] == mid) {
				return mid;
			} else if (arr[first] > mid || arr[mid] < first) {
				first = mid + 1;
			} else if (arr[mid] > last || arr[last] < mid) {
				last = mid - 1;
			} else {
				left = findHelper(arr, first, Math.min(mid - 1, arr[mid]));
				if (left != -1) {
					return left;
				}
				return findHelper(arr, Math.max(mid + 1, arr[mid]), last);
			}
		}
		return (first == arr[first] ? first : -1);
	}
	
	public static int findMagicIndex(int[] arr, boolean areDistinct) {
		if (areDistinct) {
			if (arr[0] > 0 || arr[arr.length - 1] < (arr.length - 1)) {
				return -1;
			}
			
			int first = 0;
			int last = arr.length - 1;
			int mid;
			
			while (first < last) {
				mid = (first + last) / 2;
				if (arr[mid] > mid) {
					last = mid - 1;
				} else if (arr[mid] < mid) {
					first = mid + 1;
				} else {
					return mid;
				}
			}
			return (arr[first] == first ? first : -1);
		} else {
			int first = 0;
			int last = arr.length - 1;
			return findHelper(arr, first, last);
		}
	}
	
	// Problem 8.4
	private static List<List<Integer>> helper(int[] arr, List<Integer> set, int currIndex, List<List<Integer>> allSets) {
		if (currIndex == arr.length) {
			allSets.add(new ArrayList<Integer>(set));
		} else {
			set.add(arr[currIndex]);
			helper(arr, set, currIndex + 1, allSets);
			set.remove(set.size() - 1);
			helper(arr, set, currIndex + 1, allSets);
		}
		return allSets;
	}
	
	public static List<List<Integer>> subsets(int[] arr, boolean useRecursion) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (useRecursion) {
			return helper(arr, new ArrayList<Integer>(), 0, ret);
		} else {
			int totalVariations = 1 << arr.length;
			List<Integer> subset; int index;
			for (int i = 0; i < totalVariations; i++) {
				subset = new ArrayList<Integer>();
				index = 0;
				for (int k = i ; k > 0; k >>= 1) {
					if ((k & 1) == 1) {
						subset.add(arr[index]);
					}
					index++;
				}
				ret.add(subset);
			}
			
			return ret;
		}
	}
	
	public static void main(String[] args) {
		// problem 8.3
		int[] arr = new int[] {1, 2, 3, 4};
		List<List<Integer>> subsets = subsets(arr, true);
		System.out.println(subsets.toString());
	}
}
