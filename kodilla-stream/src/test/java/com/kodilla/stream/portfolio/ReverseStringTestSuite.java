package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReverseStringTestSuite {

    /*
       Test for reversing a string

     */
    @Test
    @DisplayName("Test for reversing a string")
    void testReverseString() {
        // Given
        ReverseString reverser = new ReverseString();
        String string1 = "Adam";
        String string2 = "Ewa";
        String string3 = "Kajak";
        // When
        String result1 = reverser.reverse(string1);
        String result2 = reverser.reverse(string2);
        String result3 = reverser.reverse(string3);
        // Then
        assert (result1.equals("madA"));
        assert (result2.equals("awE"));
        assert (result3.equals("kajaK"));
    }


    /*
       Test for reversing an empty string
     */
    @Test
    @DisplayName("Test for reversing a null string")
    void testReverseNullString() {
        // Given
        ReverseString reverser = new ReverseString();
        String string1 = null;
        // When & Then
        assertThrows(NullPointerException.class, () -> reverser.reverse(string1));
    }

}
