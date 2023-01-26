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
@DisplayName("Check calculator cotangentMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorCotangentTest {

    static final Logger log = Logger.getLogger(CalculatorCotangentTest.class.getSimpleName());

    private Calculator calculator;


    @BeforeEach
    void initTest(TestInfo testInfo) {
        calculator = new Calculator();
        log.info(() -> String.format("Was started test [%s] with method:[%s]",
                CalculatorCotangentTest.class.getSimpleName(),
                testInfo.getTestMethod()));

        sleep(2);
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with method:[%s]",
                CalculatorCotangentTest.class.getSimpleName(),
                testInfo.getTestMethod()));
    }


    @ParameterizedTest
    @ValueSource(doubles = {1.99, -3.11, 5, 0, -15, Double.MIN_VALUE, Double.MAX_VALUE})
    public void calcDoubleCotangentMethodTest(double init) {

        assertEquals(Math.tanh(init), calculator.cotangentMethod(init),
                "Wrong work of Method - check the formula in this method!");
    }
}
