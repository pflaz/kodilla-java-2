package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BoardTestSuite {

    @Test
    public void testContext() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        // When & Then
        System.out.println("Beans:");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("end of beans");
    }

    @Test
    public void testAddTask() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        // When
        TaskList toDoList = (TaskList)context.getBean("toDoList");
        toDoList.addTask("First task added to ToDo List");

        TaskList inProgressList = (TaskList)context.getBean("inProgressList");
        inProgressList.addTask("First task in inProgress List");

        TaskList doneList = (TaskList)context.getBean("doneList");
        doneList.addTask("First task in Done List");

        String retrievedTaskInToDoList = toDoList.getTask(0);
        String retrievedTaskInInProgressList = inProgressList.getTask(0);
        String retrievedTaskInDoneList = doneList.getTask(0);

        // Then
        Assert.assertEquals("First task added to ToDo List", retrievedTaskInToDoList);
        Assert.assertEquals("First task in inProgress List", retrievedTaskInInProgressList);
        Assert.assertEquals("First task in Done List", retrievedTaskInDoneList);
    }
}