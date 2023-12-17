package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testCoordinateXY() {

		Coordinate c = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate();
		Coordinate c3 = new Coordinate(Double.NaN, 4.0);

		assertEquals(3.0, c.getX(), EPSILON);
		assertEquals(4.0, c.getY(), EPSILON);

		assertTrue(Double.isNaN(c2.getX()));
		assertTrue(Double.isNaN(c2.getY()));

		assertFalse(c.isEmpty());
		assertEquals("[3.0,4.0]", c.toString());

		assertTrue(c3.isEmpty());

	}

}