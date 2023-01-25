package com.epam.calculationtask.unittests;

import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("smoke")
@DisplayName("Check calculator divide() method logic work")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorDivideTest {

    static final Logger log = Logger.getLogger(CalculatorDivideTest.class.getSimpleName());

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
    @CsvSource({"33, 0"})
    public void calcDivideMethodExceptionTest(long init, long init2) {

        assertThrows(ArithmeticException.class, () -> calculator.div(init, init2));
    }

    @ParameterizedTest
    @CsvSource({"33.33, 11.11", "-11, 43.99", "-100, -10001", "0, 55"})
    public void calcDivideMethodTest(double init, double init2) {

        assertEquals(init / init2, calculator.div(init, init2));
    }


    @ParameterizedTest
    @CsvSource({"9999, 99"})
    public void calcDivideMethodWithTechnicalBoundaryTest(double init, double init2) {

        double technicalBoundaryResult = Math.pow(init, init2);
        boolean isTechnicalBoundaryForDoubleExceeded = technicalBoundaryResult == Double.POSITIVE_INFINITY;

        assertFalse(isTechnicalBoundaryForDoubleExceeded,
                "Technical Boundary For <double> type was exceeded: " + technicalBoundaryResult);
    }


}
