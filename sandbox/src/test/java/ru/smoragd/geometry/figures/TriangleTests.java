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
}
