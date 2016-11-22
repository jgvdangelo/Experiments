package sorting;

import java.util.*;

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
	
	// Implement Merge sort
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] ret = new int[arr1.length + arr2.length];
		int ind1 = 0;
		int ind2 = 0;
		int retInd = 0;
		
		while (ind1 < arr1.length && ind2 < arr2.length) {
			if (arr1[ind1] > arr2[ind2]) {
				ret[retInd] = arr2[ind2];
				ind2++;
			} else { // if (arr1[ind1] <= arr2[ind2])
				ret[retInd] = arr1[ind1];
				ind1++;
			}
			retInd++;
		}
		
		while (ind1 < arr1.length) {
			ret[retInd] = arr1[ind1];
			retInd++; ind1++;
		}
		
		while (ind2 < arr2.length) {
			ret[retInd] = arr2[ind2];
			retInd++; ind2++;			
		}
		
		return ret;
	}
	
	public static int[] mergeSort(int[] arr) {
		if (arr.length == 1) {
			return arr;
		}
		
		int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
		int[] arr2 = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
		
		return merge(arr1, arr2);
	}
}
