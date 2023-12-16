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
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

}
