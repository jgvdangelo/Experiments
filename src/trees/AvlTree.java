package trees;

public class AvlTree implements IBinaryTree {
	Node root;
	int size = 0;
	
	@Override
	public void add(int data) {
		// TODO: check if it contains, and throw if so
		if (root == null) {
			root = new Node(data);
		} else {
			Node toInsert = findInsertionNode(root, data);
			if (data < toInsert.data) {
				toInsert.left = new Node(data);
			} else {
				toInsert.right = new Node(data);
			}
		}
		size++;
	}
	
	private Node findInsertionNode(Node n, int data) {
		n.height++;
		if ((data < n.data && n.left == null)||(data > n.data && n.right == null)) {
			return n;
		} else if (data > n.data) {
			return findInsertionNode(n.right, data);
		} else {
			return findInsertionNode(n.left, data);
		}
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public boolean contains(int n) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int peek() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(int n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int[] toArray() {
		int[] ret = new int[size];
		insertNodeIntoArray(root, 1, ret);
		return ret;
	}
	
	private void insertNodeIntoArray(Node n, int index, int[] arr) {
		if (n != null) {
			arr[index - 1] = n.height;
			insertNodeIntoArray(n.left, index * 2, arr);
			insertNodeIntoArray(n.right, index * 2 + 1, arr);
		}
	}
}
