package org.acme.geometry;

public class EnvelopeBuilder {
	private Envelope e;
	private double xmin = Double.MAX_VALUE;
    private double xmax = Double.MIN_VALUE;
    private double ymin = Double.MAX_VALUE;
    private double ymax = Double.MIN_VALUE;

    public void insert(Coordinate coordinate) {
        xmin = Math.min(xmin, coordinate.getX());
        xmax = Math.max(xmax, coordinate.getX());
        ymin = Math.min(ymin, coordinate.getY());
        ymax = Math.max(ymax, coordinate.getY());
    }

    public Envelope build() {
        return new Envelope(new Coordinate(xmin, ymin), new Coordinate(xmax, ymax));
    }
}
