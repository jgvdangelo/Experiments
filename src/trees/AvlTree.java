package trees;

public class AvlTree implements IBinaryTree {
	Node root;
	int size = 0;
	
	@Override
	public void add(int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			Node toInsert = addNode(root, data);
			// TODO: remove the following code, and set root = addNode(root) in previous line
			if (toInsert.data == data) {
				throw new IllegalArgumentException();
			}
			if (data < toInsert.data) {
				toInsert.left = new Node(data);
			} else {
				toInsert.right = new Node(data);
			}
		}
		size++;
	}
	
	private Node addNode(Node n, int data) {
		if ((data == n.data)||(data < n.data && n.left == null)||(data > n.data && n.right == null)) {
			n.height = Math.max(height(n.left), height(n.right)) + 1;
			n.height = (n.height == 1) ? 2 : n.height;
			
			return n;
		} else {
			Node ret;
			if (data > n.data) {
				ret = addNode(n.right, data);
			} else {
				ret = addNode(n.left, data);
			}
			rotateIfRequired(n);
			n.height = Math.max(height(n.left), height(n.right)) + 1;
			return ret;
		}
	}
	
	private void rotateIfRequired(Node n) {
		// TODO implement
	}
	
	private int height(Node n) {
		if (n == null)
			return 0;
		else
			return n.height;
	}
	
	@Override
	public void clear() {
		root = null;
	}

	@Override
	public boolean contains(int n) {
		return false;
	}

	@Override
	public int peek() {
		return root.data;
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
		int arrSize = (int) Math.pow(2, root.height) - 1;
		int[] ret = new int[arrSize];
		insertNodeIntoArray(root, 1, ret);
		return ret;
	}
	
	private void insertNodeIntoArray(Node n, int index, int[] arr) {
		if (n != null) {
			arr[index - 1] = n.data;
			insertNodeIntoArray(n.left, index * 2, arr);
			insertNodeIntoArray(n.right, index * 2 + 1, arr);
		}
	}
}
