package com.kodilla.stream.forum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the ForumUser class.
 * This test checks the functionality of getting locations of friends.
 */
public class ForumUserTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }
    /**
     * This test verifies that the getLocationsOfFriends method correctly retrieves
     * the locations of friends for a given user.
     */
    // Test for the getLocationsOfFriends method in the ForumUser class
    // It creates several ForumUser instances, establishes friendships between them,
    // and then checks if the getLocationsOfFriends method returns the correct locations
    // of the friends of a specific user (user1 in this case).
    // The test ensures that the method returns the expected number of unique locations
    @Test
    @DisplayName("Test getLocationsOfFriends method")
    void testGetLocationsOfFriends() {
        //Given
        //Create users
        ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        ForumUser user2 = new ForumUser("ethanreard", "Ethan Reard", "Miami");
        ForumUser user3 = new ForumUser("eRiK", "Erik Hull", "Key West");
        ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
        ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
        ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
        ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Washington");
        ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");

        //When
        //Create relations for user1
        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);
        //Create relations for user3
        user3.addFriend(user1);
        user3.addFriend(user7);
        user3.addFriend(user2);
        user3.addFriend(user9);
        //Create relations for user7
        user7.addFriend(user1);
        user7.addFriend(user3);
        //Create relations for user10
        user10.addFriend(user1);
        //Create relations for user2
        user2.addFriend(user3);
        //Create relations for user9
        user9.addFriend(user3);

        //Then
        //user1 has 3 friends with following locations:
        //      user3:  "Key West"
        //      user7:  "Washington"
        //      user10: "Miami"
        assertEquals(3, user1.getLocationsOfFriends().size());
        assertTrue(user1.getLocationsOfFriends().contains("Key West"));
        assertTrue(user1.getLocationsOfFriends().contains("Washington"));
        assertTrue(user1.getLocationsOfFriends().contains("Miami"));
        assertFalse(user1.getLocationsOfFriends().contains("Orlando"));
    }

    /**
     * This test verifies that the getLocationsOfFriendsOfFriends method correctly retrieves
     * the locations of friends of friends for a given user, excluding the user's own location.
     */
    @Test
    @DisplayName("Test getLocationsOfFriendsOfFriends method")
    void testGetLocationsOfFriendsOfFriends() {
        //Given
        //Create users
        ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        ForumUser user2 = new ForumUser("ethanreard", "Ethan Reard", "Miami");
        ForumUser user3 = new ForumUser("eRiK", "Erik Hull", "Key West");
        ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
        ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
        ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
        ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Washington");
        ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");

        //When
        //Create relations for user1
        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);
        //Create relations for user3
        user3.addFriend(user1);
        user3.addFriend(user7);
        user3.addFriend(user2);
        user3.addFriend(user9);
        //Create relations for user7
        user7.addFriend(user1);
        user7.addFriend(user3);
        //Create relations for user10
        user10.addFriend(user1);
        //Create relations for user2
        user2.addFriend(user3);
        //Create relations for user9
        user9.addFriend(user3);

        //Then
        //user1 has 3 friends with following friends and their locations:
        //      user3:  user1: - should be skipped ("this" in context of user1)
        //      user7: "Washington"
        //      user2: "Miami"
        //      user9: "Washington" - duplicated, should be skipped
        //      user7:  user1: - should be skipped ("this" in context of user1)
        //      user3: "Key West"
        //      user10: user1: - should be skipped ("this" in context of user1)
        assertEquals(3, user1.getLocationsOfFriendsOfFriends().size());
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Key West"));
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Washington"));
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Miami"));
        assertFalse(user1.getLocationsOfFriendsOfFriends().contains("Orlando"));
    }
}
