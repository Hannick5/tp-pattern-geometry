package org.acme.geometry;

public class Coordinate {
	
	private double x = Double.NaN;
	private double y = Double.NaN;
	
public Coordinate() {
	
}

public Coordinate(double x, double y) {
	super();
	this.x = x;
	this.y = y;
}

public double getX() {
	return x;
}


public double getY() {
	return y;
}


public boolean isEmpty() {
	 if (Double.isNaN(x) || Double.isNaN(y)) {
		return true;
	} else {
		return false;
	}
}

@Override
public String toString() {
    if (isEmpty()) {
        return "[NaN,NaN]";
    } else {
        return "["+ x +","+ y +"]";
    }
}

}