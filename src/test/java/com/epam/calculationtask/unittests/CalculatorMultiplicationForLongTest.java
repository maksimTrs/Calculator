package com.epam.calculationtask.unittests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@DisplayName("Check calculator multiplicationMethod() method for <long> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorMultiplicationForLongTest extends BaseClassHelper {

    @ParameterizedTest
    @CsvFileSource(resources = "/calculatorlongdata.csv")
    public void calcLongMultiplicationMethodTest(long init, long init2) {
        assertEquals(init * init2, calculator.multiplicationMethod(init, init2));
    }
}
