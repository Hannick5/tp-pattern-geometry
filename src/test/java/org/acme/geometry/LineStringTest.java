package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LineStringTest {

	@Test
	public void LineStringStructure() {

		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(2.0, 5.0);
		Coordinate c3 = new Coordinate(6.0, 9.0);

		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point p3 = new Point(c3);

		List<Point> listPoint = Arrays.asList(p1, p2, p3);

		LineString l = new LineString();
		LineString l2 = new LineString(listPoint);

		assertEquals(l2.getPointN(0), p1);
		assertEquals(l2.getNumPoints(), 3);
		assertEquals(l.getNumPoints(), 0);
		assertEquals(l.getType(), l2.getType(), "LineString");

	}

}
