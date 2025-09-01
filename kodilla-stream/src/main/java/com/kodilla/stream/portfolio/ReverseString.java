package com.kodilla.stream.portfolio;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {
    public String reverse(String text) throws NullPointerException {
        if (text == null) {
            throw new NullPointerException("Text is null");
        }
        return Stream.iterate(text.length() - 1, n -> n >= 0, n -> n - 1)
                .map(n -> text.charAt(n))
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
