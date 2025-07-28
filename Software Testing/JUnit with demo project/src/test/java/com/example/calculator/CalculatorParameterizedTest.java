package com.example.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorParameterizedTest {

    Calculator calc = new Calculator();

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
        "1, 2, 3",
        "3, 5, 8",
        "-1, 1, 0",
        "0, 0, 0"
    })
    void testAddition(int a, int b, int expected) {
        assertEquals(expected, calc.add(a, b));
    }
}