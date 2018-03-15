package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testLog() {
        // Given

        // When
        Logger.getInstance().log("test log #1");

        // Then
        Assert.assertEquals("test log #1", Logger.getInstance().getLastLog());
    }
}