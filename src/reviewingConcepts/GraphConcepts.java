package reviewingConcepts;

import java.io.*;
import java.util.*;

public class GraphConcepts {
	public static void main(String[] args) {
		// TODO: the following
		// instantiate each type of graph
		// fill each graph with nodes
		// perform DFS and BFS on each kind
		
		Scanner scan;
		
		try {
			scan = new Scanner(new File("stdin"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		int vertices = scan.nextInt();
		int edges = scan.nextInt();
		
		
	}
	
	// TODO: fill these out
	private class ListGraph {
		
		
		
		private class GraphNode {
			public boolean visited = false;
			public int data;
			List<GraphNode> adjacent = new ArrayList<GraphNode>();
			
			public GraphNode(int data) {
				this.data = data;
			}
		}
	}
	
	private class MatrixGraph {
		
	}
}
