package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PointTest {
	
	@Test
	public void TestPointCoordinates() {
		Coordinate coord = new Coordinate(4.0, 5.0);
		Point p1 = new Point();
		Point p2 = new Point(coord);
		
		assertTrue(Double.isNaN(p1.getCoordinate().getX()));
	}
	
	@Test
	public void TestPointType() {
		Point p = new Point();
		assertEquals(p.getType(), "Point");
	}
	
	@Test
	public void PointNull(){
		Point p = new Point(null);
		assertTrue(p.isEmpty());
	}

	
}
