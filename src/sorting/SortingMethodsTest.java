package sorting;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class SortingMethodsTest {

	@Test
	public void testQuickSort() {
		int[] toSort = new int[] {4, 3, 2, 1};
		SortingMethods.quickSort(toSort);
		assertArrayEquals(new int[] {1, 2, 3, 4}, toSort);
	}

	@Test
	public void testMergeSort() {
		int[] toSort = new int[] {4, 3, 2, 1, 33, 3425, 12};
		int[] output = Arrays.copyOf(toSort, toSort.length);
		Arrays.sort(output);
		int[] compare = SortingMethods.mergeSort(toSort);
		assertArrayEquals(compare, output);
	}

}
