package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	
	// Problem: https://careercup.com/question?id=5689208527126528
	public List<Integer> findLongestPath() {
		if (root == null)
			return null;

		Map<Integer, List<List<Integer>>> pathsMap = new HashMap<Integer, List<List<Integer>>>();

		List<Integer> l1 = helper1(root.left, root, pathsMap);
		List<Integer> l2 = helper1(root.right, root, pathsMap);
		if (l1 != null) {
			addListToHashMap(root.data, l1, pathsMap);
		} 
		if (l2 != null) {
			addListToHashMap(root.data, l2, pathsMap);
		}
		if (l1 != null && l2 != null) {
				if (pathsAreCompatible(l1, l2)) {
					addListToHashMap(root.data, mergeLists(l1, l2), pathsMap);  
				}
		}

		// TODO: implement finding the longest list stored in pathsMap.
		return null;
	}

	private List<Integer> helper1(Node n, Node parent, Map<Integer, List<List<Integer>>> pathsMap) {
		if (n == null)
			return null;
		else if (n.left == null && n.right == null) {
			if (!areConsecutive(n.data, parent.data)) {
				return null;
			} else {
				List<Integer> path = new LinkedList<Integer>();
				path.add(n.data);
				return path;
			}
		} else {
			List<Integer> l1 = helper1(n.left, parent, pathsMap);
			List<Integer> l2 = helper1(n.right, parent, pathsMap);
			if (l1 == null && l2 == null) {
				return null;
			} else if (l1 == null || l2 == null) {
				List<Integer> list = (l1 == null) ? l2 : l1;
				list.add(n.data);
				if (parentFitsInSequence(list, parent.data)) {
					return list;
				} else { 
					addListToHashMap(n.data, list, pathsMap);
					return null;
				}
			} else {
				l1.add(n.data);
				l2.add(n.data);
				
				if (l1 != null && l2 != null && pathsAreCompatible(l1, l2)) {
					addListToHashMap(n.data, mergeLists(l1, l2), pathsMap);  
				}
				
				boolean l1p = parentFitsInSequence(l1, parent.data);
				boolean l2p = parentFitsInSequence(l2, parent.data);
				if (l1p) {  
					addListToHashMap(n.data, l2, pathsMap);
					return l1;
				} else if (l2p) {
					addListToHashMap(n.data, l1, pathsMap);
					return l2;
				} else {
					addListToHashMap(n.data, l1, pathsMap);
					addListToHashMap(n.data, l2, pathsMap);
				}
				return null;
			}
		}
	}

	private boolean pathsAreCompatible(List<Integer> l1, List<Integer> l2) {
		// TODO
		return false;
	}

	private List<Integer> mergeLists(List<Integer> l1, List<Integer> l2) {
		// TODO
		return null;
	}

	private void addListToHashMap(int n, List<Integer> l, Map<Integer, List<List<Integer>>> pathsMap) {
		if (pathsMap.containsKey(n)) {
			pathsMap.get(n).add(l);
		} else {
			List<List<Integer>> paths = new LinkedList<List<Integer>>();
			paths.add(l);
			pathsMap.put(n, paths);
		}
	}

	private boolean parentFitsInSequence(List<Integer> l, int n) {
		if ((l.get(0) < l.get(1)) && (l.get(l.size() - 1) + 1 == n)) {
			return true; // ascending list
		} else if ((l.get(0) > l.get(1)) && (l.get(l.size() - 1) - 1 == n)) { 
			return true; // descending list
		} else {
			return false;
		}
	} 

	private boolean areConsecutive(int n1, int n2) {
		return (Math.abs(n1 - n2) == 1);
	}

}
