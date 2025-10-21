package com.kodilla.good.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void startLogger() {
        logger = Logger.INSTANCE;
    }

    @AfterAll
    public static void closeLogger() {
        logger.closeLogger();
    }

    @Test
    void testGetLastLog() {
        //Given
        String log1 = "This is a very important log message - 1.";
        String log2 = "This is a very important log message - 2.";
        //When
        logger.log(log1);
        logger.log(log2);
        String lastLog = logger.getLastLog();
        //Then
        assert log2.equals(lastLog);
    }

}
