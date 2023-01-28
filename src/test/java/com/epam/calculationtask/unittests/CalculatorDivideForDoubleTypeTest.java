package com.epam.calculationtask.unittests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@DisplayName("Check calculator divideMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorDivideForDoubleTypeTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({"33.33, 11.11", "-11, 43.99", "-100, -10001", "0, 55"})
    public void calcDoubleDivideMethodTest(double init, double init2) {

        assertEquals(init / init2, calculator.divideMethod(init, init2));
    }


}
