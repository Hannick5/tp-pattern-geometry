package org.acme.geometry;

public class EnvelopeBuilder implements GeometryVisitor<Void> {
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
	public Void visit(Point point) {
		this.insert(point.getCoordinate());
		return null;
	}

	@Override
	public Void visit(LineString lineString) {
		for (int i = 0; i < lineString.getNumPoints(); i++) {
			this.insert(lineString.getPointN(i).getCoordinate());
		}
		return null;
	}

	@Override
	public Void visit(GeometryCollection geometryCollection) {
		for (Geometry geometry : geometryCollection.getGeometries()) {
			geometry.accept(this);
		}
		return null;
	}
}
