package org.acme.geometry;

public class WktVisitor implements GeometryVisitor<Void> {

	private StringBuilder builder = new StringBuilder();

	@Override
	public Void visit(Point point) {
		Coordinate coordinate = point.getCoordinate();
		builder.append("POINT(").append(coordinate.getX()).append(" ").append(coordinate.getY()).append(")");
		return null;
	}

	@Override
	public Void visit(LineString lineString) {
		builder.append("LINESTRING(").append(lineString.getPointN(0).getCoordinate().getX()).append(" ")
				.append(lineString.getPointN(0).getCoordinate().getY());
		for (int i = 1; i < lineString.getNumPoints(); i++) {
			builder.append(",");
			builder.append(lineString.getPointN(i).getCoordinate().getX()).append(" ")
					.append(lineString.getPointN(i).getCoordinate().getY());
		}
		builder.append(")");
		return null;
	}

	@Override
	public Void visit(GeometryCollection geometryCollection) {
		builder.append("GEOMETRYCOLLECTION(");
		for (Geometry geometry : geometryCollection.getGeometries()) {
			geometry.accept(this);
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1).append(")");
		return null;
	}

	public String getResult() {
		return builder.toString();
	}
}