package org.acme.geometry;

public class Point implements Geometry{
	private Coordinate coordinate;
	
	Point(){
		this.coordinate = new Coordinate();
	}
	
	Point(Coordinate coordinate){
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate(){
		return this.coordinate;
	}

	@Override
	public String getType() {
		return "Point";
	}
	
}
