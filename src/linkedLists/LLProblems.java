package linkedLists;

import java.util.*;

public class LLProblems {

	// Problem 2.1
	public static void removeDupes(Node head) {
		if (head == null || head.next == null)
			return;
		
		Node current = head;
		Set<Integer> set = new HashSet<Integer>();
		
		set.add(current.data);
		
		Node temp = null;
		while (current.next != null) {
			if (set.contains(current.next.data)) {
				temp = current.next;
				current.next = current.next.next;
				temp.next = null;
			} else {
				set.add(current.next.data);
				current = current.next;
			}
		}
	}
	
	public class Node {
		int data;
		Node next;
		
		public Node(int n) {
			this.data = n;
		}
	}
}
