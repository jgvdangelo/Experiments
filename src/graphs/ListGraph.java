package graphs;

import java.util.*;

// TODO: fill these out
public class ListGraph<V, E> implements IGraph<V, E> {
	
	Map<V, List<V>> nodes = new HashMap<V, List<V>>();

	public void addEdge(V v1, V v2, E e) {
		if (!nodes.containsKey(v1) || !nodes.containsKey(v2) || v1.equals(v2)) {
			throw new IllegalArgumentException();
		}
		
		List<V> v1Adj = nodes.get(v1);
		v1Adj.add(v2);
		nodes.put(v1, v1Adj);
		
		List<V> v2Adj = nodes.get(v2);
		v2Adj.add(v1);
		nodes.put(v2, v2Adj);
	}

	public void addVertex(V v) {
		if (!nodes.containsKey(v1)) {
			throw new IllegalArgumentException();
		}
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public boolean containsEdge(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsEdge(V v1, V v2) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsVertex(V v) {
		// TODO Auto-generated method stub
		return false;
	}

	public int degree(V v) {
		// TODO Auto-generated method stub
		return 0;
	}

	public E edge(V v1, V v2) {
		// TODO Auto-generated method stub
		return null;
	}

	public int edgeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Set<E> edges() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isReachable(V v1, V v2) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<V> neighbors(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	public int outDegree(V v) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void removeEdge(V v1, V v2) {
		// TODO Auto-generated method stub
		
	}

	public void removeVertex(V v) {
		// TODO Auto-generated method stub
		
	}

	public List<V> shortestPath(V v1, V v2) {
		// TODO Auto-generated method stub
		return null;
	}

	public int vertexCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Set<V> vertices() {
		// TODO Auto-generated method stub
		return null;
	}
}