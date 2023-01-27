package com.epam.calculationtask.unittests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("smoke")
@DisplayName("Check calculator subtractionMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSubtractionForDoubleTest extends BaseClassHelper {

    @ParameterizedTest
    @CsvSource({"0, 1.22", "1.11, 2", "100, 1", "-4.99, -16.99", "-5.55, 0"})
    public void subtractionCalsForDoubleTest(double init, double init2) {
        Assertions.assertEquals(init - init2, calculator.subtractionMethod(init, init2));
    }
}

