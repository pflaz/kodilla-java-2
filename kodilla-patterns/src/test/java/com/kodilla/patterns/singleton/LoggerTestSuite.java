package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    private static Logger logger;

    @Test
    public void testLog() {
        // Given

        // When
        logger.getInstance().log("test log #1");

        // Then
        Assert.assertEquals("test log #1", logger.getInstance().getLastLog());
    }
}