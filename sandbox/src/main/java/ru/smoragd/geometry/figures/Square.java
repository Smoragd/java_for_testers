package ru.smoragd.geometry.figures;

public class Square {
    public static void printSquareArea(double c){
        String text = String.format("Площадь квадрата со стороной %f = %f", c, calcSquareArea(c));
        System.out.println(text);
    }

    public static double calcSquareArea(double squareSide) {
        return squareSide * squareSide;
    }

    public static double calcSquarePerimeter(double squareSide) {
        return squareSide * 4;
    }
}
