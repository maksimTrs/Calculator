package com.epam.calculationtask.unittests;


import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.Logger;

import static com.epam.calculatortask.Timeout.sleep;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("smoke")
@DisplayName("Check calculator isNegativeValue() method for <long> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorNegativeValueVerificationTest {

    static final Logger log = Logger.getLogger(CalculatorNegativeValueVerificationTest.class.getSimpleName());

    private Calculator calculator;


    @BeforeEach
    void initTest(TestInfo testInfo) {
        calculator = new Calculator();
        log.info(() -> String.format("Was started test [%s] with method:[%s]",
                CalculatorNegativeValueVerificationTest.class.getSimpleName(),
                testInfo.getTestMethod()));

        sleep(2);
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with method:[%s]",
                CalculatorNegativeValueVerificationTest.class.getSimpleName(),
                testInfo.getTestMethod()));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 300, 11, Integer.MAX_VALUE, 0})
    public void calcLongIsNegativeValueMethodTest(long init) {

        assertFalse(calculator.isNegativeValue(init),
                "Wrong work of Method - check the formula in this method!");
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, -300, -11, Integer.MIN_VALUE})
    public void calcLongIsNegativeValueMethodTest2(long init) {

        assertTrue(calculator.isNegativeValue(init),
                "Wrong work of Method - check the formula in this method!");
    }

}
