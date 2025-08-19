package com.kodilla.stream;

import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.MathExpression;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.person.People;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.forumuser.Forum;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;


public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        Processor processor = new Processor();
        //ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        //processor.execute(executeSaySomething);
        //processor.execute(() -> System.out.println("This is an example text.")); - this is a lambda expression that implements the Executor interface
        Executor codeToExecute = () -> System.out.println("This is an example text.");  // [7]
        processor.execute(codeToExecute);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);           // [6]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);           // [7]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);           // [8]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("Beautifying text with lambda expressions");
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("This is a beautiful text", (text) -> "ABC " + text + " ABC");
        poemBeautifier.beautify("This is a beautiful text", (text) -> "-<>-" + text + "-<>-");
        poemBeautifier.beautify("This is a beautiful text", (text) -> text.toUpperCase() + "!!!");
        poemBeautifier.beautify("This is a beautiful text", (text) -> text.toLowerCase());
        // Using a lambda expression to add asterisks around the text
        for (int i = 1; i < 10; i++) {
            poemBeautifier.beautify("*".repeat(i), (text) -> "|"+ text + "|");
        }
        // Using a lambda expression to reverse the text
        poemBeautifier.beautify("This is a beautiful text", text -> {
            StringBuilder result = new StringBuilder(text);
            return result.reverse().toString();
        });
        // Using a lambda expression to create a box around the text
        poemBeautifier.beautify("This is a beautiful text", text -> {
            String result = "+--------------------------+\n" +
                            "| " + text + " |\n" +
                            "+--------------------------+";
            return result;
        });
        // Using a lambda expression to create a pattern with alternating uppercase and lowercase letters
        poemBeautifier.beautify("This is a beautiful text", text -> {
            String result = "";
            for (int i = 0; i < text.length(); i++) {
                if (i % 2 == 0) {
                    result += Character.toUpperCase(text.charAt(i));
                } else {
                    result += Character.toLowerCase(text.charAt(i));
                }
            }
            return result;
        });

        // Using Stream to generate even numbers from 1 to 20
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        // Using Stream to print names from the People class
        System.out.println("Using Stream to print names from the People class");
        People.getList().stream().forEach(System.out::println);

        // Using Stream to print names from the People class in uppercase
        System.out.println("Using Stream to print names from the People class in uppercase");
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        // Using Stream to print names from the People class in uppercase using method reference
        System.out.println("Using Stream to print names from the People class in uppercase using method reference");
        People.getList().stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);


        // Using Stream to filter names longer than 11 characters
        System.out.println("Using Stream to filter names longer than 11 characters");
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);


        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(" ") + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);

        // Using Stream to filter books published after 2005
        System.out.println("Using Stream to filter books published after 2005");
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        // Using Stream to filter books published after 2005 and collect them into a list
        System.out.println("Using Stream to filter books published after 2005 and collect them into");
        BookDirectory nextTheBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = nextTheBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        // Using Stream to filter books published after 2005 and collect them into a map
        System.out.println("Using Stream to filter books published after 2005 and collect them into a map");
        // The map will use the book's signature as the key and the book itself
        BookDirectory nextMaptheBookDirectory = new BookDirectory();

        Map<String, Book> mapTheResultMapOfBooks = nextMaptheBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));             // [1]

        System.out.println("# elements: " + mapTheResultMapOfBooks.size());             // [2]
        mapTheResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())                   // [3]
                .forEach(System.out::println);

        // Using Stream to filter books published after 2005 and join them into a single string
        System.out.println("Using Stream to filter books published after 2005 and join them into a single string");
        // The result will be a string with the books' details separated by commas
        BookDirectory joiningTheBookDirectory = new BookDirectory();
        String theResultStringOfBooks = joiningTheBookDirectory.getList().stream()  // [1]
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));                    // [2]

        System.out.println(theResultStringOfBooks);

        // Using Stream to filter forum users
        System.out.println("Using Stream to filter forum users");
        Forum theForum = new Forum();
        Map<Integer, ForumUser> par = theForum.getUserList().stream()
                .filter(u -> u.getSex() == 'M')
                .filter(u -> u.getBirthday().isBefore(LocalDate.now().minusYears(20)))
                .filter(u -> u.getPostsCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, u-> u));
        System.out.println("Number of filtered users: " + par.size());
        par.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue().getUsername() + ", " +
                        entry.getValue().getBirthday() + ", " + entry.getValue().getPostsCount())
                .forEach(System.out::println);

    }
}
