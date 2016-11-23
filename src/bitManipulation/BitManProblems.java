package bitManipulation;

import java.util.*;

public class BitManProblems {
	
	// Common bit operations, for my own practice
	public static boolean getBit(int num, int i) {
		return ((num >> i) & 1) == 1;
	}
	
	public static int setBit(int num, int i) {
		return (num | (1 << i));
	}
	
	public static int clearBit(int num, int i) {
		return (num & ~(1 << i));
	}
	
	public static int updateBit(int num, int i, boolean bitIs1) {
		return (bitIs1 ? num | (1 << i) : num & ~(1 << i));
	}
	
	public static void swap(int[] nums) {
		nums[0] = nums[1] ^ nums[0];
		nums[1] = nums[0] ^ nums[1];
		nums[0] = nums[0] ^ nums[1];
	}
	
	// Problem 5.1
	public static int insertion(int n, int m, int i, int j) {
		// set all places to be inserted in n to zero
		int length = j - i + 1;
		int mask = ~(((1 << length) - 1) << i);
		n &= mask;
		
		// shift m over
		m <<= i;
		
		// OR N with M
		int output = n | m;
		
		return output;
	}
	
	// Problem 5.3
	public static int flipBitToWin(int n) {
		List<Integer> oneZeros = new LinkedList<Integer>();
		
		int count = 0; int currVal;
		boolean countZeros = true;
		while (n != 0) {
			currVal = n & 1;
			if ((currVal == 0 && countZeros) || (currVal == 1 && !countZeros)) {
				count++;
			} else {
				oneZeros.add(count);
				count = 1;
				countZeros = !countZeros;
			}
			n >>>= 1;
		}
		
		oneZeros.add(count);
		int curr = 0;
		int max = 0;
		int left; int right;
		for (int i = 0; i < oneZeros.size(); i += 2) {
			if (i > 0) {
				left = oneZeros.get(i - 1);
			} else {
				left = 0;
			}
			
			if (i + 1 < oneZeros.size()) {
				right = oneZeros.get(i + 1);
			} else {
				right = 0;
			}
			
			if (oneZeros.get(i) == 1) {
				curr = left + right + 1;
			} else if (oneZeros.get(i) > 1){
				curr = Math.max(left, right) + 1;
			}
			if (curr > max) {
				max = curr;
			}
		}
		
		return max;
	}
	
	// Problem 5.4
	public static void nextNumberWrongSolution(int n) {
		System.out.println("ORIGINAL IS " + Integer.toBinaryString(n));
		int onesCount = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				onesCount++;
			}
			n >>>= 1;
		}
		int minimum = (1 << (onesCount)) - 1;
		System.out.println("MIN IS " + minimum + " OR BINARY " + Integer.toBinaryString(minimum));
		
		int length = 31 - onesCount;
		int maximum = (minimum << length);
		System.out.println("MAX IS " + maximum + " OR BINARY " + Integer.toBinaryString(maximum));
	}
	
	public static void nextNumber(int n) {
		System.out.println("ORIGINAL IS: " + Integer.toBinaryString(n));
		
		// TODO: this is wrong, redo
		
		//// to find next #
		// find first 1
		int findFirst = n ^ (n - 1);
		int oneIndex = -1;
		while (findFirst != 0) {
			oneIndex++;
			findFirst >>= 1;
		}

		// find first 0 after that 1
		int findZero = n >> oneIndex;
		findZero = findZero ^ (n + 1);
		int zeroIndex = oneIndex - 1;
		while (findZero != 0) {
			zeroIndex++;
			findZero >>= 1;
		}
		System.out.println("Zero index is: " + zeroIndex);
		
		// set oneIndex to 0, and zeroIndex to 1
		int nextNum = n;
		nextNum &= ~(1 << oneIndex);
		nextNum |= (1 << zeroIndex);
		System.out.println("NEXT NUM IS: " + Integer.toBinaryString(nextNum));
	}
	
	// Problem 5.6
	public static int conversion(int first, int second) {
		int count = 0;
		int bitOne; int bitTwo;
		while (first != 0 || second != 0) {
			bitOne = first & 1;
			bitTwo = second & 1;
			
			first >>>= 1;
			second >>>= 1;
			
			if ((bitOne ^ bitTwo) == 1)
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {9, 2};
		System.out.println(Arrays.toString(arr));
		swap(arr);
		System.out.println(Arrays.toString(arr));
	}
}
