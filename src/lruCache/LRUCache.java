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
		Node<V> toAdd;
		if (!hash.containsKey(v)) {
			toAdd = new Node<V>(v);
			q.enqueue(toAdd);
			hash.put(v, toAdd);
			
			if (cacheSize < q.size) {
				Node<V> removed = q.dequeue();
				hash.remove(removed.data);
			}
		} else {
			toAdd = hash.get(v);
			q.remove(toAdd);
			q.enqueue(toAdd);
		}
	}
	
	public void printOutput() {
		System.out.println(q.toString());
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
			if (front == n) {
				front = n.next;
				n.next = null;
			} else  {
				Node<U> prev = n.prev;
				Node<U> next = n.next;
				prev.next = next;
				n.next = null;
				n.prev = null;
			}
			size--;
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
		
		public String toString() {
			if (front == null) {
				return "";
			} else {
				Node<U> curr = last;
				StringBuilder str = new StringBuilder();
				while (curr != null) {
					str.append(curr.data.toString());
					curr = curr.prev;
				}
				return str.toString();
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
