package sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortingMethodsTest {

	@Test
	public void testQuickSort() {
		int[] toSort = new int[] {4, 3, 2, 1};
		SortingMethods.quickSort(toSort);
		assertArrayEquals(new int[] {1, 2, 3, 4}, toSort);
	}

	@Test
	public void testMergeSort() {
		fail("Not yet implemented");
	}

}
