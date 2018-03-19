package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testCreatingShoppingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task shoppingTask = factory.createTask(TaskFactory.SHOPPING);

        // Then
        Assert.assertEquals("Buy shoes", shoppingTask.getTaskName());
        Assert.assertFalse(shoppingTask.isTaskExecuted());
        shoppingTask.executeTask();
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    public void testCreatingPaintingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task paitingTask = factory.createTask(TaskFactory.PAINTING);

        // Then
        Assert.assertEquals("Paint a tree", paitingTask.getTaskName());
        Assert.assertFalse(paitingTask.isTaskExecuted());
        paitingTask.executeTask();
        Assert.assertTrue(paitingTask.isTaskExecuted());
    }

    @Test
    public void testCreatingDrivingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task drivingTask = factory.createTask(TaskFactory.DRIVING);

        // Then
        Assert.assertEquals("Drive to the office", drivingTask.getTaskName());
        Assert.assertFalse(drivingTask.isTaskExecuted());
        drivingTask.executeTask();
        Assert.assertTrue(drivingTask.isTaskExecuted());
    }

}