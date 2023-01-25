package com.epam.calculationtask.tests;

import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.logging.Logger;

@Tag("smoke")
@Execution(ExecutionMode.CONCURRENT)
public class CalculationSumTest {

    static final Logger log = Logger.getLogger(CalculationSumTest.class.getName());

    Calculator calculator;


    @BeforeEach
    void beforeEachTest(TestInfo testInfo) {
        calculator = new Calculator();

        log.info(() -> String.format("Was started test [%s]", CalculationSumTest.class.getMethods()[0].toString()));
    }

    @AfterEach
    void afterEachTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with parameters:[%s]",
                CalculationSumTest.class.getMethods()[0].toString(),
                testInfo.getDisplayName().toUpperCase()));
    }


    //@Test
    @ParameterizedTest
    @CsvSource({"0,0", "1,2", "100,1"})
    public void sumCalsTest(int init, int init2) {
        Assertions.assertEquals(init + init2, calculator.sum(init, init2));
    }
}
