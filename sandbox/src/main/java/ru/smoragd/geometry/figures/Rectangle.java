package ru.smoragd.geometry.figures;

import static javax.management.Query.or;

public record Rectangle (double a, double b) {
    //при использовании Record описание структуры(свойств) и конструктор можно не указывать - вся информация уже есть в описании класса

    //Для инфо: порядок вычисления (от высшего к низшему): сначала ! (НЕ), потом && (И), потом || (ИЛИ)

    public Rectangle {
        if (a<0 || b<0){
            throw new IllegalArgumentException("Rectangle side should be non-negative");
        }
    }

    public static void printRectangleArea(Rectangle s) {
        String text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", s.a, s.b, s.calcRectangleArea());
        System.out.println(text);
    }

    public double calcRectangleArea() {
        return this.a*this.b;
    }
}
