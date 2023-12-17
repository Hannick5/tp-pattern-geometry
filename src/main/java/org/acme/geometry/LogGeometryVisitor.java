package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor<Void> {
	private final PrintStream out;

	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}

	@Override
	public Void visit(Point point) {
		if (point.isEmpty()) {
			out.print("Je suis un point vide.");
		} else {
			out.print("Je suis un point avec x=" + point.getCoordinate().getX() + " et y="
					+ point.getCoordinate().getY() + ".");
		}

		return null;
	}

	@Override
	public Void visit(LineString lineString) {
		if (lineString.isEmpty()) {
			out.print("Je suis une polyligne vide.");
		} else {
			out.print("Je suis une polyligne avec " + lineString.getNumPoints() + " points.");
		}
		return null;
	}

	@Override
	public Void visit(GeometryCollection geometryCollection) {
		if (geometryCollection.isEmpty()) {
			out.print("Je suis une collection vide de géométries.");
		} else {
			out.print("Je suis une collection de " + geometryCollection.getNumGeometries() + " géométries.");
		}
		return null;
	}

}
