package dynamicProgramming;

import java.util.*;
import java.awt.Point;

public class MiscDPProblems {
	// Problem: given a grid, print out all the paths to the top right
	public static void travelRecBottomUp(int x, int y, int cx, int cy, List<String> path) {
		if (cx == x && cy == y) {
			for (String str : path) {
				System.out.print(str + " ");
			}
			System.out.println();
			return;
		}

		if (cy < y) {
			path.add("N");
			travelRecBottomUp(x, y, cx, cy + 1, path);
			path.remove(path.size() - 1);
		}
		if (cx < x) {
			path.add("E");
			travelRecBottomUp(x, y, cx + 1, cy, path);
			path.remove(path.size() - 1);
		}
		if (cy < y && cx < x) {
			path.add("NE");
			travelRecBottomUp(x, y, cx + 1, cy + 1, path);
			path.remove(path.size() - 1);
		}
	}
	
	public static List<List<String>> travelRecTopDown(int x, int y) {
		if (x == 0 && y == 0) {
			return new ArrayList<List<String>>();
		}

		List<List<String>> pathEast = null;
		if (x > 0) {
			pathEast = travelRecTopDown(x - 1, y);
			processPathsList(pathEast, "E");
		}

		List<List<String>> pathNorth = null;
		if (y > 0) {
			pathNorth = travelRecTopDown(x, y - 1);
			processPathsList(pathNorth, "N");
		}

		List<List<String>> pathNorthEast = null;
		if (y > 0 && x > 0) {
			pathNorthEast = travelRecTopDown(x - 1, y - 1);
			processPathsList(pathNorthEast, "NE");
		}

		List<List<String>> ret = new ArrayList<List<String>>();
		addAllIfNotNull(ret, pathEast);
		addAllIfNotNull(ret, pathNorth);
		addAllIfNotNull(ret, pathNorthEast);

		return ret;
	}

	private static void addAllIfNotNull(List<List<String>> ret, List<List<String>> toAdd) {
		if (toAdd != null) {
			ret.addAll(toAdd);
		}
	}

	private static void processPathsList(List<List<String>> paths, String direction) {
		if (paths.isEmpty()) {
			List<String> path = new ArrayList<String>();
			path.add(direction);
			paths.add(path);
		} else {
			for (int i = 0; i < paths.size(); i++) {
				paths.get(i).add(direction);
			}
		}
	}
	
	public static void travelMemo(int x, int y, Map<Point, List<String>> paths, List<String> cPath) {
		// TODO: finish
		if (x == 0 && y == 0) {
			for (String str : cPath) {
				System.out.print(str + " ");
			}
			System.out.println();
			return;
		} 
	}

	public static void travel(int x, int y) {
		travelRecBottomUp(x, y, 0, 0, new ArrayList<String>());
		System.out.println();
		List<List<String>> paths = travelRecTopDown(x, y);
		for (List<String> list : paths) {
			for (String str : list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
		// Map<Point, List<String>> paths = new HashMap<Point, List<String>>();
		// travelMemo(x, y, paths, new ArrayList<String>());
	}
	
	public static void main(String[] args) {
		travel(2, 2);
	}
}
