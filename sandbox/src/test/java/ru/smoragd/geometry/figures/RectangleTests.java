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
        }
    }
}
