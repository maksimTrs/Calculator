package com.epam.calculationtask.unittests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@DisplayName("Check calculator sumMethod() method for <long> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSumForLongTest extends BaseTest {


    @ParameterizedTest
    @CsvSource({"99,0", "-1,1", "1001,101", "-9999, -1"})
    public void calcLongSumMethodTest(long init, long init2) {
        assertEquals(init + init2, calculator.sumMethod(init, init2));
    }
}
