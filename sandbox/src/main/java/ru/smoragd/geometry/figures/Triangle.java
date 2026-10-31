package ru.smoragd.geometry.figures;

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
}
