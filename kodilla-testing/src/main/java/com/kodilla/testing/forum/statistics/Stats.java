package com.kodilla.testing.forum.statistics;

public class Stats {

    Statistics statistics;

    private int usersCount = 0;
    private int postsCount = 0;
    private int commentsCount = 0;
    private double postsAveragePerUser = 0;
    private double commentsAveragePerUser = 0;
    private double commentsAveragePerPost = 0;

    public Stats(Statistics statistics) {
        this.statistics = statistics;
    }

    public double getPostsAveragePerUser() {
        return postsAveragePerUser;
    }

    public double getCommentsAveragePerUser() {
        return commentsAveragePerUser;
    }

    public double getCommentsAveragePerPost() {
        return commentsAveragePerPost;
    }

    public void calculateAdvStatistics() {
        this.usersCount = statistics.usersNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();
        if (this.usersCount > 0 ) { this.postsAveragePerUser = (double)this.postsCount / this.usersCount;}
        if (this.usersCount > 0 ) { this.commentsAveragePerUser = (double)this.commentsCount / this.usersCount;}
        if (this.postsCount > 0 ) { this.commentsAveragePerPost = (double)this.commentsCount / this.postsCount;}
    }

    public void showStatistics() {
        System.out.println("Number of users: " + usersCount);
        System.out.println("Number of posts: " + postsCount);
        System.out.println("Number of comments: " + commentsCount);
        System.out.println("Posts average per user: " + postsAveragePerUser);
        System.out.println("Comments average per user: " + commentsAveragePerUser);
        System.out.println("Comments average per posts: " + commentsAveragePerPost);
    }
}
