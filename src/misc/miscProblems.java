package misc;

import java.util.*;
import java.io.*;

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
	
	public static void main(String[] args) {
		processScheduling("scheduling");
	}
}
