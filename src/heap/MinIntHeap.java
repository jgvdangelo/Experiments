package heap;

import java.util.*;

public class MinIntHeap implements IIntHeap {
	private static final float loadFactor = 0.75f;
	
	private int[] heap = new int[16];
	private int currIndex = 0;
	
	private int parent(int index) {
		return (index == 1) ? -1 : index / 2;
	}
	
	private int left(int index) {
		int left = index * 2;
		return (left <= currIndex) ? left : -1;
	}
	
	private int right(int index) {
		int right = (index * 2) + 1;
		return (right <= currIndex) ? right : -1;
	}
	
	private boolean hasChildren(int index) {
		return (left(index) != -1 || right(index) != -1);
	}

	private void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	
	@Override
	public void add(int n) {
		currIndex++;
		heap[currIndex] = n;
		
		int toBubble = currIndex;
		
		while (parent(toBubble) != -1 && heap[parent(toBubble)] > heap[toBubble] ) {
			swap(toBubble, parent(toBubble));
			toBubble = parent(toBubble);
		}
		
		// TODO: check load factor / increase
	}
	
	@Override
	public void clear() {
		Arrays.fill(heap, 0);
		currIndex = 0;
	}
	
	@Override
	public boolean contains(int n) {
		for (int i = 0; i < heap.length; i++) {
			if (heap[i] == n)
				return true;
		}
		return false;
	}
	
	@Override
	public int peek() {
		if (currIndex == 0) {
			throw new NullPointerException();
		} else {
			return heap[currIndex];
		}
	}
	
	@Override
	public int remove() {
		if (currIndex == 0) {
			throw new NullPointerException();
		}
		int ret = heap[1];
		heap[1] = heap[currIndex];
		currIndex--;
		
		int bubbleDown = 1;
		while (hasChildren(bubbleDown) && heap[bubbleDown] > heap[left(bubbleDown)]) {
			int toSwap = left(bubbleDown);
			if (right(bubbleDown) != -1 && heap[right(bubbleDown)] < heap[left(bubbleDown)]) {
				toSwap = right(bubbleDown);
			}
			
			swap(bubbleDown, toSwap);
			bubbleDown = toSwap;
		}
		
		return ret;
	}
	
	@Override
	public int size() {
		return currIndex;
	}
	
	@Override
	public int[] toArray() {
		return Arrays.copyOfRange(heap, 1, currIndex + 1);
	}
}
