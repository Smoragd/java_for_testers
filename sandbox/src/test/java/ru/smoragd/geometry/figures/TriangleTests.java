package ru.smoragd.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea(){
        var s = new Triangle(5.0,4.0,3.0);
        double result = s.calcTriangleArea();
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void canCalculatePerimeter(){
        Assertions.assertEquals(12.0, new Triangle(5.0,4.0,3.0).calcTrianglePerimeter());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide(){
        try {
            new Triangle (5.0, 4.0, -3.0);
            Assertions.fail();
        } catch(IllegalArgumentException exception) {
            //OK
            Assertions.assertEquals("Triangle side should be non-negative", exception.getMessage());
            System.out.println("Выполняется: " + exception.getMessage());
        }
    }

    @Test
    void cannotCreateTriangleWithTooSmallSidesSum(){
        try {
            new Triangle (6.0, 4.0, 1.0);
            Assertions.fail();
        } catch(IllegalArgumentException exception) {
            //OK
            Assertions.assertEquals("The sum of any 2 triangle sides should be not less than the 3rd side",
                    exception.getMessage());
            System.out.println("Выполняется: " + exception.getMessage());
        }
    }

    @Test
    void testEquality() {
        var t1 = new Triangle(5.0,7.0,9.0);
        var t2 = new Triangle(5.0,7.0,9.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality2() {
        var t1 = new Triangle(5.0,7.0,9.0);
        var t2 = new Triangle(9.0,5.0,7.0);
        Assertions.assertEquals(t1, t2);
    }

   @Test
    void testNonEquality() {
        var t1 = new Triangle(5.0,7.0,9.0);
        var t2 = new Triangle(5.0,7.0,10.0);
        Assertions.assertNotEquals(t1, t2);
    }

    @Test
    void testPass() {
        var t1 = new Triangle(5.0,7.0,9.0);
        var t2 = new Triangle(5.0,7.0,9.0);
        Assertions.assertTrue(t1.equals(t2));
    }
}
