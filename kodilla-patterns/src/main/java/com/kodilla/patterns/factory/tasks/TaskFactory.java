package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public final static String SHOPPING = "SHOPPING";
    public final static String PAINTING = "PAINTING";
    public final static String DRIVING = "DRIVING";


    public Task createTask(String taskType) {
        switch (taskType) {
            case "SHOPPING":
                return new ShoppingTask("Buy shoes", "shoes", 2);

            case "PAINTING":
                return new PaintingTask("Paint a tree", "green", "tree");

            case "DRIVING":
                return new DrivingTask("Drive to the office", "office", "car");

            default:
                return null;
        }
    }
}
