package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {
	private final PrintStream out;
	
	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}

	@Override
	public void visit(Point point) {
		if(point.isEmpty()) {
			out.print("Je suis un point vide.");
		}
		else {
			Coordinate coordinate = point.getCoordinate();
	        out.print("Je suis un point avec x=" + coordinate.getX() + " et y=" + coordinate.getY() + ".");
		}
	}

	@Override
	public void visit(LineString lineString) {
		if(lineString.isEmpty()) {
			out.print("Je suis une polyligne vide.");
		}
		else {
			out.print("Je suis une polyligne avec " + lineString.getNumPoints() + 
					   " points.");
		}
	}
	
}
