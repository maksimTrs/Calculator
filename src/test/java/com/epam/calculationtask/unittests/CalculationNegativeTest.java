package com.epam.calculationtask.unittests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("regression")
@DisplayName("Check calculator logic with negative scenarios")
@Execution(ExecutionMode.CONCURRENT)
public class CalculationNegativeTest extends BaseClassHelper {

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
