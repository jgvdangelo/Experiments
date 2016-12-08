package trees;

public class Node {
	public Node left;
	public Node right;
	public int height = 1;
	public int data;
	
	public Node(int n) {
		this.data = n;
	}
	
	public Node(int n, int h) {
		this.data = n;
		this.height = h;
	}
}
