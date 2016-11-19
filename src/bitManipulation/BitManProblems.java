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
		
		
		System.out.println(oneZeros);
		
		return max;
	}
	
	public static void main(String[] args) {
		int num = -3;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(flipBitToWin(num));
	}
}
