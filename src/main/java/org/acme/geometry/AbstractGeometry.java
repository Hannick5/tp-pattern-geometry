package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry{
	
	public abstract Geometry clone();
	
	public String asText() {
		WktVisitor visitor = new WktVisitor();
		accept(visitor);
		return visitor.getResult();
	}
	
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		accept(builder);
		Envelope result = builder.build();
		return result;
	}
}
