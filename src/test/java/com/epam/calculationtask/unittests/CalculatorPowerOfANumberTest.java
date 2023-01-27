package com.epam.calculationtask.unittests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@DisplayName("Check calculator powMethod() method for <double> type")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorPowerOfANumberTest extends BaseClassHelper {

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

    @ParameterizedTest
    @MethodSource("factory")
    public void calcDoublePowerOfNumberMethodTest(double init, double init2) {

        assertEquals(Math.pow(init, Math.floor(init2)), calculator.powMethod(init, init2));
    }


}
