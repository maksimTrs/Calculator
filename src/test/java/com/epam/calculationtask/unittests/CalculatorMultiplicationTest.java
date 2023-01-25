package com.epam.calculationtask.unittests;

import com.epam.calculatortask.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@DisplayName("Check calculator multiplication() method logic work")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorMultiplicationTest {

    static final Logger log = Logger.getLogger(CalculatorMultiplicationTest.class.getSimpleName());

    private Calculator calculator;


    @BeforeEach
    void initTest() {
        calculator = new Calculator();

        log.info(() -> String.format("Was started test [%s]", CalculatorMultiplicationTest.class.getMethods()[0].toString()));
    }

    @AfterEach
    void tearDownTest(TestInfo testInfo) {
        log.info(() -> String.format("Was finished test [%s] with parameters:[%s]",
                CalculatorMultiplicationTest.class.getMethods()[0].toString(),
                testInfo.getDisplayName().toUpperCase()));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/calculatormultdata.csv")
    public void calcMultiplicationMethodTest(long init, long init2) {
        assertEquals(init * init2, calculator.mult(init, init2));
    }
}
