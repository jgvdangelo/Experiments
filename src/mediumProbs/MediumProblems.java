package mediumProbs;

import java.util.*;

public class MediumProblems {

	private static List<Integer> getPrimes(int x) {
		List<Integer> primes = new ArrayList<Integer>();

		boolean[] isKnownNotPrime = new boolean[x + 1];

		boolean addCurrent = true;
		for (int i = 2; i <= x; i++) {
			addCurrent = true;
			
			if (!isKnownNotPrime[i]) {
					for (int j = 3; j < i; j++) {
							System.out.println("j = " + j + ", i = " + i);
							if (i % j == 0) {
								addCurrent = false;
								break;
							}
						}
					}

			if (addCurrent) {
				primes.add(i); 
				
				int factor = 1;
				
				while (factor * i <= x) {
					isKnownNotPrime[factor * i] = true;
					factor++;
				}
			}
		}

		return primes;
	}
	
	// Problem 16.6
	public static int smallestInt(int[] arr1, int[] arr2) {
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(getPrimes(17));
	}
}
