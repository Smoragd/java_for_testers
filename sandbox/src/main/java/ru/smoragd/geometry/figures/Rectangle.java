package ru.smoragd.geometry.figures;

public record Rectangle (double a, double b) {
    //при использовании Record описание структуры(свойств) и конструктор можно не указывать - вся информация уже есть в описании класса

    public static void printRectangleArea(Rectangle s) {
        String text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", s.a, s.b, s.calcRectangleArea());
        System.out.println(text);
    }

    public double calcRectangleArea() {
        return this.a*this.b;
    }
}
