package graphs;

import java.io.*;
import java.util.*;

public class GraphUser {
	public static void main(String[] args) {		
		Scanner scan;
		
		try {
			scan = new Scanner(new File("graph"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		int vertices = scan.nextInt();
		int edges = scan.nextInt();
		
		IGraph<Integer> graph = new ListGraph<Integer>();
		
		int v1; int v2;
		for (int i = 0; i < edges; i++) {
			v1 = scan.nextInt();
			v2 = scan.nextInt();
			
			if (!graph.containsVertex(v1)) {
				graph.addVertex(v1);
			}
			
			if (!graph.containsVertex(v2)) {
				graph.addVertex(v2);
			}
			
			graph.addEdge(v1, v2);
		}
		
		System.out.println(graph.isReachable(0,5));
		System.out.println(graph.isReachable(1,0));
		
		System.out.println(graph.shortestPath(2, 7));
		
		scan.close();
		
	}
}
