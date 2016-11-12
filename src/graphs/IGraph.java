package graphs;

import java.util.*;

public interface IGraph<V, E> {
	void addEdge(V v1, V v2, E e);
	void addVertex(V v);
	void clear();
	boolean containsEdge(E e);
	boolean containsEdge(V v1, V v2);
	boolean containsVertex(V v);
	int degree(V v);
	E edge(V v1, V v2);
	int edgeCount();
	Set<E> edges();
	boolean isDirected();
	boolean isEmpty();
	boolean isReachable(V v1, V v2); // DFS
	Set<V> neighbors(V v);
	int outDegree(V v);
	void removeEdge(V v1, V v2);
	void removeVertex(V v);
	List<V> shortestPath(V v1, V v2); // BFS
	String toString();
	int vertexCount();
	Set<V> vertices();
}
