package com.epam.calculationtask.unittests;

import com.epam.calculatortask.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import static com.epam.calculatortask.Timeout.sleep;

public abstract class BaseClassHelper {

    static Logger logger = LogManager.getLogger(BaseClassHelper.class);

    protected Calculator calculator;

    @BeforeEach
    public void logTestStart(TestInfo testInfo) {
        calculator = new Calculator();

        logger.info("********************************************************************************");
        logger.info("<<< Test class " + testInfo.getTestClass().orElseThrow().getSimpleName()
                + " with method: " + testInfo.getTestMethod().orElseThrow().getName() + " was started >>>");
        logger.info("********************************************************************************");

        sleep(2);
    }

    @AfterEach
    public void logTestStop(TestInfo testInfo) {
        logger.info("********************************************************************************");
        logger.info("<<< Test class " + testInfo.getTestClass().orElseThrow().getSimpleName()
                + " with method: " + testInfo.getTestMethod().orElseThrow().getName() + " was finished >>>");
        logger.info("********************************************************************************");

    }
}
