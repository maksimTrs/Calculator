package com.epam.calculationtask.unittests;


import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.logging.Logger;
import java.util.stream.Stream;

import static com.epam.calculatortask.Timeout.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@DisplayName("Check calculator powMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorPowerOfANumberTest {

    static final Logger log = Logger.getLogger(CalculatorPowerOfANumberTest.class.getSimpleName());

    private Calculator calculator;

    public static Stream<Arguments> factory() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(6, 6),
                Arguments.of(-1, 1),
                Arguments.of(-3, 3),
                Arguments.of(-3, 0),
                Arguments.of(3.99, 0),
                Arguments.of(0, 5.55),
                Arguments.of(0, 0),
                Arguments.of(4, 4)
        );
    }

    @BeforeEach
    void initTest(TestInfo testInfo) {
        calculator = new Calculator();
        log.info(() -> String.format("Was started test [%s] with method:[%s]",
                CalculatorPowerOfANumberTest.class.getSimpleName(),
                testInfo.getTestMethod()));

        sleep(2);
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with method:[%s]",
                CalculatorPowerOfANumberTest.class.getSimpleName(),
                testInfo.getTestMethod()));
    }

    @ParameterizedTest
    @MethodSource("factory")
    public void calcDoublePowerOfNumberMethodTest(double init, double init2) {

        assertEquals(Math.pow(init, Math.floor(init2)), calculator.powMethod(init, init2));
    }


}
