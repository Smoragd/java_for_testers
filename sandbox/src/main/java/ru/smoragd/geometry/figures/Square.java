package ru.smoragd.geometry.figures;

public class Square {

    private double c;

    public Square(double c) {
        if (c<0){
            throw new IllegalArgumentException("Square side should be non-negative");
        }
        this.c = c;
    }

    public static void printSquareArea(Square s){
        String text = String.format("Площадь квадрата со стороной %f = %f", s.c, s.calcSquareArea());
        System.out.println(text);
    }

    public static void printSquarePerimeter(Square s){
        String text = String.format("Периметр квадрата со стороной %f = %f", s.c, s.calcSquarePerimeter());
        System.out.println(text);
    }

    public double calcSquareArea() {
        return this.c*this.c;
    }

    public double calcSquarePerimeter() {
        return this.c*4;
    }

    //необходимо добавить, чтобы в тестах работал assertEquals, тк Square - обычный class, а не record
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.c, c) == 0;
    }

    //необходимо добавить, чтобы в тестах работал assertEquals, тк Square - обычный class, а не record
    @Override
    public int hashCode() {
        return Double.hashCode(c);
    }
}
