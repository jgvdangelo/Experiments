package heap;

public interface IHeap {
	public void add(int n);
	public void clear();
	public boolean contains(int n);
	public boolean offer(int n);
	public int peek();
	public int remove();
	public int size();
	public int[] toArray();
}
