package ru.smoragd.geometry;

import ru.smoragd.geometry.figures.Rectangle;
import ru.smoragd.geometry.figures.Square;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(6.0);
        Square.printSquareArea(5.0);

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(7.2, 9.1);
    }

}
