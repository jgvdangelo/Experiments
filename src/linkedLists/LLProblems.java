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
	
	// Misc: pairwise reversal of a linked list
	public static void pairwiseReversal(Node n) {
		if (n == null || n.next == null) {
			return;
		}
		
		// switch front
		Node temp = n.next;
		n.next = n.next.next;
		temp.next = n;
		n = temp;
		
		// switch remaining nodes
		Node curr = n.next;
		while (curr.next != null && curr.next.next != null) {
			temp = curr.next.next;
			curr.next.next = curr.next.next.next;
			temp.next = curr.next;
			curr.next = temp;
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
