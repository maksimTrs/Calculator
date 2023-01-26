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
@DisplayName("Check calculator multiplicationMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorMultiplicationForDoubleTest {

    static final Logger log = Logger.getLogger(CalculatorMultiplicationForDoubleTest.class.getSimpleName());

    private Calculator calculator;


    @BeforeEach
    void initTest(TestInfo testInfo) {
        calculator = new Calculator();
        log.info(() -> String.format("Was started test [%s] with method:[%s]",
                CalculatorMultiplicationForDoubleTest.class.getSimpleName(),
                testInfo.getTestMethod()));

        sleep(2);
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with method:[%s]",
                CalculatorMultiplicationForDoubleTest.class.getSimpleName(),
                testInfo.getTestMethod()));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/calculatordoubledata.csv")
    public void calcDoubleMultiplicationMethodTest(double init, double init2) {
        assertEquals(Math.floor(init * init2), calculator.multiplicationMethod(init, init2));
    }
}
