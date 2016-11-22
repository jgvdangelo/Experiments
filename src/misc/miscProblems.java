package misc;

import java.util.*;
import java.util.List;
import java.io.*;
import java.awt.*;

public class MiscProblems {
	// Problem to find max memory being used when multiple tasks are scheduled
	public static void processScheduling(String file) {
		Scanner scan;
		try {
			scan = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		int lines = scan.nextInt();
		int start; int end; int weight; int currWeight;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < lines; i++) {
			currWeight = 0;
			start = scan.nextInt();
			end = scan.nextInt();
			weight = scan.nextInt();
			if (map.containsKey(start)) {
				currWeight = map.get(start);
			}
			map.put(start, currWeight + weight);
			currWeight = 0;
			if (map.containsKey(end)) {
				currWeight = map.get(end);
			}
			map.put(end, currWeight - weight);
		}
		scan.close();
		int max = 0; int curr = 0;
		for (Integer key : map.keySet()) {
			curr += map.get(key);
			if (curr > max) {
				max = curr;
			}
		}
		System.out.println(map.toString());
		System.out.println(max);
	}
	
	// Problem to label each space in a museum with a distance from the guard
	public static void processMuseumGuard(String file) {
		Scanner scan;
		try {
			scan = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		int rows = scan.nextInt();
		int columns = scan.nextInt();
		int[][] mat = new int[rows][]; 
		
		for (int i = 0; i < mat.length; i++) {
			mat[i] = new int[columns];
			Arrays.fill(mat[i], -2);
		}
		
		Queue<Point> toProcess = new LinkedList<Point>();
		String[] toParse;
		int type; int row; int column;
		scan.nextLine();
		while (scan.hasNext()) {
			toParse = scan.nextLine().split(" ");
			type = Integer.parseInt(toParse[0]);
			row = Integer.parseInt(toParse[1]);
			column = Integer.parseInt(toParse[2]);
			
			if (type == 0) {
				mat[row][column] = 0;
				toProcess.add(new Point(row, column));
			} else {
				mat[row][column] = -1;
			}
		}
		
		scan.close();
		
		Point p; int adjMove; Point adj;
		while (!toProcess.isEmpty()) {
			p = toProcess.remove();
			
			adjMove = mat[p.x][p.y] + 1;
			
			List<Point> adjacent = new LinkedList<Point>();
			adjacent.add(new Point(p.x, p.y - 1));
			adjacent.add(new Point(p.x, p.y + 1));
			adjacent.add(new Point(p.x + 1, p.y));
			adjacent.add(new Point(p.x - 1, p.y));
			
			for (int i = 0; i < adjacent.size(); i++) {
				adj = adjacent.get(i);
				if (adj.x >= 0 && adj.y >= 0 
						&& adj.x < mat.length && adj.y < mat[0].length
						&& (mat[adj.x][adj.y] > adjMove 
								|| mat[adj.x][adj.y] == -2)) {
					mat[adj.x][adj.y] = adjMove;
					toProcess.add(adj);
				}
			}
		}
		
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	
	// Problem: giving the minimum change for a price
	public static int[] minimumChange(int price, int[] denominations) {
		int[] change = new int[denominations.length];
		
		int currIndex = denominations.length - 1;
		while (price != 0 && currIndex >= 0) {
			change[currIndex] = price / denominations[currIndex];
			price = price % denominations[currIndex];
			currIndex--;
		}
		
		return change; 
	}
	
	// Problem: Modify the array by moving all the zeros to the end (right side).
	private static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	private static int findNextNonZeroIndex(int[] arr, int currIndex) {
		boolean nonZeroFound = false;
		while (currIndex >= 0 && !nonZeroFound) {
			if (arr[currIndex] != 0) {
				nonZeroFound = true;
			} else {
				currIndex--;
			}
		}
		
		return currIndex;
	}
	
	private static int findNextZeroIndex(int[] arr, int currIndex) {
		boolean zeroFound = false;
		while (currIndex < arr.length && !zeroFound) {
			if (arr[currIndex] == 0) {
				zeroFound = true;
			} else {
				currIndex++;
			}
		}
		
		return currIndex;
	}
	
	public static int[] moveZeros(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		} 
		
		int nonZeroIndex = findNextNonZeroIndex(arr, arr.length - 1);
		int zeroIndex = findNextZeroIndex(arr, 0);
		if (nonZeroIndex == -1 || zeroIndex == arr.length || zeroIndex > nonZeroIndex) {
			// passed an array of either all zeros or non-zeros, or sorted
			return arr;
		}
		
		while (zeroIndex < nonZeroIndex) {
			swap(arr, zeroIndex, nonZeroIndex);
			zeroIndex = findNextZeroIndex(arr, zeroIndex);
			nonZeroIndex = findNextNonZeroIndex(arr, nonZeroIndex);
		}
		
		return arr;
	}
	
	// Problem to find the next permutation of an integer
	public static int nextPermute(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		
		int[] counts = new int[10];
		
		int prevDigit = n % 10;
		counts[prevDigit]++;
		n /= 10;
		int currDigit = n % 10;
		n /= 10;
		while (n != 0 && currDigit >= prevDigit) {
			prevDigit = currDigit;
			counts[prevDigit]++;
			currDigit = n % 10;
			n /= 10;
		}
		
		if (currDigit >= prevDigit) {
			throw new IllegalArgumentException();
		}
		
		counts[currDigit]++;
		
		int nextUp = -1;
		boolean found = false;
		int i = currDigit + 1;
		while (i < counts.length && !found) {
			if (counts[i] != 0) {
				nextUp = i;
				found = true;
			}
			i++;
		}
		
		counts[nextUp]--;
		n = n * 10 + nextUp;
		
		for (i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				n = n * 10 + i;
			}
		}
		
		return n;
	}
	
	public static void main(String[] args) {
		processScheduling("scheduling");
		processMuseumGuard("museumGuard");
		System.out.println(Arrays.toString(minimumChange(69, new int[] {1, 5, 10, 25})));
		int n = 10111;
		System.out.println("Original: " + n + ", Modified: " + nextPermute(n));
	}
}
