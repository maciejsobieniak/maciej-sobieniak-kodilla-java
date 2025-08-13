package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.library.Book;
import com.kodilla.testing.library.LibraryDatabase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ForumStatisticsTestSuite {
    // This class is a test suite for the ForumStatistics class.
    // It will contain tests to verify the functionality of the ForumStatistics class.
    // The tests will cover various scenarios such as:
    // - Calculating statistics with zero users
    // - Calculating statistics with a large number of posts and comments
    // - Calculating statistics with no posts or comments
    // - Verifying the average calculations

    // The tests will use mock objects to simulate the behavior of the Statistics interface.
    private static int testCounter = 0;
    private ForumStatistics forumStatistics;

    private List<String> generateListOfNUsers(int usersQuantity) {
        List<String> resultList = new ArrayList<>();
        for (int n = 1; n <= usersQuantity; n++) {
            String theNewUser = "User_" + n;
            resultList.add(theNewUser);
        }
        return resultList;
    }

    @BeforeAll
    public static void beforeAllTests () {
        System.out.println("Start tests statistics module");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        statisticsMock = mock(Statistics.class);
        forumStatistics = new ForumStatistics();
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests completed.");
        System.out.println("End tests statistics module");
    }


    @Mock
    private Statistics statisticsMock;

    @Test
    @DisplayName("Test calculateAdvStatistics with no posts")
    void testCalculateAdvStatisticsWithNoPosts() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(5));
        when(statisticsMock.postsCount()).thenReturn(0);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(5, forumStatistics.getUsersCount());
        assertEquals(0, forumStatistics.getAveragePostsPerUser());
        // Verify that the statistics were calculated correctly
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with 1000 posts")
    void testCalculateAdvStatisticsWith1000Posts() {
        // Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(10));
        when(statisticsMock.postsCount()).thenReturn(1000);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(10, forumStatistics.getUsersCount());
        assertEquals(100, forumStatistics.getAveragePostsPerUser());
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with no comments")
    void testCalculateAdvStatisticsWithNoComments() {
        // Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(5));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(5, forumStatistics.getUsersCount());
        assertEquals(20, forumStatistics.getAveragePostsPerUser());
        assertEquals(0, forumStatistics.getAverageCommentsPerUser());
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with more posts than comments")
    void testCalculateAdvStatisticsWithMorePostsThanComments() {
        // Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(5));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(5, forumStatistics.getUsersCount());
        assertEquals(20, forumStatistics.getAveragePostsPerUser());
        assertEquals(10, forumStatistics.getAverageCommentsPerUser());
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with more comments than posts")
    void testCalculateAdvStatisticsWithMoreCommentsThanPosts() {
        // Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(5));
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(5, forumStatistics.getUsersCount());
        assertEquals(10, forumStatistics.getAveragePostsPerUser());
        assertEquals(20, forumStatistics.getAverageCommentsPerUser());
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with zero users")
    void testCalculateAdvStatisticsWithZeroUsers() {
        // Given

        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(0));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(0, forumStatistics.getUsersCount());
        assertEquals(0, forumStatistics.getAveragePostsPerUser());
        assertEquals(0, forumStatistics.getAverageCommentsPerUser());
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with 100 users")
    void testCalculateAdvStatisticsWith100Users() {
        // Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(100, forumStatistics.getUsersCount());
        assertEquals(10, forumStatistics.getAveragePostsPerUser());
        assertEquals(5, forumStatistics.getAverageCommentsPerUser());
    }
}
