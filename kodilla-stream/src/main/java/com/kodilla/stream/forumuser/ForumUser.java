package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final String username;
    private final char sex;
    private final LocalDate birthday;
    private final int postsCount;

    public ForumUser(final int userId, final String username, final char sex,
                     final LocalDate birthday, final int postsCount) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.postsCount = postsCount;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getPostsCount() {
        return postsCount;
    }
}
