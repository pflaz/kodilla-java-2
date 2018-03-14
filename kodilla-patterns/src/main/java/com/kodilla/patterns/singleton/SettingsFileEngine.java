package com.kodilla.patterns.singleton;

public class SettingsFileEngine {
    private static SettingsFileEngine settingsFileEngine = null;
    private String filename = "";

    private SettingsFileEngine() {
    }

    public static SettingsFileEngine getInstance() {
        if (settingsFileEngine == null) {
            synchronized (SettingsFileEngine.class) {
                if (settingsFileEngine == null) {
                    settingsFileEngine = new SettingsFileEngine();
                }
            }
        }
        return settingsFileEngine;
    }

    public String getFilename() {
        return filename;
    }

    public void open(final String filename) {
        this.filename = filename;
        System.out.println("Opening the settings file");
    }

    public void close() {
        this.filename = "";
        System.out.println("Closing the setting file");
    }

    public boolean loadSettings() {
        System.out.println("Loading settings from file");
        return true;
    }

    public boolean saveSettings() {
        System.out.println("Saving settings to file");
        return true;
    }

}
