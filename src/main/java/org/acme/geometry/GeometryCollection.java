package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

class GeometryCollection extends AbstractGeometry {

    private List<Geometry> geometries;

    public GeometryCollection(List<Geometry> geometries) {
        this.geometries = geometries;
    }
    
    public List<Geometry> getGeometries(){
    	return this.geometries;
    }

    @Override
    public String getType() {
        return "GeometryCollection";
    }

    @Override
    public boolean isEmpty() {
        return geometries.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        for (Geometry geometry : geometries) {
            geometry.translate(dx, dy);
        }
    }
    
    @Override
    public Geometry clone() {
        List<Geometry> clonedGeometries = new ArrayList<>();
        for (Geometry geometry : geometries) {
            clonedGeometries.add(geometry.clone());
        }
        return new GeometryCollection(clonedGeometries);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void addListener(GeometryListener listener) {
        for (Geometry geometry : geometries) {
            geometry.addListener(listener);
        }
    }

    public int getNumGeometries() {
        return geometries.size();
    }

    public Geometry getGeometryN(int n) {
        return geometries.get(n);
    }
}