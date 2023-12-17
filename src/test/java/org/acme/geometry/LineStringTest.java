package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LineStringTest {

	public static final double EPSILON = 1.0e-15;

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

	@Test
	public void LineStringNull() {
		LineString l = new LineString(null);
		assertTrue(l.isEmpty());
	}

	@Test
	public void LineStringTranslate() {
		double dx = 1.0;
		double dy = 2.0;

		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(2.0, 5.0);
		Coordinate c3 = new Coordinate(6.0, 9.0);

		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point p3 = new Point(c3);

		List<Point> listPoint = Arrays.asList(p1, p2, p3);

		LineString l = new LineString(listPoint);

		l.translate(dx, dy);

		double newX = l.getPointN(1).getCoordinate().getX();
		double newY = l.getPointN(1).getCoordinate().getY();

		assertEquals(newX, 3.0, EPSILON);
		assertEquals(newY, 7.0, EPSILON);
	}

	@Test
	public void testClone() {
		double dx = 1.0;
		double dy = 2.0;

		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(2.0, 5.0);
		Coordinate c3 = new Coordinate(6.0, 9.0);

		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point p3 = new Point(c3);

		List<Point> listPoint = Arrays.asList(p1, p2, p3);

		LineString l = new LineString(listPoint);
		LineString l2 = (LineString) l.clone();

		l2.translate(dx, dy);

		assertEquals(l2.getPointN(0).getCoordinate().getX(), 4.0, EPSILON);
		assertEquals(l.getPointN(0).getCoordinate().getX(), 3.0, EPSILON);
	}

	@Test
	public void testGetEnvelope() {
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(2.0, 5.0);
		Coordinate c3 = new Coordinate(6.0, 9.0);

		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point p3 = new Point(c3);

		List<Point> listPoint = Arrays.asList(p1, p2, p3);

		LineString l = new LineString(listPoint);

		Envelope e = l.getEnvelope();

		assertEquals(e.toString(), "2.0,4.0,6.0,9.0");
	}

}
