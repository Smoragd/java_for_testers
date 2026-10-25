package ru.smoragd.geometry;

import ru.smoragd.geometry.figures.Rectangle;
import ru.smoragd.geometry.figures.Square;
import ru.smoragd.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(6.0));
        Square.printSquareArea(new Square (5.0));

        Square.printSquarePerimeter(new Square(2.5));
        Square.printSquarePerimeter(new Square (25.0));

        Rectangle.printRectangleArea(new Rectangle(3.0, 5.0));
        Rectangle.printRectangleArea(new Rectangle(7.2, 9.1));

        Triangle.printTriangleArea(new Triangle(6.0,6.0,6.0));
        Triangle.printTriangleArea(new Triangle(5.0,4.0,3.0));

        Triangle.printTrianglePerimeter(new Triangle(6.0,6.0,6.0));
        Triangle.printTrianglePerimeter(new Triangle(5.0,4.0,3.0));
    }

}
