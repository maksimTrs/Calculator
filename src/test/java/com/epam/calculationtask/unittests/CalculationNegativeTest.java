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

        double technicalBoundaryResult = Math.pow(init, init2);
        boolean isTechnicalBoundaryExceeded = technicalBoundaryResult == Double.POSITIVE_INFINITY;

        assertFalse(isTechnicalBoundaryExceeded,
                "***** Technical Boundary  was exceeded: " + technicalBoundaryResult + " *****");
    }


    @ParameterizedTest
    @CsvSource({"9999, 99"})
    public void checkLongTechnicalBoundaryTest(long init, long init2) {

        double technicalBoundaryResult = Math.pow(-init, init2);
        boolean isTechnicalBoundaryExceeded = technicalBoundaryResult == Double.NEGATIVE_INFINITY;

        assertFalse(isTechnicalBoundaryExceeded,
                "***** Technical Boundary  was exceeded: " + technicalBoundaryResult + " *****");
    }

}