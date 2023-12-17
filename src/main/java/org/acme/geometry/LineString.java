package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {

	private List<Point> points;

	public LineString() {
		this.points = new ArrayList<>();
	}

	public LineString(List<Point> points) {
		if (points != null) {
			this.points = points;
		} else {
			this.points = new ArrayList<>();
		}

	}

	public int getNumPoints() {
		return this.points.size();
	}

	public Point getPointN(int n) {
		return this.points.get(n);
	}

	@Override
	public String getType() {
		return "LineString";
	}

	@Override
	public boolean isEmpty() {
		return this.points.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		for (Point p : this.points) {
			p.translate(dx, dy);
		}
		this.triggerChange();
	}

	@Override
	public Geometry clone() {
		List<Point> tablPoint = new ArrayList<>();
		for (Point p : this.points) {
			tablPoint.add((Point) p.clone());
		}
		LineString l = new LineString(tablPoint);
		return l;
	}

	@Override
	public void accept(GeometryVisitor<Void> visitor) {
		visitor.visit(this);
	}

	public double getLength() {
		double length = 0.0;
		for (int i = 1; i < points.size(); i++) {
			length += distanceBetween(points.get(i - 1), points.get(i));
		}
		return length;
	}

	private double distanceBetween(Point p1, Point p2) {
		double dx = p2.getCoordinate().getX() - p1.getCoordinate().getX();
		double dy = p2.getCoordinate().getY() - p1.getCoordinate().getY();
		return Math.sqrt(dx * dx + dy * dy);
	}

}
