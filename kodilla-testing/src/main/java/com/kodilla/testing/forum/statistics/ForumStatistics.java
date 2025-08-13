package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.library.LibraryDatabase;

public class ForumStatistics {

    private int postsCount;
    private int commentsCount;
    private int usersCount;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {

        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        usersCount = statistics.usersNames().size();

        averagePostsPerUser = usersCount == 0 ? 0 : (double) postsCount / usersCount;
        averageCommentsPerUser = usersCount == 0 ? 0 : (double) commentsCount / usersCount;
        averageCommentsPerPost = postsCount == 0 ? 0 : (double) commentsCount / postsCount;
    }
    // This method is used to display the statistics in a readable format.
    public void showStatistics() {
        System.out.println("--------------------------------------------------");
        System.out.println("Forum Statistics:");
        System.out.println("Total posts: " + getPostsCount());
        System.out.println("Total comments: " + getCommentsCount());
        System.out.println("Total users: " + getUsersCount());
        System.out.println("Average posts per user: " + getAveragePostsPerUser());
        System.out.println("Average comments per user: " + getAverageCommentsPerUser());
        System.out.println("Average comments per post: " + getAverageCommentsPerPost());
        System.out.println("--------------------------------------------------");
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
