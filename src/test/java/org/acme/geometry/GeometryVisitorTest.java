package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GeometryVisitorTest {
	@Test
	public void TestVisitor() throws UnsupportedEncodingException {
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		geometry.accept(visitor);
		String result = os.toString("UTF8");
		
		assertEquals(result, "Je suis un point avec x=3.0 et y=4.0.");
		
		//////////////////////////////////////////////////////////////////////
		
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(2.0, 5.0);
		Coordinate c3 = new Coordinate(6.0, 9.0);

		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point p3 = new Point(c3);
		
		List<Point> listPoint = Arrays.asList(p1, p2, p3);
		
		LineString l = new LineString(listPoint);
		
		ByteArrayOutputStream os2 = new ByteArrayOutputStream();
		PrintStream out2 = new PrintStream(os2);
		
		LogGeometryVisitor visitor2 = new LogGeometryVisitor(out2);
		l.accept(visitor2);	
		String result2 = os2.toString("UTF8");
		
		assertEquals(result2, "Je suis une polyligne avec 3 points.");
		
		///////////////////////////////////////////////////////////////////////
		
		Point p = new Point();
		ByteArrayOutputStream os3 = new ByteArrayOutputStream();
		PrintStream out3 = new PrintStream(os3);
		
		LogGeometryVisitor visitor3 = new LogGeometryVisitor(out3);
		p.accept(visitor3);	
		String result3 = os3.toString("UTF8");
		
		assertEquals(result3, "Je suis un point vide.");
		
		///////////////////////////////////////////////////////////////////////
				
		LineString line = new LineString();
		ByteArrayOutputStream os4 = new ByteArrayOutputStream();
		PrintStream out4 = new PrintStream(os4);
		
		LogGeometryVisitor visitor4 = new LogGeometryVisitor(out4);
		line.accept(visitor4);	
		String result4 = os4.toString("UTF8");
		
		assertEquals(result4, "Je suis une polyligne vide.");
		///////////////////////////////////////////////////////////////////////

		GeometryCollection geometryCollection = new GeometryCollection(Arrays.asList(
		new Point(new Coordinate(1.0, 2.0)),
		new Point(new Coordinate(3.0, 4.0))));
		
		ByteArrayOutputStream os5 = new ByteArrayOutputStream();
		PrintStream out5 = new PrintStream(os5);
		
		LogGeometryVisitor visitor5 = new LogGeometryVisitor(out5);
		geometryCollection.accept(visitor5);
		String result5 = os5.toString("UTF8");
		
		assertEquals(result5, "Je suis une collection de 2 géométries.");
		
		///////////////////////////////////////////////////////////////////////
		
		GeometryCollection emptyGeometryCollection = new GeometryCollection(new ArrayList<>());
		
		ByteArrayOutputStream os6 = new ByteArrayOutputStream();
		PrintStream out6 = new PrintStream(os6);
		
		LogGeometryVisitor visitor6 = new LogGeometryVisitor(out6);
		emptyGeometryCollection.accept(visitor6);
		String result6 = os6.toString("UTF8");
		
		assertEquals(result6, "Je suis une collection vide de géométries.");

	}
}
