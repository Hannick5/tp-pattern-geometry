package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnvelopeBuilderTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testBuild() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(0.0, 1.0));
		builder.insert(new Coordinate(2.0, 0.0));
		builder.insert(new Coordinate(1.0, 3.0));

		Envelope envelope = builder.build();

		assertEquals(0.0, envelope.getXmin(), EPSILON);
		assertEquals(0.0, envelope.getYmin(), EPSILON);
		assertEquals(2.0, envelope.getXmax(), EPSILON);
		assertEquals(3.0, envelope.getYmax(), EPSILON);
	}
}
