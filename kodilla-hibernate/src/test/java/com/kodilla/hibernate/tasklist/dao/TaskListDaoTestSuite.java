package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test: Learn Hibernate";
    private static final String LISTNAME = "Test: LIST NAME";

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        String listName = taskList.getListName();
        List<TaskList> readTaskLists = taskListDao.findByListName(listName);
        assertEquals(LISTNAME, readTaskLists.get(0).getListName());

        //CleanUp
        int id = readTaskLists.getFirst().getId();
        taskListDao.deleteById(id);
    }

}
