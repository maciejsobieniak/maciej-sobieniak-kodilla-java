package com.kodilla.spring.portfolio;

import com.kodilla.spring.reader.ReaderConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().getTasks().add("Make new task in one day");
        board.getInProgressList().getTasks().add("13.3 tasks in progress");
        board.getDoneList().getTasks().add("13.3 tasks done");

        //Then
        assertTrue(board.getToDoList().getTasks().contains("Make new task in one day"));
        assertTrue(board.getInProgressList().getTasks().contains("13.3 tasks in progress"));
        assertTrue(board.getDoneList().getTasks().contains("13.3 tasks done"));
    }
}
