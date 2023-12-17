package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry, GeometryListener {
	private Geometry original;
	private Envelope cachedEnvelope;

	public GeometryWithCachedEnvelope(Geometry original) {
		this.original = original;
		cachedEnvelope = original.getEnvelope();
		original.addListener(this);
	}

	@Override
	public String getType() {
		return this.original.getType();
	}

	@Override
	public boolean isEmpty() {
		return this.original.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		this.original.translate(dx, dy);

	}

	@Override
	public Geometry clone() {
		return new GeometryWithCachedEnvelope(this.original.clone());
	}

	@Override
	public Envelope getEnvelope() {
		return this.cachedEnvelope;
	}

	@Override
	public void accept(GeometryVisitor<Void> visitor) {
		this.original.accept(visitor);

	}

	@Override
	public void onChange(Geometry geometry) {
		this.original = geometry;
		this.cachedEnvelope = geometry.getEnvelope();

	}

	@Override
	public void addListener(GeometryListener listener) {

	}

}
