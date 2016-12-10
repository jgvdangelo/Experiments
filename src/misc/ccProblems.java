package misc;

import java.awt.*;
import java.util.Arrays;
import java.util.Queue;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class ccProblems {
	// Problem: taken from here https://careercup.com/question?id=5725166060437504
	public int maxLineFinder(List<Point> points) {
		if (points.size() == 1)
			return 1;

		Map<Line, List<Point>> lines = new HashMap<Line, List<Point>>();

		List<Point> linePoints;
		Line l;
		for (int i = 0; i < points.size() - 1; i++) {
			for (int j = i + 1; j < points.size(); j++) {
				l = getLine(points.get(i), points.get(j));
				if (!lines.containsKey(l)) {
					linePoints = new LinkedList<Point>();
					linePoints.add(points.get(i));
					linePoints.add(points.get(j));
					lines.put(l, linePoints);
				} else {
					lines.get(l).add(points.get(i));
					lines.get(l).add(points.get(j));
				}
			}
		}

		int max = 0;
		for (Map.Entry<Line, List<Point>> pair : lines.entrySet()) {
			if (pair.getValue().size() > max) {
				max = pair.getValue().size();
			}
		}

		return max;
	}
	
	private static Line getLine(Point p1, Point p2) {
		double slope = (p1.y - p2.y) / (p1.x - p2.x);
		double yint = p1.y - p2.x * slope;
		return new Line(slope, yint);
	}

	public static class Line {
		double slope;
		double yint;

		public Line(double slope, double yint) {
			this.slope = slope;
			this.yint = yint;
		}
	}
	
	// Problem https://careercup.com/question?id=5711620404674560
	public static int maxNumFromStacks(List<Stack<Integer>> stacks, int m) {
		// TODO: implement memoization
		return maxStacksHelper(stacks, m, 0);
	}

	private static int maxStacksHelper(List<Stack<Integer>> stacks, int m, int sumSoFar) {
		if (m <= 0) {
			return sumSoFar;
		} else {
			int max = sumSoFar;
			int curr = 0;
			int removed;
			for (int i = 0; i < stacks.size(); i++) {
				if (stacks.get(i).size() > 0) {
					removed = stacks.get(i).pop();
					curr = maxStacksHelper(stacks, m - 1, sumSoFar + removed);
					stacks.get(i).push(removed);
					if (curr > max) {
						max = curr;
					}
				}
			}
			return max;
		}
	}
	
	// Problem 
	public static int arrangeBoxes(int[] ballPositions) {
		Set<Integer> ballsSet = new HashSet<Integer>(Arrays.asList(ballPositions));
		Map<Integer, Range> ranges = new HashMap<Integer, Range>();
		Range r; 
		for (int i : ballPositions) {  
			r = calculateMaxBallRange(i, ballsSet);
			ranges.put(i, r);
		}

		// loop over all ranges + find the range with largest ballNums
		// swap all other balls NOT in that range into that range
		Range maxBalls;
		for (Range s : ranges.values()) {	
			if (maxBalls == null) 
				maxBalls = s;
			else if (s.ballNums > maxBalls.ballNums) {
				maxBalls = s;
			}
		}

		Set<Integer> ballsInPlace = new HashSet<Integer>(); 
		Queue<Integer> ballsToPlace = new LinkedList<Integer>();
		for (int i : ballPositions) {
			if (i <= maxBalls.max && i >= maxBalls.min) {
				ballsInPlace.add(i);
			} else {
				ballsToPlace.add(i);
			}
		}

		return ballsToPlace.size();
	}

	private static Range calculateMaxBallRange(int mid, Set<Integer> ballPositions) {
		boolean[] arr = new boolean[ballPositions.size() * 2 - 1];
		// mini arr, shifted to the left by i_new = i_old - (mid - ballPositions.length - 1)
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ballPositions.contains(i + (mid - ballPositions.size() - 1));
		}

		Range max = new Range();
		int maxNum = 0;
		for (int i = 0; i < ballPositions.size(); i++) {
			if (arr[i])
				maxNum++;
		}
		max.ballNums = maxNum;
		max.min = 0;
		max.max = max.min + n - 1;

		for (int i = 1; i < arr.length - n; i++) {
			if (arr(i))
				maxNum++;
			else
				maxNum--;
			if (maxNum > max.ballNums) {
				max.ballNums = maxNum;
				max.min = i;
				max.max = max.min + n - 1;
			}
		}

		return max;
	}

	public static class Range  {
		int min; int max;  // max - min <= N
		int ballNums;
	}
}
