package com.kodilla.stream.array;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Start tests array module");
    }

    @BeforeEach
    public void before() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    @DisplayName("Test getAverage method")
    // This test verifies that the getAverage method correctly calculates the average of an array of integers.
    // It uses a sample array of integers and checks if the calculated average matches the expected value
    void testGetAverage() {
        // Given
        int[] numbers = {1, 2, 3, 4, 5};

        // When
        double average = ArrayOperations.getAverage(numbers);

        // Then
        assertEquals(3.0, average);
    }
}
