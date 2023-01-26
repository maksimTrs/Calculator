package com.epam.calculationtask.unittests;


import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.Logger;

import static com.epam.calculatortask.Timeout.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@DisplayName("Check calculator sqrtMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSquareRootOfANumberTest {

    static final Logger log = Logger.getLogger(CalculatorSquareRootOfANumberTest.class.getSimpleName());

    private Calculator calculator;


    @BeforeEach
    void initTest(TestInfo testInfo) {
        calculator = new Calculator();
        log.info(() -> String.format("Was started test [%s] with method:[%s]",
                CalculatorSquareRootOfANumberTest.class.getSimpleName(),
                testInfo.getTestMethod()));

        sleep(2);
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with method:[%s]",
                CalculatorSquareRootOfANumberTest.class.getSimpleName(),
                testInfo.getTestMethod()));
    }


    @ParameterizedTest
    @ValueSource(doubles = {1.99, -3.11, 5, 0, -15, Integer.MIN_VALUE, Double.MAX_VALUE})
    public void calcDoubleSquareMethodTest(double init) {

        assertEquals(Math.sqrt(Math.abs(init)), calculator.sqrtMethod(init));
    }

}
