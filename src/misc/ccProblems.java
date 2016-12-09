package misc;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class ccProblems {
	// Problem: taken from here https://careercup.com/question?id=5725166060437504
	public int maxLineFinder(List<Point> points) {
		if (points.size() == 1)
			return 1;

		Map<Line, List<Point>> lines = new HashMap<Line, List<Point>>();

		List<Point> linePoints;
		Line l;
		for (int i = 0; i < points.size() - 1; i++) {
			for (int j = i + 1; j < points.size(); j++) {
				l = getLine(points.get(i), points.get(j));
				if (!lines.containsKey(l)) {
					linePoints = new LinkedList<Point>();
					linePoints.add(points.get(i));
					linePoints.add(points.get(j));
					lines.put(l, linePoints);
				} else {
					lines.get(l).add(points.get(i));
					lines.get(l).add(points.get(j));
				}
			}
		}

		int max = 0;
		for (Map.Entry<Line, List<Point>> pair : lines.entrySet()) {
			if (pair.getValue().size() > max) {
				max = pair.getValue().size();
			}
		}

		return max;
	}
	
	private static Line getLine(Point p1, Point p2) {
		double slope = (p1.y - p2.y) / (p1.x - p2.x);
		double yint = p1.y - p2.x * slope;
		return new Line(slope, yint);
	}

	public static class Line {
		double slope;
		double yint;

		public Line(double slope, double yint) {
			this.slope = slope;
			this.yint = yint;
		}
	}
}
