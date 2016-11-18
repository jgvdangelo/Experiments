package sorting;

public class SortingMethods {
	private static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	// Implement quick sort
	private static int partition(int[] arr, int i, int j, int pivot) {
		while (i <= j) {
			while (i <= j && arr[i] < pivot) { i++; };
			while (i <= j && arr[j] > pivot) { j--; };
			
			if (i <= j) {
				swap( arr, i, j);
				i++;
				j--;
			}
			
		}
		return i;
	}
	
	private static void quickSortHelper(int[] arr, int first, int last) {
		if (first >= last) {
			return;
		}
		
		int pivot = first;
		swap(arr, first, last);
		int middle = partition(arr, first, last - 1, arr[last]);
		swap(arr, last, middle);
		
		quickSortHelper(arr, first, middle - 1);
		quickSortHelper(arr, middle + 1, last);
	}
	
	public static void quickSort(int[] arr) { 
		quickSortHelper(arr, 0, arr.length - 1);
	}
	
	public static void mergeSort() {
		// TODO: implement
	}
}
