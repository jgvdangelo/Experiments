package trees;

public class AvlTree implements IBinaryTree {
	Node root;
	int size = 0;
	
	@Override
	public void add(int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			Node toInsert = findNode(root, data);
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
	
	private Node findNode(Node n, int data) {
		n.height = Math.max(height(n.left), height(n.right)) + 1;
		if ((data == n.data)||(data < n.data && n.left == null)||(data > n.data && n.right == null)) {
			n.height = (n.height == 1) ? 2 : n.height;
			
			return n;
		} else if (data > n.data) {
			return findNode(n.right, data);
		} else {
			return findNode(n.left, data);
		}
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
		// TODO: see if i can gerry-rig findNode to be used here
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
		int arrSize = (int) Math.pow(2, root.height);
		int[] ret = new int[arrSize];
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
