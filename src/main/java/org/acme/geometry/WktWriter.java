package org.acme.geometry;

public class WktWriter {

	public String write(Geometry geometry) {
		String result = geometry.getType().toUpperCase();

		if (geometry.isEmpty()) {
			result += " EMPTY";
		} else {

			if (geometry instanceof Point) {
				Point point = (Point) geometry;
				result += "(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")";
			} else if (geometry instanceof LineString) {
				LineString lineString = (LineString) geometry;
				result += "(";
				for (int i = 0; i < lineString.getNumPoints(); i++) {
					Point p = lineString.getPointN(i);
					result += p.getCoordinate().getX() + " " + p.getCoordinate().getY();
					if (i < lineString.getNumPoints() - 1) {
						result += ",";
					}
				}
				result += ")";
			} else {
				throw new RuntimeException("geometry type not supported");
			}
		}
		return result;
	}
}
