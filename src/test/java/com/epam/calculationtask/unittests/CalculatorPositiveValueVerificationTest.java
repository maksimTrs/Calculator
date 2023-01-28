package com.epam.calculationtask.unittests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("smoke")
@DisplayName("Check calculator isPositiveValue() method for <long> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorPositiveValueVerificationTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 300, 11, Integer.MAX_VALUE})
    public void calcLongIsPositiveValueMethodTest(long init) {

        assertTrue(calculator.isPositiveValue(init),
                "Wrong work of Method - check the formula in this method!");
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, -300, -11, Integer.MIN_VALUE, 0})
    public void calcLongIsPositiveValueMethodTest2(long init) {

        assertFalse(calculator.isPositiveValue(init),
                "Wrong work of Method - check the formula in this method!");
    }

}
