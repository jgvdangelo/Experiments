package graphs;

import java.util.*;
import java.util.Set;

// FYI, in order to implement this as a matrix, and to gain maximum understanding,
// 	I'm implementing this as an integer matrix, and therefore not implementing IGraph
public class MatrixGraph { // implements IGraph<V> {
	private final int INITIAL_SIZE = 16;
	
	// Setting constants to use in the integer matrix
	private static final int NOT_EXIST = 0; // vertex does not exist in graph
	private static final int EXIST = 1; // vertex exists, but no link
	private static final int LINK = 2; // vertex exists, and so does link
	
	private int[][] matrix;
	private int factor = 1;
	
	public MatrixGraph() {
		clear();
	}
	
	public void addVertex(int v) {
		if (v > matrix.length) {
			while (v > INITIAL_SIZE * factor) {
				factor *= 2;
			}
			int[][] toSet = new int[factor * INITIAL_SIZE][];
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					toSet[i][j] = matrix[i][j];
				}
			}
			
			this.matrix = toSet;
		}
		
		Arrays.fill(matrix[v], EXIST);
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][v] = EXIST;
		}
	}

	public void addEdge(int v1, int v2) {
		if (v1 > matrix.length || v2 > matrix.length) 
			throw new IllegalArgumentException();
		matrix[v1][v2] = LINK;
	}


	public void clear() {
		matrix = new int[INITIAL_SIZE][];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[INITIAL_SIZE * factor];
		}
	}


	public boolean containsEdge(int v1, int v2) {
		return (matrix[v1][v2] == LINK);
	}


	public boolean containsVertex(int v) {
		return (v < matrix.length && matrix[0][v] == EXIST);
	}


	public int degree(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) { 
				if (matrix[i][j] != NOT_EXIST)
					return true;
			}
		}
		return false;
	}

	public boolean DFS(int v1, int v2, boolean[] visited) {
		if (v1 == v2) {
			return true;
		} else {
			boolean found = false;
			visited[v1] = true;
			for (int i = 0; i < matrix[v1].length; i++) {
				if (matrix[v1][i] == LINK && !visited[i]) {
					found = DFS(i, v2, visited);
					if (found == true) {
						return found;
					}
				}
			}
			return found;
		}
	}
	
	public boolean isReachable(int v1, int v2) {
		if (v1 >= matrix.length || v2 >= matrix.length)
			throw new IllegalArgumentException();
		
		boolean[] visited = new boolean[matrix.length];
		return DFS(v1, v2, visited);
	}


	public Set<Integer> neighbors(int v) {
		Set<Integer> neighbors = new HashSet<Integer>();
		
		int[] links = matrix[v];
		for (int i = 0; i < links.length; i++) {
			if (links[i] == LINK) {
				neighbors.add(i);
			}
		}
		
		return neighbors;
	}


	public int outDegree(int v) {
		// TODO Auto-generated method stub
		return 0;
	}


	public void removeEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		
	}


	public void removeVertex(int v) {
		// TODO Auto-generated method stub
		
	}


	public List<Integer> shortestPath(int v1, int v2) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Map<Integer, Integer> previous = new HashMap<Integer, Integer>();
		previous.put(v1, null);
		queue.add(v1);
		
		int curr = 0;
		boolean found = false;
		while (!queue.isEmpty() && !found) {
			curr = queue.remove();
			if (v2 == curr) 
				found = true;
			else {
				for (Integer n : neighbors(curr)) {
					if (!previous.containsKey(n)) {
						previous.put(n, curr);
						queue.add(n);
					}
				}
			}
		}
		
		if (!previous.containsKey(curr)) {
			return null;
		}
		
		List<Integer> path = new LinkedList<Integer>();
		
		Integer val = curr;
		while (val != null) {
			path.add(0, val);
			val = previous.get(val);
		}
		
		return path;
	}


	public int vertexCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	public Set<Integer> vertices() {
		// TODO Auto-generated method stub
		return null;
	}

}