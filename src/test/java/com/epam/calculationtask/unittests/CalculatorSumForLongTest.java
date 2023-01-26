package com.epam.calculationtask.unittests;

import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@DisplayName("Check calculator sumMethod() method for <long> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSumForLongTest {

    static final Logger log = Logger.getLogger(CalculatorSumForLongTest.class.getSimpleName());

    private Calculator calculator;


    @BeforeEach
    void initTest() {
        calculator = new Calculator();

        log.info(() -> String.format("Was started test [%s]", CalculatorSumForLongTest.class.getMethods()[0].toString()));
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with parameters:[%s]",
                CalculatorSumForLongTest.class.getMethods()[0].toString(),
                testInfo.getDisplayName().toUpperCase()));
    }


    @ParameterizedTest
    @CsvSource({"99,0", "-1,1", "1001,101", "-9999, -1"})
    public void calcLongSumMethodTest(long init, long init2) {
        assertEquals(init + init2, calculator.sumMethod(init, init2));
    }
}
