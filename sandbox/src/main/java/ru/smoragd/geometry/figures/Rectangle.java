package ru.smoragd.geometry.figures;

public class Rectangle {
    public static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + calcRectangleArea(a,b));
    }

    private static double calcRectangleArea(double rectangleSide1, double rectangleSide2) {
        return rectangleSide1 * rectangleSide2;
    }
}
