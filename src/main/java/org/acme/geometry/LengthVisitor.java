package org.acme.geometry;

public class LengthVisitor implements GeometryVisitor<Void> {
	private double totalLength = 0.0;

	@Override
	public Void visit(Point point) {
		return null;
	}

	@Override
	public Void visit(LineString lineString) {
		totalLength += lineString.getLength();
		return null;
	}

	@Override
	public Void visit(GeometryCollection geometryCollection) {
		for (Geometry geometry : geometryCollection.getGeometries()) {
			geometry.accept(this);
		}
		return null;
	}

	public Double getTotalLength() {
		return this.totalLength;
	}
}
