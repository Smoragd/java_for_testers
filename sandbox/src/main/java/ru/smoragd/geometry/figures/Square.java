package ru.smoragd.geometry.figures;

public class Square {

    private double c;

    public Square(double c) {
        this.c = c;
    }

    public static void printSquareArea(Square s){
        String text = String.format("Площадь квадрата со стороной %f = %f", s.c, s.calcSquareArea());
        System.out.println(text);
    }

    public static void printSquarePerimeter(Square ss){
        String text = String.format("Периметр квадрата со стороной %f = %f", ss.c, ss.calcSquarePerimeter());
        System.out.println(text);
    }

    public double calcSquareArea() {
        return this.c*this.c;
    }

    public double calcSquarePerimeter() {
        return this.c*4;
    }
}
