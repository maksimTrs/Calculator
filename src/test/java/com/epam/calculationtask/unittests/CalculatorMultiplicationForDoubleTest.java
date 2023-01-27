package com.epam.calculationtask.unittests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Tag("smoke")
@DisplayName("Check calculator multiplicationMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorMultiplicationForDoubleTest extends BaseClassHelper {

    @ParameterizedTest
    @CsvFileSource(resources = "/calculatordoubledata.csv")
    public void calcDoubleMultiplicationMethodTest(double init, double init2) {
        assertEquals(Math.floor(init * init2), calculator.multiplicationMethod(init, init2));
    }
}
