package ru.smoragd.geometry.figures;

public class Triangle {

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1,double side2,double side3) {
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
}
