package trees;

import java.util.*;

public class TreeTesting {

	public static void main(String[] args) {
		AvlTree tree = new AvlTree();
		int[] toAdd = new int[] {3, 1, 5, -1, 2, 7};
		for (int i : toAdd) {
			tree.add(i);
		}
		tree.add(8);
		
		System.out.println(Arrays.toString(tree.toArray()));
	}

}
