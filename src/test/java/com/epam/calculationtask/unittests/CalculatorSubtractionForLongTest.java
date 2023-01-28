package com.epam.calculationtask.unittests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("smoke")
@DisplayName("Check calculator subtractionMethod() method for <long> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSubtractionForLongTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({"0,1", "1,2", "100,1", "-4, -16"})
    public void subtractionCalsForLongTest(long init, long init2) {
        Assertions.assertEquals(init - init2, calculator.subtractionMethod(init, init2));
    }
}

