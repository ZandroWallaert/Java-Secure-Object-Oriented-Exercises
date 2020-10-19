package be.howest.ti.design.patterns.factory.d2;

import java.util.Objects;

public class CartesianPoint implements Point {

    private final double x;
    private final double y;

    public CartesianPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "CartesianPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static Point createFromCartesianCoordinates(double x, double y) {

        return new CartesianPoint(x, y);
    }

    public static Point createFromPolarCoordinates(double r, double angle) {
        return new CartesianPoint(
                r*Math.cos(angle),
                r*Math.sin(angle)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartesianPoint that = (CartesianPoint) o;
        return Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public double x() {
        return x;
    }

    @Override
    public double y() {
        return y;
    }

    @Override
    public double r() {
        return Math.sqrt((x*x)+(y*y));
    }

    @Override
    public double angle() {
        return Math.atan(y/x);
    }
}
