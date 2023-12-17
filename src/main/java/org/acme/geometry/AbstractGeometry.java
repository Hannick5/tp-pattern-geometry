package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {

	private List<GeometryListener> listeners = new ArrayList<>();

	public abstract Geometry clone();

	public String asText() {
		WktVisitor visitor = new WktVisitor();
		accept(visitor);
		return visitor.getResult();
	}

	public void addListener(GeometryListener listener) {
		this.listeners.add(listener);
	}

	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		accept(builder);
		Envelope result = builder.build();
		return result;
	}

	protected void triggerChange() {
		for (GeometryListener listener : this.listeners) {
			listener.onChange(this);
		}
	};
}
