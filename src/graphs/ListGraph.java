package graphs;

import java.util.*;

// TODO: fill these out
public class ListGraph<V> implements IGraph<V> {
	
	Map<V, Set<V>> nodes = new HashMap<V, Set<V>>();

	public void addEdge(V v1, V v2) {
		if (!nodes.containsKey(v1) || !nodes.containsKey(v2) || v1.equals(v2)) {
			throw new IllegalArgumentException();
		}
		
		Set<V> v1Adj = nodes.get(v1);
		v1Adj.add(v2);
		nodes.put(v1, v1Adj);
		
		Set<V> v2Adj = nodes.get(v2);
		v2Adj.add(v1);
		nodes.put(v2, v2Adj);
	}

	public void addVertex(V v) {
		if (!nodes.containsKey(v)) {
			throw new IllegalArgumentException();
		}
		
		Set<V> vAdj = new HashSet<V>();
		nodes.put(v, vAdj);
	}

	public void clear() {
		nodes.clear();
	}

	public boolean containsEdge(V v1, V v2) {
		return nodes.get(v1).contains(v2);
	}

	public boolean containsVertex(V v) {
		return nodes.containsKey(v);
	}

	public int degree(V v) {
		return nodes.get(v).size();
	}

	public boolean isDirected() {
		return true;
	}

	public boolean isEmpty() {
		return (nodes.size() == 0);
	}

	public boolean isReachable(V v1, V v2) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<V> neighbors(V v) {
		return nodes.get(v);
	}

	public int outDegree(V v) {
		return nodes.get(v).size();
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
		return nodes.keySet();
	}
}