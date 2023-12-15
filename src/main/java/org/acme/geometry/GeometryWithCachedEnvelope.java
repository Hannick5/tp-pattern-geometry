package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry{
	private Geometry original;
	private Envelope cachedEnvelope;
	
	public GeometryWithCachedEnvelope(Geometry original) {
		this.original = original;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void translate(double dx, double dy) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Envelope getEnvelope() {
	    if (cachedEnvelope == null) {
	        cachedEnvelope = original.getEnvelope();
	    }
	    return cachedEnvelope;
	}


	@Override
	public void accept(GeometryVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
		
}
