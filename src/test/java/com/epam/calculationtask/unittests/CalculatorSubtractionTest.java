package com.epam.calculationtask.unittests;

import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.logging.Logger;

@Tag("regression")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSubtractionTest {
    static final Logger log = Logger.getLogger(CalculatorSubtractionTest.class.getSimpleName());

    Calculator calculator;


    @BeforeEach
    void beforeEachTest() {
        calculator = new Calculator();

        log.info(() -> String.format("Was started test [%s]", CalculatorSubtractionTest.class.getMethods()[0].toString()));
    }

    @AfterEach
    void afterEachTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with parameters:[%s]",
                CalculatorSubtractionTest.class.getMethods()[0].toString(),
                testInfo.getDisplayName().toUpperCase()));
    }


    //@Test
    @ParameterizedTest
    @CsvSource({"0,1", "1,2", "100,1", "-4, -16"})
    public void sumCalsTest(int init, int init2) {
        Assertions.assertEquals(init - init2, calculator.sub(init, init2));
    }
}

