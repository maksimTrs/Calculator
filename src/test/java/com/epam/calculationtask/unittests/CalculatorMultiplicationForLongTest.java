package com.epam.calculationtask.unittests;

import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.logging.Logger;

import static com.epam.calculatortask.Timeout.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@DisplayName("Check calculator multiplicationMethod() method for <long> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorMultiplicationForLongTest {

    static final Logger log = Logger.getLogger(CalculatorMultiplicationForLongTest.class.getSimpleName());

    private Calculator calculator;


    @BeforeEach
    void initTest(TestInfo testInfo) {
        calculator = new Calculator();
        log.info(() -> String.format("Was started test [%s] with method:[%s]",
                CalculatorMultiplicationForLongTest.class.getSimpleName(),
                testInfo.getTestMethod()));

        sleep(2);
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with method:[%s]",
                CalculatorMultiplicationForLongTest.class.getSimpleName(),
                testInfo.getTestMethod()));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/calculatorlongdata.csv")
    public void calcLongMultiplicationMethodTest(long init, long init2) {
        assertEquals(init * init2, calculator.multiplicationMethod(init, init2));
    }
}
