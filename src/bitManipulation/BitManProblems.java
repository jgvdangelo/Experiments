package bitManipulation;

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
	
	public static void main(String[] args) {
		int u = insertion(-100000000, 15, 3, 6);
	}
}
