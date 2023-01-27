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
@DisplayName("Check calculator isNegativeValue() method for <long> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorNegativeValueVerificationTest extends BaseClassHelper {


    @ParameterizedTest
    @ValueSource(ints = {1, 300, 11, Integer.MAX_VALUE, 0})
    public void calcLongIsNegativeValueMethodTest(long init) {

        assertFalse(calculator.isNegativeValue(init),
                "Wrong work of Method - check the formula in this method!");
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, -300, -11, Integer.MIN_VALUE})
    public void calcLongIsNegativeValueMethodTest2(long init) {

        assertTrue(calculator.isNegativeValue(init),
                "Wrong work of Method - check the formula in this method!");
    }

}
