package trees;

public class AvlTree implements IBinaryTree {
	Node root;
	
	@Override
	public void add(int data) {
		if (root == null) {
			root = new Node(data, 1);
		} else {
			Node toInsert = findNext(root, data);
			if (data < toInsert.data) {
				toInsert.left = new Node(data);
			} else {
				toInsert.right = new Node(data);
			}
		}
	}
	
	private Node findNext(Node n, int data) {
		if (data > n.data && n.right == null) {
			return n;
		} else if (data < n.data && n.left == null) {
			return n;
		} else if (data > n.data) {
			return findNext(n.right, data);
		} else {
			return findNext(n.left, data);
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
