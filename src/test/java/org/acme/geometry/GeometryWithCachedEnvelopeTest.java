package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	@Test
    public void TriggerTest(){
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(2.0, 5.0);
		Coordinate c3 = new Coordinate(6.0, 9.0);

		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point p3 = new Point(c3);
		
		List<Point> listPoint = Arrays.asList(p1, p2, p3);
		
		LineString l = new LineString(listPoint);

        GeometryWithCachedEnvelope geo = new GeometryWithCachedEnvelope(l);

        Envelope e1 = geo.getEnvelope();
        l.translate(2.0, 2.0);
        Envelope e2 = geo.getEnvelope();
        geo.translate(1.0, 1.0);
        Envelope e3 = geo.getEnvelope();

        assertNotSame(e1, e2);
        assertNotSame(e1, e3);
    }
	
	@Test
	public void TestMethods() {
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(2.0, 5.0);
		Coordinate c3 = new Coordinate(6.0, 9.0);

		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point p3 = new Point(c3);
		
		List<Point> listPoint = Arrays.asList(p1, p2, p3);
		
		LineString l = new LineString(listPoint);

        GeometryWithCachedEnvelope geo = new GeometryWithCachedEnvelope(l);
        
        WktVisitor w = new WktVisitor();
        
        //Tests inutiles mais juste pour le coverage
        geo.accept(w);  
        geo.addListener(geo);
        
        assertEquals(geo.getType(), "LineString");
        assertFalse(geo.isEmpty());
        
	}
	
	@Test
	public void testClone() {
		
	    Point point = new Point(new Coordinate(2.0, 3.0));
	    List<Point> points = new ArrayList<>();
	    points.add(point);
	    LineString originalLine = new LineString(points);
	    GeometryWithCachedEnvelope originalGeometry = new GeometryWithCachedEnvelope(originalLine);

	    GeometryWithCachedEnvelope clonedGeometry = (GeometryWithCachedEnvelope) originalGeometry.clone();

	    assertNotSame(originalGeometry, clonedGeometry);
	}
}
