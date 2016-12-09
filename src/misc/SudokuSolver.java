package misc;

import java.util.*; 

public class SudokuSolver {
	public boolean sudokuSolver(int[][] mat) {
			TreeMap<Integer, Space> emptySpaces = new TreeMap<Integer, Space>();

			List<Integer> vals;
			for (int i = 0; i < mat.length; i++) {
				 for (int j = 0; j < mat.length; j++) { // guaranteed to be square
						if (mat[i][j] == 0) {
							 vals = availableValues(mat, i, j);
							 if (vals == null) {
									return false;
							 }
							 emptySpaces.put(vals.size(), new Space(i, j, vals));
						}
				 }
			}

			return sudokuSpaceFiller(mat, emptySpaces);
	 }

	 private boolean sudokuSpaceFiller(int[][] mat, TreeMap<Integer, Space> emptySpaces) {
			while (!emptySpaces.isEmpty()) {
				 Space curr = null;
				 if (emptySpaces.firstKey() == 1) {
						while (emptySpaces.firstKey() == 1) {
							 curr = emptySpaces.remove(emptySpaces.firstKey());
							 mat[curr.i][curr.j] = curr.potentialNums.get(0);
						}
						boolean updateable = updateSpaceConstraints(mat, emptySpaces);
						if (!updateable) 
							 return false;
				 } else {
						curr = emptySpaces.remove(emptySpaces.firstKey());

						boolean solvable;
						for (int k : curr.potentialNums) {
							 mat[curr.i][curr.j] = k;
							 TreeMap<Integer,Space> copy = new TreeMap<Integer, Space>(emptySpaces);
							 boolean updateable = updateSpaceConstraints(mat, copy);
							 if (!updateable) 
									return false;
							 solvable = sudokuSpaceFiller(mat, copy);
							 if (solvable) {
									return true;
							 }
						}
						
				 }
			}

			return true;
	 }

	 private boolean updateSpaceConstraints(int[][] mat, TreeMap<Integer, Space> spaces) {
			List<Integer> nums;
			for (Map.Entry<Integer, Space> i : spaces.entrySet()) {
				 nums = availableValues(mat, i.getValue().i, i.getValue().j);
				 if (nums == null)
						return false;
				 i.getValue().potentialNums = nums;
			}
			return true;
	 }

	 // Returns null if no values available for the space
	 private List<Integer> availableValues(int[][] mat, int i, int j) {
			boolean[] vals = new boolean[10];
			// check column
			for (int m = 0; m < mat[i].length; m++) {
				 markValIfFound(mat[i][m], vals);

				 markValIfFound(mat[m][j], vals);
			}

			Space p = getSquareCoordinates(i, j);
			for (int m = 0; m < 3; m++) {
				 for (int n = 0; n < 3; n++) {
						markValIfFound(mat[p.i + m][p.j + n], vals);
				 }
			}

			if (i == j) {
				 for (int m = 0; m < 10; m++) {
						markValIfFound(mat[m][m], vals);
				 }
			} else if (i + j == 9) {
				 for (int m = 0; m < 10; m++) {
						markValIfFound(mat[m][9 - m], vals);
				 }
			}

			List<Integer> ret = new LinkedList<Integer>();
			for (int m = 1; m < vals.length; m++) {
				 if (!vals[m])
						ret.add(m);
			}

			if (ret.size() == 0)
				 return null;
			else 
				 return ret;
	 }

	 private void markValIfFound(int index, boolean[] vals) {
			if (!vals[index])
				 vals[index] = true;
	 }

	 private Space getSquareCoordinates(int i, int j) {
			return new Space((i / 3) * 3, (j / 3) * 3, null);
	 }

	 private class Space {
			int i; int j; 
			List<Integer> potentialNums;

			public Space(int i, int j, List<Integer> vals) {
				 this.i = i;
				 this.j = j;
				 this.potentialNums = vals;
			}
	 }
}
