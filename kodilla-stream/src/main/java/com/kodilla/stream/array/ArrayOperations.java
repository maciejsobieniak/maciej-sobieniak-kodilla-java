package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
    /**
     * This method calculates the average of an array of integers.
     * It uses IntStream to process the array and calculate the average.
     *
     * @param numbers an array of integers
     * @return the average of the numbers in the array, or 0.0 if the array is null or empty
     */
    static double getAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0.0;
        }
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);

        double average = IntStream.range(0, numbers.length)
                .mapToDouble(n -> (double)numbers[n]) // Convert int to double
                .filter(n -> n > 0) // Optional: filter out non-positive numbers if desired
                .average().getAsDouble(); // Calculate the average. getAsDouble() because average() returns an OptionalDouble. if there are no elements, it will throw an exception.
        return average;

    }
}
