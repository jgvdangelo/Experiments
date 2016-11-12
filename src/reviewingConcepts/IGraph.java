package reviewingConcepts;

import java.util.*;

public interface IGraph<V, E> {
	// TODO: update methods to work with weighted graphs 
	// void addEdge(V v1, V v2, E e, int weight);
	// int edgeWeight(V v1, V v2);
	// int cost(List<V> path);
	
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
}
