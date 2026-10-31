package ru.smoragd.geometry.figures;

import java.util.Objects;

public class Triangle {

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1,double side2,double side3) {
        if (side1<0 || side2<0 || side3<0){
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if ((side1+side2)<side3 || (side1+side3)<side2 || (side2+side3)<side1) {
            throw new IllegalArgumentException("The sum of any 2 triangle sides should be not less than the 3rd side");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public static void printTriangleArea(Triangle s){
        String text = String.format("Площадь треугольника со сторонами %f,%f и %f = %f", s.side1,s.side2,s.side3, s.calcTriangleArea());
        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle s){
        String text = String.format("Периметр треугольника со сторонами %f,%f и %f = %f", s.side1,s.side2,s.side3, s.calcTrianglePerimeter());
        System.out.println(text);
    }

    public double calcTriangleArea() {
        var halfPerimeter = calcTrianglePerimeter()/2.0;
        return Math.sqrt(
                halfPerimeter*(halfPerimeter-this.side1)*(halfPerimeter-this.side2)*(halfPerimeter-this.side3)
        );
    }

    public double calcTrianglePerimeter() {
        return this.side1+this.side2+this.side3;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return
                (eq(this.side1, triangle.side1) && eq(this.side2, triangle.side2) && eq(this.side3, triangle.side3))
                || (eq(this.side1, triangle.side1) && eq(this.side2, triangle.side3) && eq(this.side3, triangle.side2))
                || (eq(this.side1, triangle.side2) && eq(this.side2, triangle.side1) && eq(this.side3, triangle.side3))
                || (eq(this.side1, triangle.side2) && eq(this.side2, triangle.side3) && eq(this.side3, triangle.side1))
                || (eq(this.side1, triangle.side3) && eq(this.side2, triangle.side1) && eq(this.side3, triangle.side2))
                || (eq(this.side1, triangle.side3) && eq(this.side2, triangle.side2) && eq(this.side3, triangle.side1));
    }
    private static boolean eq(double x, double y) {
        return Double.compare(x, y) == 0;
    }
/*
(a, b, c)
(a, c, b)
(b, a, c)
(b, c, a)
(c, a, b)
(c, b, a)
*/
    @Override
    public int hashCode() {
        return 1;
    }
}
