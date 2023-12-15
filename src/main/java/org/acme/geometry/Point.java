package org.acme.geometry;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Point implements Geometry{
	private Coordinate coordinate;
	
	public Point(){
		this.coordinate = new Coordinate();
	}
	
	public Point(Coordinate coordinate){
		if(coordinate != null) {
			this.coordinate = coordinate;
		}
		else {
			this.coordinate = new Coordinate();
		}
		
	}
	
	public Coordinate getCoordinate(){
		return this.coordinate;
	}

	@Override
	public String getType() {
		return "Point";
	}
	
	@Override
	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}
	
	@Override
	public void translate(double dx, double dy) {
		Coordinate newCoord = new Coordinate(this.coordinate.getX() + dx, this.coordinate.getY() + dy);
		this.coordinate = newCoord;
	}
	
	@Override
	public Geometry clone() {
		Point p = new Point(this.getCoordinate());
		return p;
	}
	
}
