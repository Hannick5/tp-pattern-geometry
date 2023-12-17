package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WktwriterTest {
	@Test
	public void TestWriter() {
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(2.0, 5.0);
		Coordinate c3 = new Coordinate(6.0, 9.0);

		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point p3 = new Point(c3);

		List<Point> listPoint = Arrays.asList(p1, p2, p3);

		LineString l = new LineString(listPoint);
		WktWriter w = new WktWriter();

		assertEquals(w.write(p1), "POINT(3.0 4.0)");
		assertEquals(w.write(l), "LINESTRING(3.0 4.0,2.0 5.0,6.0 9.0)");

		Point p = new Point();
		l = new LineString();

		assertEquals(w.write(p), "POINT EMPTY");
		assertEquals(w.write(l), "LINESTRING EMPTY");
	}
}
