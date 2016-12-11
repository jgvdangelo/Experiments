package graphs;

import java.util.*;

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
	}

	public void addVertex(V v) {
		if (lists.containsKey(v)) {
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

	private boolean DFS(V v1, V v2) {
		if (v1 == null)
			return false;
		if (v1.equals(v2))
			return true;
		else {
			visited.put(v1, true);
			boolean found = false;
			for (V node : lists.get(v1)) {
				if (!visited.containsKey(node)) {
					found = DFS(node, v2);
					if (found)
						return true;
				}
			}
			return false;
		}
	}

	public boolean isReachable(V v1, V v2) {
		if (!lists.containsKey(v1) || !lists.containsKey(v2)) {
			throw new IllegalArgumentException();
		}

		if (v1.equals(v2)) {
			return true;
		}

		boolean isReachable = DFS(v1, v2);

		visited.clear();
		return isReachable;
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
	
	private List<V> BFS(V v1, V v2) {
		Queue<V> queue = new LinkedList<V>();

		Map<V, V> prev = new HashMap<V, V>();
		prev.put(v1, null);
		queue.add(v1);

		V curr = null;
		boolean notFound = true;
		while (!queue.isEmpty() && notFound) {
			curr = queue.remove();
			if (curr.equals(v2))
				notFound = false;
			else {
				for (V n : lists.get(curr)) {
					if (!prev.containsKey(n)) {
						queue.add(n);
						prev.put(n, curr);
					}
				}
			}
		}

		List<V> path = new LinkedList<V>();

		while (curr != null) {
			path.add(0, curr);
			curr = prev.get(curr);
		}

		return path;
	}
	
	public List<V> shortestPath(V v1, V v2) {
		if (!lists.containsKey(v1) || !lists.containsKey(v2)) {
			throw new IllegalArgumentException();
		}

		if (v1.equals(v2)) {
			return null;
		}
		
		return BFS(v1, v2);
	}

	public int vertexCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Set<V> vertices() {
		return lists.keySet();
	}
	
	public List<V> topologicalSort() {
		List<V> ret = new LinkedList<V>();
		Queue<V> q = new LinkedList<V>();
		Map<V, Integer> inDegree = new HashMap<V, Integer>();
		
		for (Map.Entry<V, Set<V>> kvp : lists.entrySet()) {
			if (!inDegree.containsKey(kvp.getKey())) {
				inDegree.put(kvp.getKey(), 0);
			}
			for (V v : kvp.getValue()) 
				incrementMap(v, inDegree);
		}
		
		for (Map.Entry<V, Integer> kvp : inDegree.entrySet()) {
			if (kvp.getValue() == 0) 
				q.add(kvp.getKey());
		}
		
		V curr;
		while (!q.isEmpty()) {
			curr = q.remove();
			ret.add(curr);
			for (V v : lists.get(curr)) 
				decrementMap(v, inDegree);
			
			for (Map.Entry<V, Integer> kvp : inDegree.entrySet()) {
				if (kvp.getValue() == 0 && !q.contains(kvp.getKey()) && !ret.contains(kvp.getKey()))
					q.add(kvp.getKey());
			}
		}
		
		return ret;
	}
	
	private void incrementMap(V v, Map<V, Integer> map) {
		if (map.containsKey(v)) {
			map.put(v, map.get(v) + 1);
		} else {
			map.put(v, 1);
		}
	}
	
	private void decrementMap(V v, Map<V, Integer> map) {
		if (!map.containsKey(v)) {
			throw new IllegalArgumentException();
		} 
		map.put(v, map.get(v) - 1);
	}
}