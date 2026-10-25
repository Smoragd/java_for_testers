package ru.smoragd.geometry.figures;

public class Rectangle {
    public static void printRectangleArea(double a, double b) {
        String text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", a, b, calcRectangleArea(a, b));
        System.out.println(text);
    }

    private static double calcRectangleArea(double rectangleSide1, double rectangleSide2) {
        return rectangleSide1 * rectangleSide2;
    }
}
