package heap;

import java.util.*;

public class HeapTesting {

	public static void main(String[] args) {
		IIntHeap heap = new MinIntHeap();
		
		int[] toAdd = new int[] {9, 8, 17, 15, 12, 1, -1, -5, 99};
		for (int i : toAdd) {
			heap.add(i);
			System.out.println(Arrays.toString(heap.toArray()));
		}
		
		for (int i : toAdd) {
			System.out.println("REMOVED: " + heap.remove());
			System.out.println(Arrays.toString(heap.toArray()));
		}
	}
}
