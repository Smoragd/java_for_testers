package ru.smoragd.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCalculateArea(){
        var s = new Square(5.0);
        double result = s.calcSquareArea();
        //1.Проверка через assertEquals
        Assertions.assertEquals(25.0, result);

 /*       //2.Вариант той же проверки через if-else и исключение, можно условие задать так: if (!(result==25))
        if (result!=25){
            throw new AssertionError(String.format("Expected %f, actual %f",25.0,result));
        }
 */
    }

    @Test
    void canCalculatePerimeter(){
        Assertions.assertEquals(20.0, new Square(5.0).calcSquarePerimeter());
    }

    @Test
    void cannotCreateSquareWithNegativeSide(){
        try {
            new Square (-5.0);
            Assertions.fail();
        } catch(IllegalArgumentException exception) {
            //OK
            Assertions.assertEquals("Square side should be non-negative", exception.getMessage());
            System.out.println("Выполняется: " + exception.getMessage());
        }
    }

    @Test
    void testEquality() {
        var s1 = new Square(5.0);
        var s2 = new Square(5.0);
        Assertions.assertEquals(s1, s2);
    }

    @Test
    void testNonEquality() {
        var s1 = new Square(5.0);
        var s2 = new Square(4.0);
        Assertions.assertNotEquals(s1, s2);
    }

    @Test
    void testPass() {
        var s1 = new Square(5.0);
        var s2 = new Square(5.0);
        Assertions.assertTrue(s1.equals(s2));
    }
}
