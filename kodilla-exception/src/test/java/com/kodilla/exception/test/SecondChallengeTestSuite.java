package com.kodilla.exception.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* test for probablyIWillThrowException method in SecondChallenge class
   - when x is out of range (x >= 2 or x < 1) or y is 1.5, should throw Exception
   - when x and y are in range, should not throw Exception
*/
public class SecondChallengeTestSuite {

    @Test
    @DisplayName("When arguments are out of range, should throw Exception")
    public void testWhenArgumentsAreOutOfRangeWillThrowException() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(5.0, 0.1)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.0, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.2, 1.0)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(3.5, 1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.1, 1.0))
        );
    }
}
