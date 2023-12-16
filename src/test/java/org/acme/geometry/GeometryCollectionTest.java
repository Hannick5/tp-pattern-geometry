package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GeometryCollectionTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void createGeometryCollectionWithEmptyList() {
	  GeometryCollection geometryCollection = new GeometryCollection(new ArrayList<>());
	  assertTrue(geometryCollection.isEmpty());
	}
	
	@Test
	public void createGeometryCollectionWithSinglePoint() {
	  Geometry point = new Point(new Coordinate(1.0, 2.0));
	  List<Geometry> listGeom = new ArrayList<Geometry>();
	  listGeom.add(point);
	  GeometryCollection geometryCollection = new GeometryCollection(listGeom);
	  assertFalse(geometryCollection.isEmpty());
	  assertEquals(geometryCollection.getNumGeometries(), 1, EPSILON);
	  assertSame(geometryCollection.getGeometryN(0), point);

	  geometryCollection.translate(1.0, 3.0);
	  
	  Point pointTranslated = (Point) geometryCollection.getGeometryN(0);
	  
	  assertEquals(pointTranslated.getCoordinate().getX(), 2.0, EPSILON);
	  assertEquals(pointTranslated.getCoordinate().getY(), 5.0, EPSILON);
	  
	  assertEquals(geometryCollection.getType(), "GeometryCollection");
	  assertEquals(geometryCollection.getGeometries(), listGeom);
	}

	@Test
	public void getEnvelopeForGeometryCollectionWithOnePoint() {
	  Geometry point = new Point(new Coordinate(1.0, 2.0));
	  List<Geometry> listGeom = new ArrayList<Geometry>();
	  listGeom.add(point);
	  
	  GeometryCollection geometryCollection = new GeometryCollection(listGeom);

	  Envelope envelope = geometryCollection.getEnvelope();
	  
	  assertEquals(envelope.getXmin(), 1.0, EPSILON);
	  assertEquals(envelope.getYmin(), 2.0, EPSILON);
	  assertEquals(envelope.getXmax(), 1.0, EPSILON);
	  assertEquals(envelope.getYmax(), 2.0, EPSILON);
	}

	@Test
	public void getEnvelopeForGeometryCollectionWithMultipleGeometries() {
	  Geometry point = new Point(new Coordinate(1.0, 5.0));
	  Coordinate c1 = new Coordinate(3.0, 4.0);
	  Coordinate c2 = new Coordinate(2.0, 5.0);
	  Coordinate c3 = new Coordinate(6.0, 9.0);
	
      Point p1 = new Point(c1);
	  Point p2 = new Point(c2);
	  Point p3 = new Point(c3);
		
      List<Point> listPoint = Arrays.asList(p1, p2, p3);
		
	  LineString linestring = new LineString(listPoint);

	  List<Geometry> listGeom = new ArrayList<Geometry>();
	  listGeom.add(point);
	  listGeom.add(linestring);
	  
	  GeometryCollection geometryCollection = new GeometryCollection(listGeom);

	  Envelope envelope = geometryCollection.getEnvelope();
	  assertEquals(envelope.getXmin(), 1.0, EPSILON);
	  assertEquals(envelope.getYmin(), 4.0, EPSILON);
	  assertEquals(envelope.getXmax(), 6.0, EPSILON);
	  assertEquals(envelope.getYmax(), 9.0, EPSILON);
	}
	
	@Test
	public void cloneGeometryCollectionWithEmptyGeometries() {
	  GeometryCollection geometryCollection = new GeometryCollection(new ArrayList<>());
	  GeometryCollection clonedGeometryCollection = (GeometryCollection) geometryCollection.clone();

	  assertEquals(clonedGeometryCollection.getNumGeometries(), 0, EPSILON);
	}

	@Test
	public void cloneGeometryCollectionWithOnePoint() {
	  Geometry point = new Point(new Coordinate(1.0, 2.0));
	  
	  List<Geometry> listGeom = new ArrayList<Geometry>();
	  listGeom.add(point);
	  
	  GeometryCollection geometryCollection = new GeometryCollection(listGeom);
	  
	  GeometryCollection clonedGeometryCollection = (GeometryCollection) geometryCollection.clone();

	  assertEquals(clonedGeometryCollection.getNumGeometries(), 1, EPSILON);
	  assertNotSame(clonedGeometryCollection.getGeometryN(0), point);
	}

	@Test
	public void cloneGeometryCollectionWithMultipleGeometries() {
	  Geometry point = new Point(new Coordinate(1.0, 5.0));
	  
	  Coordinate c1 = new Coordinate(3.0, 4.0);
	  Coordinate c2 = new Coordinate(2.0, 5.0);
	  Coordinate c3 = new Coordinate(6.0, 9.0);
	
      Point p1 = new Point(c1);
	  Point p2 = new Point(c2);
	  Point p3 = new Point(c3);
		
      List<Point> listPoint = Arrays.asList(p1, p2, p3);
	  
	  LineString linestring = new LineString(listPoint);
	  List<Geometry> listGeom = new ArrayList<Geometry>();
	  
	  listGeom.add(point);
	  listGeom.add(linestring);
	  
	  GeometryCollection geometryCollection = new GeometryCollection(listGeom);

	  GeometryCollection clonedGeometryCollection = (GeometryCollection) geometryCollection.clone();

	  assertEquals(clonedGeometryCollection.getNumGeometries(), 2);
	  assertNotSame(clonedGeometryCollection.getGeometryN(0), point);
	  assertNotSame(clonedGeometryCollection.getGeometryN(1), linestring);
	}

}
