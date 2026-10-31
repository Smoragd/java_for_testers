package ru.smoragd.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {

    @Test
    void canCalculateArea(){
        var s = new Rectangle(4.0,6.0);
        double result = s.calcRectangleArea();
        Assertions.assertEquals(24.0, result);
    }

    @Test
    void cannotCreateRectangleWithNegativeSide(){
        try {
            new Rectangle (-5.0, 3.0);
            Assertions.fail();
        } catch(IllegalArgumentException exception) {
            //OK
            Assertions.assertEquals("Rectangle side should be non-negative", exception.getMessage());
            System.out.println("Выполняется: " + exception.getMessage());
        }
    }

    @Test
    void testEquality() {
        var r1 = new Rectangle(5.0,7.0);
        var r2 = new Rectangle(5.0,7.0);
        Assertions.assertEquals(r1, r2);
    }

    @Test
    void testEquality2() {
        var r1 = new Rectangle(5.0,7.0);
        var r2 = new Rectangle(7.0,5.0);
        Assertions.assertEquals(r1, r2);
    }
}
