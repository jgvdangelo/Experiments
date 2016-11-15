package graphs;

import java.util.*;

public interface IGraph<V> {
	void addVertex(V v);
	void addEdge(V v1, V v2);
	void clear();
	boolean containsEdge(V v1, V v2);
	boolean containsVertex(V v);
	int degree(V v);
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
