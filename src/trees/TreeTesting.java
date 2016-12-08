package trees;

import java.util.*;

public class TreeTesting {

	public static void main(String[] args) {
		AvlTree tree = new AvlTree();
		int[] toAdd = new int[] {3, 1, 5, 0, 2, 4, 7};
		for (int i : toAdd) {
			tree.add(i);
		}
		
		System.out.println(Arrays.toString(tree.toArray()));
	}

}
