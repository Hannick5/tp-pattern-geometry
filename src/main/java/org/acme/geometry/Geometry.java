package org.acme.geometry;

public interface Geometry {
	public String getType();

	public boolean isEmpty();

	public void translate(double dx, double dy);

	public Envelope getEnvelope();

	public void accept(GeometryVisitor<Void> visitor);

	public void addListener(GeometryListener listener);

	public Geometry clone();
}
