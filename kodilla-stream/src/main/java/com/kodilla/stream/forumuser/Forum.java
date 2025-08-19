package com.kodilla.stream.forumuser;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theForumUsersList = new ArrayList<>();

    public Forum() {
        theForumUsersList.add(new ForumUser(1, "Dylan Murphy", 'M', LocalDate.of(2021, 2, 11), 9));
        theForumUsersList.add(new ForumUser(2, "Phoebe Pearson", 'F', LocalDate.of(1982, 9, 18), 0));
        theForumUsersList.add(new ForumUser(3, "Morgan Walsh", 'M', LocalDate.of(2001, 7, 20), 0));
        theForumUsersList.add(new ForumUser(4, "Aimee Murphy", 'F', LocalDate.of(1999, 8, 25), 1));
        theForumUsersList.add(new ForumUser(5, "Ryan Talley", 'M', LocalDate.of(1950, 5, 2), 100));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theForumUsersList);
    }

}
