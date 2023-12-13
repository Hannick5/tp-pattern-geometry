package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorXY(){
		// TODO
		Coordinate c = new Coordinate(3.0,4.0);
		Assert.assertEquals(3.0, c.getX(), EPSILON);
		Assert.assertEquals(4.0, c.getY(), EPSILON);
		Assert.assertFalse(c.isEmpty());
        Assert.assertEquals("[3.0,4.0]", c.toString());
        
        Coordinate d = new Coordinate();
        Assert.assertEquals("[NaN,NaN]", d.toString());
	}

}
