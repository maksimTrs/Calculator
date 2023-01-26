package com.epam.calculationtask.unittests;


import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.logging.Logger;

import static com.epam.calculatortask.Timeout.sleep;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("regression")
@DisplayName("Check calculator logic with negative scenarios")
@Execution(ExecutionMode.CONCURRENT)
public class CalculationNegativeTest {


    static final Logger log = Logger.getLogger(CalculationNegativeTest.class.getSimpleName());

    private Calculator calculator;


    @BeforeEach
    void initTest(TestInfo testInfo) {
        calculator = new Calculator();
        log.info(() -> String.format("Was started test [%s] with method:[%s]",
                CalculationNegativeTest.class.getSimpleName(),
                testInfo.getTestMethod()));

        sleep(2);
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with method:[%s]",
                CalculationNegativeTest.class.getSimpleName(),
                testInfo.getTestMethod()));
    }


    @ParameterizedTest
    @CsvSource({"9999, 99"})
    public void checkDoubleTechnicalBoundaryTest(double init, double init2) {

        double technicalBoundaryResult = calculator.powMethod(init, init2);
        boolean isTechnicalBoundaryExceeded = technicalBoundaryResult == Double.POSITIVE_INFINITY;

        assertFalse(isTechnicalBoundaryExceeded,
                "***** Technical Boundary  was exceeded: " + technicalBoundaryResult + " *****");
    }


    @ParameterizedTest
    @CsvSource({"9999, 99"})
    public void checkDoubleTechnicalBoundaryTest2(double init, double init2) {

        double technicalBoundaryResult = calculator.powMethod(-init, init2);
        boolean isTechnicalBoundaryExceeded = technicalBoundaryResult == Double.NEGATIVE_INFINITY;

        assertFalse(isTechnicalBoundaryExceeded,
                "***** Technical Boundary  was exceeded: " + technicalBoundaryResult + " *****");
    }


    @ParameterizedTest
    @CsvSource({"33, 0"})
    public void calcLongDivideByZeroExceptionTest(long init, long init2) {

        assertThrows(ArithmeticException.class, () -> calculator.divideMethod(init, init2));
    }


    @ParameterizedTest
    @CsvSource({"-33.99, 0"})
    public void calcDoubleDivideByZeroExceptionTest(double init, double init2) {

        assertThrows(ArithmeticException.class, () -> calculator.divideMethod(init, init2));
    }


    @ParameterizedTest
    @CsvSource({"9223372036854775807, 1"})
    public void calcLongMethodWithTechnicalBoundaryTest(long init, long init2) {
        boolean isTechnicalBoundaryForLongExceeded = calculator.sumMethod(init, init2) < 0;

        assertFalse(isTechnicalBoundaryForLongExceeded,
                "Technical Boundary  was exceeded: " + (init + init2));
    }

}
