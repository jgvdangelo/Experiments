package misc;

import java.util.*;
import java.util.List;
import java.io.*;
import java.awt.*;

public class miscProblems {
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
	
	public static void main(String[] args) {
		processScheduling("scheduling");
		processMuseumGuard("museumGuard");
	}
}
