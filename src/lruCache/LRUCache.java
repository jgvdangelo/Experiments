package lruCache;

import java.util.*;

public class LRUCache<V> {
	int cacheSize = 0;
	Map<V, Node<V>> hash = new HashMap<V, Node<V>>();
	DoublyLinkedList<V> q = new DoublyLinkedList<V>();
	
	public LRUCache(int n) {
		this.cacheSize = n;
	}
	
	public void reference(V v) {
		// TODO: implement
	}
	
	public void printOutput() {
		// TODO: implement
	}
	
	private class DoublyLinkedList<U> {
		int size = 0;
		Node<U> front;
		Node<U> last;
		
		public void enqueue(Node<U> toAdd) {
			if (front == null) {
				front = toAdd;
				last = toAdd;
			} else {
				toAdd.next = front;
				front.prev = toAdd;
				front = toAdd;
			}
			size++;
		}
		
		public void remove(Node<U> n) {
			Node<U> prev = n.prev;
			Node<U> next = n.next;
			prev.next = next;
			n.next = null;
			n.prev = null;
		}
		
		public Node<U> dequeue() {
			if (front == null) {
				return null;
			} else if (front.next == null) {
				Node<U> ret = front;
				front = null;
				size--;
				return ret;
			} else {
				Node<U> ret = last;
				Node<U> prev = last.prev;
				last = prev;
				prev.next = null;
				ret.prev = null;
				size--;
				return ret;
			}
		}
	}
	
	private class Node<W> {
		W data;
		Node<W> next;
		Node<W> prev;
		
		public Node(W w) {
			this.data = w;
		}
	}
}
