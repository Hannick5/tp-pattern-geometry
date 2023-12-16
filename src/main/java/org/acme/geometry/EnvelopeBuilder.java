package org.acme.geometry;

public class EnvelopeBuilder implements GeometryVisitor{
	private double xmin = Double.MAX_VALUE;
    private double xmax = Double.MIN_VALUE;
    private double ymin = Double.MAX_VALUE;
    private double ymax = Double.MIN_VALUE;

    public void insert(Coordinate coordinate) {
        xmin = Math.min(xmin, coordinate.getX());
        xmax = Math.max(xmax, coordinate.getX());
        ymin = Math.min(ymin, coordinate.getY());
        ymax = Math.max(ymax, coordinate.getY());
    }

    public Envelope build() {
        return new Envelope(new Coordinate(xmin, ymin), new Coordinate(xmax, ymax));
    }

	@Override
	public void visit(Point point) {
		this.insert(point.getCoordinate());
	}

	@Override
	public void visit(LineString lineString) {
		for(int i = 0; i < lineString.getNumPoints(); i++) {
			this.insert(lineString.getPointN(i).getCoordinate());
		}		
	}
	
	public void visit(GeometryCollection geometryCollection) {
	    for (Geometry geometry : geometryCollection.getGeometries()) {
	        geometry.accept(this);
	    }
	}
}
