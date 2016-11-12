package graphs;

import java.util.*;

public interface IWeightedGraph<V, E> extends IGraph<V, E> { 
	void addEdge(V v1, V v2, E e, int weight);
	int edgeWeight(V v1, V v2);
	int cost(List<V> path);
	boolean isWeighted();
	List<V> minimumWeightPath(V v); // Dijkstra's
}
