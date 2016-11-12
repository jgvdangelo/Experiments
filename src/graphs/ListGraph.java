package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// TODO: fill these out
public class ListGraph<V, E> implements IGraph<V, E> {
	
	private class GraphNode {
		public boolean visited = false;
		public int data;
		List<GraphNode> adjacent = new ArrayList<GraphNode>();
		
		public GraphNode(int data) {
			this.data = data;
		}
	}

	public void addEdge(V v1, V v2, E e) {
		// TODO Auto-generated method stub
		
	}

	public void addVertex(V v) {
		// TODO Auto-generated method stub
		
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