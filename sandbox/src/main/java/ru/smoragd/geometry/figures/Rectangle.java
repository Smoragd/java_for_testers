package ru.smoragd.geometry.figures;

import java.util.Objects;

import static javax.management.Query.or;

public record Rectangle (double a, double b) {
    //при использовании Record описание структуры(свойств) и конструктор можно не указывать - вся информация уже есть в описании класса
    //record автоматически генерирует equals, hashCode и toString, а обычный класс — нет (например, Square)

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

    //необходимо добавить, чтобы в тестах работал assertEquals для равных прямоугольников со сторонами "наоборот"
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o; //приведение входящего объекта к типу Rectangle
        return (Double.compare(this.a, rectangle.a) == 0 && Double.compare(this.b, rectangle.b) == 0)
                || (Double.compare(this.a, rectangle.b) == 0 && Double.compare(this.b, rectangle.a) == 0);
    }

    //необходимо добавить, чтобы в тестах работал assertEquals для равных прямоугольников со сторонами "наоборот"
    @Override
    public int hashCode() {
        return Objects.hash(a, b); // можно писать return 1; - чтобы не проводить проверку хэшей
    }
}
