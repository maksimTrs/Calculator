package com.epam.calculationtask.unittests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@DisplayName("Check calculator cotangentMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorCotangentTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(doubles = {1.99, -3.11, 5, 0, -15, Double.MIN_VALUE, Double.MAX_VALUE})
    public void calcDoubleCotangentMethodTest(double init) {

        assertEquals(Math.tanh(init), calculator.cotangentMethod(init),
                "Wrong work of Method - check the formula in this method!");
    }
}
