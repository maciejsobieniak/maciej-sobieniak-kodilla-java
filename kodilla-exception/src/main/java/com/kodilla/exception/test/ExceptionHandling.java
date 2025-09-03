package com.kodilla.exception.test;

/*
    Handle the exception thrown by the probablyIWillThrowException method.
    If an exception is throw, print the information about the exception to the console.
    Print "Program end" at the end.
*/
public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1.1, 10.0));
        } catch (Exception e) {
            System.out.println("Error - exception: " + e);
        } finally {
            System.out.println("Program end");
        }
    }
}
