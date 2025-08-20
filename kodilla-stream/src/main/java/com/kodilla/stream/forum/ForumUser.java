package com.kodilla.stream.forum;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import java.util.stream.Collectors;

/**
 * Class representing a forum user with attributes such as username, real name, location,
 * and a set of friends. It provides methods to manage friends and retrieve their locations.
 */
public class ForumUser {
    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    public ForumUser(final String username, final String realName, final String location) {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }

    public void addFriend(ForumUser user) {
        friends.add(user);
    }

    public boolean removeFriend(ForumUser user) {
        return friends.remove(user);
    }
    /**
     * Retrieves the locations of all friends of this forum user.
     *
     * @return a set of locations of friends
     */
    public Set<String> getLocationsOfFriends() {
        return friends.stream()
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }
    /**
     * Retrieves the locations of friends of friends, excluding the user themselves.
     *
     * @return a set of locations of friends of friends
     */
    // [1] Start with the friends of this user
    // [2] For each friend, get their friends
    // [3] Filter out the user themselves to avoid including their own location
    // [4] Map to their locations
    // [5] Collect the results into a set to ensure uniqueness
    // This method allows the user to see where their friends' friends are located,

    public Set<String> getLocationsOfFriendsOfFriends() {
        return friends.stream()                               // [1]
                .flatMap(user -> user.getFriends().stream())       // [2]
                .filter(user -> user != this)                      // [3]
                .map(ForumUser::getLocation)                       // [4]
                .collect(Collectors.toSet());                      // [5]
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", location='" + location + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumUser)) return false;
        ForumUser forumUser = (ForumUser) o;
        return Objects.equals(username, forumUser.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
