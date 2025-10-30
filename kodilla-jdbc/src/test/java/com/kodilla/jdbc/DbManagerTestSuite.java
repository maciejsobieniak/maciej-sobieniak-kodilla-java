package com.kodilla.jdbc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class DbManagerTestSuite {

    private static DbManager dbManager;
    private static Statement statement;
    private static ResultSet rs;

    @BeforeAll
    public static void startLogger() {

        dbManager = DbManager.getInstance();
    }

    @AfterEach
    public void closeResources() throws SQLException {

        if (rs != null && !rs.isClosed()) {
            rs.close();
        }

        if (statement != null && !statement.isClosed()) {
            statement.close();
        }
    }

    @Test
    void testConnection() {

        //Then
        assertNotNull(dbManager.getConnection());

    }

    @Test
    void testSelectUsers() throws SQLException {

        //When
        String sqlQuery = "SELECT * FROM USERS";
        statement = dbManager.getConnection().createStatement();
        rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }

        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndTasks() throws SQLException {

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, I.TITLE\n" +
                "  FROM USERS U\n" +
                "  JOIN ISSUES I ON U.ID = I.USER_ID_ASSIGNED";
        statement = dbManager.getConnection().createStatement();
        rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getString("TITLE"));
            counter++;
        }

        assertEquals(10, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POST_NUMBER\n" +
                "  FROM USERS U\n" +
                "  JOIN POSTS P ON U.ID = P.USER_ID\n" +
                "  GROUP BY P.USER_ID\n" +
                "  HAVING COUNT(*) >= 2";
        statement = dbManager.getConnection().createStatement();
        rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println("Firstname: " + rs.getString("FIRSTNAME") + ", Lastname: " +
                    rs.getString("LASTNAME") + ", Posts: " +
                    rs.getInt("POST_NUMBER"));
            counter++;
        }

        assertEquals(2, counter);
    }
}
