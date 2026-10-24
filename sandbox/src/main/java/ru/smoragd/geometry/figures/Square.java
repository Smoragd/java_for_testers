package ru.smoragd.geometry.figures;

public class Square {
    public static void printSquareArea(double c){
        System.out.println("Площадь квадрата со стороной " + c + " = " + calcSquareArea(c));
    }

    private static double calcSquareArea(double squareSide) {
        return squareSide * squareSide;
    }
}
