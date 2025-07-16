package com.example.springbootfirst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCalculatorClass {
    Calculator cal = new Calculator();

    @Test
    void testAddition() {
        System.out.println(cal.add(3, 4));
        assertEquals(7, cal.add(3, 4));
    }

    @Test
    void testSub() {
        System.out.println(cal.add(10, 5));
        assertEquals(5, cal.sub(10, 5));
    }

    @Test
    void testMultiplication() {
        System.out.println(cal.add(4, 5));
        assertEquals(20, cal.multiply(4, 5));
    }

    @Test
    void testDivision() {
        System.out.println(cal.add(9, 3));
        assertEquals(3, cal.divide(9, 3));
    }

}
