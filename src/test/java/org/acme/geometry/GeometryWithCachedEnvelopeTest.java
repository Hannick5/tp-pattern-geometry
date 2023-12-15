package org.acme.geometry;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {
	@Test
	public void TestEnvelopeCached() {
		Geometry g = new Point(new Coordinate(3.0,3.0));
		g = new GeometryWithCachedEnvelope(g);
		Envelope a = g.getEnvelope(); 
		Envelope b = g.getEnvelope(); 
		assertSame(a,b);
	}
}
