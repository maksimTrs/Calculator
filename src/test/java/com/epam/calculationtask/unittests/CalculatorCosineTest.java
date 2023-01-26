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
@DisplayName("Check calculator cosineMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorCosineTest {

    static final Logger log = Logger.getLogger(CalculatorCosineTest.class.getSimpleName());

    private Calculator calculator;


    @BeforeEach
    void initTest(TestInfo testInfo) {
        calculator = new Calculator();
        log.info(() -> String.format("Was started test [%s] with method:[%s]",
                CalculatorCosineTest.class.getSimpleName(),
                testInfo.getTestMethod()));

        sleep(2);
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with method:[%s]",
                CalculatorCosineTest.class.getSimpleName(),
                testInfo.getTestMethod()));
    }


    @ParameterizedTest
    @ValueSource(doubles = {1.99, -3.19, 5, 0, -15, Double.MIN_VALUE, Double.MAX_VALUE})
    public void calcDoubleCosineMethodTest(double init) {

        assertEquals(Math.cos(init), calculator.cosineMethod(init),
                "Wrong work of Method - check the formula in this method!");
    }

}
