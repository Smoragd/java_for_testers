public class Geometry {
    public static void main(String[] args) {
        printSquareArea(6.0);
        printSquareArea(5.0);

        printRectangleArea(3.0, 5.0);
        printRectangleArea(7.2, 9.1);
    }

    private static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + calcRectangleArea(a,b));
    }

    static void printSquareArea(double c){
        System.out.println("Площадь квадрата со стороной " + c + " = " + calcSquareArea(c));
    }

    private static double calcRectangleArea(double rectangleSide1, double rectangleSide2) {
        return rectangleSide1 * rectangleSide2;
    }

    private static double calcSquareArea(double squareSide) {
        return squareSide * squareSide;
    }

    ;

}
