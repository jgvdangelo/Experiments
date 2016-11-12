package graphs;

import java.io.*;
import java.util.*;

public class GraphUser {
	public static void main(String[] args) {		
		Scanner scan;
		
		try {
			scan = new Scanner(new File("stdin"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		int vertices = scan.nextInt();
		int edges = scan.nextInt();
		
		for (int i = 0; i < edges; i++) {
			
		}
		
		scan.close();
		
	}
}
