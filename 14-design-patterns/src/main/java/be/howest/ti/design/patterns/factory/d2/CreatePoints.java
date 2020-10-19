package be.howest.ti.design.patterns.factory.d2;

public class CreatePoints {

    public static void main(String[] args) {
        Point a = CartesianPoint.createFromCartesianCoordinates(10,20);
        Point b = CartesianPoint.createFromPolarCoordinates(a.r(), a.angle());

        System.out.println(a);
        System.out.println(b);

        System.out.println(a.equals(b));
    }
}
