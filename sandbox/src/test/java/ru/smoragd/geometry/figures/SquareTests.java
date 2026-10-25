package ru.smoragd.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {
    @Test
    void canCalculateArea(){
        Assertions.assertEquals(16.0, Square.calcSquareArea(4.0));
    }

    @Test
    void canCalculatePerimeter(){
        Assertions.assertEquals(20.0, Square.calcSquarePerimeter(5.0));
    }
}
