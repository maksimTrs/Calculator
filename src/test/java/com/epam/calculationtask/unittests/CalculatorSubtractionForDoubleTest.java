package com.epam.calculationtask.unittests;


import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.logging.Logger;

import static com.epam.calculatortask.Timeout.sleep;

@Tag("smoke")
@DisplayName("Check calculator subtractionMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSubtractionForDoubleTest {
    static final Logger log = Logger.getLogger(CalculatorSubtractionForDoubleTest.class.getSimpleName());

    private Calculator calculator;


    @BeforeEach
    void initTest(TestInfo testInfo) {
        calculator = new Calculator();
        log.info(() -> String.format("Was started test [%s] with method:[%s]",
                CalculatorSubtractionForDoubleTest.class.getSimpleName(),
                testInfo.getTestMethod()));

        sleep(2);
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with method:[%s]",
                CalculatorSubtractionForDoubleTest.class.getSimpleName(),
                testInfo.getTestMethod()));
    }


    @ParameterizedTest
    @CsvSource({"0, 1.22", "1.11, 2", "100, 1", "-4.99, -16.99", "-5.55, 0"})
    public void subtractionCalsForDoubleTest(double init, double init2) {
        Assertions.assertEquals(init - init2, calculator.subtractionMethod(init, init2));
    }
}

