package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class MentorTestSuite {

    @Test
    public void testUpdate() {
        // Given
        Queue queue1 = new Queue("Student 1");
        Queue queue2 = new Queue("Student 2");
        Queue queue3 = new Queue("Student 3");
        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");
        queue1.registerObserver(mentor1);
        queue2.registerObserver(mentor2);
        queue3.registerObserver(mentor1);

        // When
        queue1.addAnswer("Answer #1 in queue 1");
        queue2.addAnswer("Answer #1 in queue 2");
        queue1.addAnswer("Answer #2 in queue 1");
        queue3.addAnswer("Answer #1 in queue 3");

        // Then
        Assert.assertEquals(3, mentor1.getNotificationsCount());
        Assert.assertEquals(1, mentor2.getNotificationsCount());
    }

}