package com.epam.calculationtask.unittests;

import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Tag("smoke")
@DisplayName("Check calculator sum() method logic work")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSumTest {

    static final Logger log = Logger.getLogger(CalculatorSumTest.class.getSimpleName());

    private Calculator calculator;


    @BeforeEach
    void initTest() {
        calculator = new Calculator();

        log.info(() -> String.format("Was started test [%s]", CalculatorSumTest.class.getMethods()[0].toString()));
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with parameters:[%s]",
                CalculatorSumTest.class.getMethods()[0].toString(),
                testInfo.getDisplayName().toUpperCase()));
    }


    //@Test
    @ParameterizedTest
    @CsvSource({"99,0", "-1,1", "1001,101", "-9999, -1"})
    public void calcSumMethodTest(long init, long init2) {
        assertEquals(init + init2, calculator.sum(init, init2));
    }

    @ParameterizedTest
    @CsvSource({"9223372036854775807, 1"})
    public void calcSumMethodWithTechnicalBoundaryTest(long init, long init2) {
        boolean isTechnicalBoundaryForLongExceeded = (init + init2) < 0;

        assertFalse(isTechnicalBoundaryForLongExceeded,
                "Technical Boundary For <long> type was exceeded: " + (init + init2));
    }
}
