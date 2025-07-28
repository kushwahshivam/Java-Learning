package com.example.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorJUnit5Test {

    Calculator calc;

    @BeforeEach
    void init() {
        calc = new Calculator();
    }

    @AfterEach
    void cleanup() {
        calc = null;
    }

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }

    @Test
    void testIsEven() {
        assertTrue(calc.isEven(10));
        assertFalse(calc.isEven(9));
    }
}