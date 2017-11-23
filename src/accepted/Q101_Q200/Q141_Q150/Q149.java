package accepted.Q101_Q200.Q141_Q150;

import org.junit.Test;
import util.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Q149 {

	public int maxPoints(Point[] points) {

		if (points == null) {
			return 0;
		}
		if (points.length < 3) {
			return points.length;
		}

		int max = 0;
		for (int i = 0; i < points.length; i++) {

			int baseCnt = 1;
			Map<Double, Integer> m = new HashMap<Double, Integer>();
			for (int j = i + 1; j < points.length; j++) {

				if (isSame(points[i], points[j])) {
					baseCnt++;
				} else {
					double r = ratio(points[i], points[j]);

					Integer cnt = m.get(r);
					if (cnt == null) {
						cnt = 0;
					}
					cnt++;
					m.put(r, cnt);
				}

			}
			if (baseCnt > max) {
				max = baseCnt;
			}
			for (Entry<Double, Integer> e : m.entrySet()) {
				int val = e.getValue() + baseCnt;
				if (val > max) {
					max = val;
				}
			}
		}

		return max;
	}

	private boolean isSame(Point p1, Point p2) {
		return p1.x == p2.x && p1.y == p2.y;
	}

	private double ratio(Point p1, Point p2) {
		if (p1.y == p2.y) {
			return Double.POSITIVE_INFINITY;
		} else if (p1.x == p2.x) {
			return 0.0d;
		}
		return (p1.x - p2.x) * 1.0d / (p1.y - p2.y);
	}

	@Test
	public void test() {
		double a = -1.0 / 0;
		double b = 2.0 / 0;
		System.out.println(a == b);

		Point[] pts = new Point[3];
		pts[0] = new Point(1, 1);
		pts[1] = new Point(1, 1);
		pts[2] = new Point(1, 1);
		System.out.println(maxPoints(pts));
	}

}
