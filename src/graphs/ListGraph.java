package graphs;

import java.util.*;

// TODO: fill these out
public class ListGraph<V> implements IGraph<V> {

	Map<V, Set<V>> lists = new HashMap<V, Set<V>>();
	Map<V, Boolean> visited = new HashMap<V, Boolean>();

	public void addEdge(V v1, V v2) {
		if (!lists.containsKey(v1) || !lists.containsKey(v2) || v1.equals(v2)) {
			throw new IllegalArgumentException();
		}
		
		Set<V> v1Adj = lists.get(v1);
		v1Adj.add(v2);
		lists.put(v1, v1Adj);
		
		Set<V> v2Adj = lists.get(v2);
		v2Adj.add(v1);
		lists.put(v2, v2Adj);
	}

	public void addVertex(V v) {
		if (!lists.containsKey(v)) {
			throw new IllegalArgumentException();
		}
		
		Set<V> vAdj = new HashSet<V>();
		lists.put(v, vAdj);
	}

	public void clear() {
		lists.clear();
	}

	public boolean containsEdge(V v1, V v2) {
		return lists.get(v1).contains(v2);
	}

	public boolean containsVertex(V v) {
		return lists.containsKey(v);
	}

	public int degree(V v) {
		return lists.get(v).size();
	}

	public boolean isDirected() {
		return true;
	}

	public boolean isEmpty() {
		return (lists.size() == 0);
	}

	public boolean isReachable(V v1, V v2) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<V> neighbors(V v) {
		return lists.get(v);
	}

	public int outDegree(V v) {
		return lists.get(v).size();
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
		return lists.keySet();
	}
}