package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

    private StringBuilder builder = new StringBuilder();

    @Override
    public void visit(Point point) {
        Coordinate coordinate = point.getCoordinate();
        builder.append("POINT(").append(coordinate.getX()).append(" ").append(coordinate.getY()).append(")");
    }

    @Override
    public void visit(LineString lineString) {
        builder.append("LINESTRING(").append(lineString.getPointN(0).getCoordinate().getX()).append(" ").append(lineString.getPointN(0).getCoordinate().getY());
        for (int i = 1; i < lineString.getNumPoints(); i++) {
            builder.append(",");
            builder.append(lineString.getPointN(i).getCoordinate().getX()).append(" ").append(lineString.getPointN(i).getCoordinate().getY());
        }
        builder.append(")");
    }

    public String getResult() {
        return builder.toString();
    }
}