package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EnvelopeTest {
	@Test
	public void TestEnvelopeVide() {
		Envelope e = new Envelope();
		assertTrue(e.isEmpty());
	}

	@Test
	public void TestEnvelopeMethods() {
		Coordinate topRight = new Coordinate(1.0, 1.0);
		Coordinate bottomLeft = new Coordinate(0.0, 0.0);

		Envelope e = new Envelope(bottomLeft, topRight);

		assertFalse(e.isEmpty());

		String test = "0.0,0.0,1.0,1.0";
		assertEquals(e.toString(), test);
	}
}
