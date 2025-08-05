package com.kodilla.testing.forum;

import java.util.Objects;

public class ForumComment {

    private ForumPost forumPost;
    private String author;
    private String commentBody;

    public ForumComment(ForumPost forumPost, String author, String commentBody) {
        this.forumPost = forumPost;
        this.commentBody = commentBody;
        this.author = author;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumComment that)) return false;

        if (!forumPost.equals(that.forumPost)) return false;
        if (!commentBody.equals(that.commentBody)) return false;
        return author.equals(that.author);
        //return Objects.equals(forumPost, that.forumPost) && Objects.equals(commentBody, that.commentBody) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        int result = forumPost.hashCode();
        result = 31 * result + commentBody.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }
}
