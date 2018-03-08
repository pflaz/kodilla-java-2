package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatsTestSuite {

    @Before
    public void before() {
        System.out.println("\nNEW TEST");
    }

    @Test
    public void testCalculateAdvStatisticsAveragesWith0Posts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> userNames = new ArrayList<String>();

        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(userNames);

        Stats stats = new Stats(statisticsMock);
        stats.calculateAdvStatistics();

        stats.showStatistics();

        //When
        double postsAveragePerUser = stats.getPostsAveragePerUser();
        double commentsAveragePerUser = stats.getCommentsAveragePerUser();
        double commentsAveragePerPost = stats.getCommentsAveragePerPost();

        //Then
        Assert.assertEquals(0, postsAveragePerUser, 0);
        Assert.assertEquals(0, commentsAveragePerUser, 0);
        Assert.assertEquals(0, commentsAveragePerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsAveragesWith1000PostsAnd100UsersAndCommentsLessThanPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> userNames = new ArrayList<String>();
        for(int i = 0; i < 100; i++) {
            userNames.add("user" + i);
        }

        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(50);
        when(statisticsMock.usersNames()).thenReturn(userNames);

        Stats stats = new Stats(statisticsMock);
        stats.calculateAdvStatistics();

        stats.showStatistics();

        //When
        double postsAveragePerUser = stats.getPostsAveragePerUser();
        double commentsAveragePerUser = stats.getCommentsAveragePerUser();
        double commentsAveragePerPost = stats.getCommentsAveragePerPost();

        //Then
        Assert.assertEquals(10, postsAveragePerUser, 0);
        Assert.assertEquals(0.5, commentsAveragePerUser, 0);
        Assert.assertEquals(0.05, commentsAveragePerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsAveragesWith1000PostsAnd100UsersAndCommentsMoreThanPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> userNames = new ArrayList<String>();
        for(int i = 0; i < 100; i++) {
            userNames.add("user" + i);
        }

        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(5000);
        when(statisticsMock.usersNames()).thenReturn(userNames);

        Stats stats = new Stats(statisticsMock);
        stats.calculateAdvStatistics();

        stats.showStatistics();

        //When
        double postsAveragePerUser = stats.getPostsAveragePerUser();
        double commentsAveragePerUser = stats.getCommentsAveragePerUser();
        double commentsAveragePerPost = stats.getCommentsAveragePerPost();

        //Then
        Assert.assertEquals(10, postsAveragePerUser, 0);
        Assert.assertEquals(50, commentsAveragePerUser, 0);
        Assert.assertEquals(5, commentsAveragePerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsAveragesWith0PostsAnd100Users() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> userNames = new ArrayList<String>();
        for(int i = 0; i < 100; i++) {
            userNames.add("user" + i);
        }

        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(userNames);

        Stats stats = new Stats(statisticsMock);
        stats.calculateAdvStatistics();

        stats.showStatistics();

        //When
        double postsAveragePerUser = stats.getPostsAveragePerUser();
        double commentsAveragePerUser = stats.getCommentsAveragePerUser();
        double commentsAveragePerPost = stats.getCommentsAveragePerPost();

        //Then
        Assert.assertEquals(0, postsAveragePerUser, 0);
        Assert.assertEquals(0, commentsAveragePerUser, 0);
        Assert.assertEquals(0, commentsAveragePerPost, 0);
    }


}
