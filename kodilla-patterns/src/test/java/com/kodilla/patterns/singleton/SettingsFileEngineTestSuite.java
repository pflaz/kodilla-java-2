package com.kodilla.patterns.singleton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SettingsFileEngineTestSuite {

    private static SettingsFileEngine settingsFileEngine;

    @BeforeClass
    public static void openSettingsFile() {
        settingsFileEngine.getInstance().open("myapp.settings");
    }

    @AfterClass
    public static void closeSettingsFile() {
        settingsFileEngine.getInstance().close();
    }

    @Test
    public void testGetFileName() {
        // Given

        // When
        String filename = settingsFileEngine.getInstance().getFilename();
        System.out.println("Opened: " + filename);

        // Then
        Assert.assertEquals("myapp.settings", filename);
    }

    @Test
    public void testLoadSettings() {
        // Given

        // When
        boolean result = settingsFileEngine.getInstance().loadSettings();

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void testSaveSettings() {
        // Given

        // When
        boolean result = settingsFileEngine.getInstance().saveSettings();

        // Then
        Assert.assertTrue(result);
    }

}