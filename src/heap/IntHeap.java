package heap;

public class IntHeap implements IHeap {
	private static final float loadFactor = 0.75f;
	
	private int[] heap = new int[16];
	
	
	@Override
	public void add(int n) {
		
		
		// TODO: increase with load factor
	}
	
	@Override
	public void clear() {
		
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
	public boolean add(int n) {
		
	}
	
	@Override
	public int peek() {
		
	}
	
	@Override
	public int remove() {
		
	}
	
	@Override
	public int size() {
		
	}
	
	@Override
	public int[] toArray() {
		
	}
}
