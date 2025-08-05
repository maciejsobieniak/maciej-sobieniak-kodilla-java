package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    private static int testCounter = 0;

    @BeforeEach
    public void before() {
        testCounter++;
        System.out.println("Execute test number: " + testCounter);
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }


    @DisplayName(
            "When exterminate gets empty list, " +
                    "then exterminate should return null"
    )
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        List<Integer> result = oddNumbersExterminator.exterminate(new ArrayList<>());
        System.out.println("Test result: " + result);
        Assertions.assertNull(result);

    }

    @DisplayName(
            "When When exterminate gets normal list, " +
                    "then exterminate should return correct odd numbers"
    )
    @Test
    public void testOddNumbersExterminatorNormalList() {

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        List<Integer> result = oddNumbersExterminator.exterminate(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)));
        System.out.println("Test result: " + result);

        Assertions.assertEquals(new ArrayList<>(Arrays.asList(2, 4, 6, 8 , 10 , 12, 14, 16, 18, 20)), result);

    }
}
