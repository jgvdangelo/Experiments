package misc;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class ccProblemsTest {

	@Test
	public void testStacksMax() {
		int[] a1 = new int[] {1, 1, 100, 3};
		int[] a2 = new int[] {2000, 2, 3, 1};
		int[] a3 = new int[] {10, 1, 4};
		Stack<Integer> s1 = new Stack<Integer>();
		for (int i : a1) 
			s1.push(i);
		Stack<Integer> s2 = new Stack<Integer>();
		for (int i : a2) 
			s2.push(i);
		Stack<Integer> s3 = new Stack<Integer>();
		for (int i : a3) 
			s3.push(i);
		
		List<Stack<Integer>> stacks = new LinkedList<Stack<Integer>>();
		stacks.add(s1); stacks.add(s2); stacks.add(s3);
		assertEquals(107, ccProblems.maxNumFromStacks(stacks, 3));
	}
	
	@Test
	public void testPointAngles() {
		List<Point> pts = new LinkedList<Point>();
		Point p1 = new Point(5, 1);
		Point p2 = new Point(7, 1);
		Point p3 = new Point(-7, 1);
		pts.add(p1); pts.add(p2); pts.add(p3);
		System.out.println(ccProblems.viewPoints(pts, 45));
	}
}
