package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void TestPointCoordinates() {
		Point p1 = new Point();
		assertTrue(Double.isNaN(p1.getCoordinate().getX()));
	}

	@Test
	public void TestPointType() {
		Point p = new Point();
		assertEquals(p.getType(), "Point");
	}

	@Test
	public void PointNull() {
		Point p = new Point(null);
		assertTrue(p.isEmpty());
	}

	@Test
	public void PointTranslate() {
		double dx = 3.0;
		double dy = 4.0;
		Coordinate c = new Coordinate(2.0, 1.0);
		Point p = new Point(c);

		p.translate(dx, dy);

		assertEquals(p.getCoordinate().getX(), 5.0, EPSILON);
		assertEquals(p.getCoordinate().getY(), 5.0, EPSILON);
	}

	@Test
	public void PointClone() {
		double dx = 3.0;
		double dy = 4.0;
		Coordinate c = new Coordinate(2.0, 1.0);
		Point p = new Point(c);
		Point p2 = (Point) p.clone();

		p2.translate(dx, dy);

		assertEquals(p2.getCoordinate().getX(), 5.0, EPSILON);
		assertEquals(p.getCoordinate().getX(), 2.0, EPSILON);
	}

	@Test
	public void testGetEnvelope() {
		Coordinate coord = new Coordinate(4.0, 5.0);
		Point p = new Point(coord);
		Envelope e = p.getEnvelope();

		assertEquals(e.toString(), "4.0,5.0,4.0,5.0");
	}

}
