package trees;

import java.util.List;

public interface IBinaryTree {
	public void add(int n);
	public void clear();
	public boolean contains(int n);
	public int peek();
	public int remove(int n);
	public int size();
	public int[] toArray();
}
