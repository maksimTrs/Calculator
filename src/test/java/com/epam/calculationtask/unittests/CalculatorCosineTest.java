package com.epam.calculationtask.unittests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@DisplayName("Check calculator cosineMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorCosineTest extends BaseTest {


    @ParameterizedTest
    @ValueSource(doubles = {1.99, -3.19, 5, 0, -15, Double.MIN_VALUE, Double.MAX_VALUE})
    public void calcDoubleCosineMethodTest(double init) {

        assertEquals(Math.cos(init), calculator.cosineMethod(init),
                "Wrong work of Method - check the formula in this method!");
    }

}
