package com.kodilla.good.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryMakingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.TASK_SHOPPING);
        shoppingTask.executeTask();
        Task paintingTask = factory.makeTask(TaskFactory.TASK_PAINTING);
        paintingTask.executeTask();
        Task drivingTask = factory.makeTask(TaskFactory.TASK_DRIVING);
        drivingTask.executeTask();
        //Then
        assertEquals("Buying foods", shoppingTask.getTaskName());
        assertEquals("Bread", ((ShoppingTask) shoppingTask).getWhatToBuy());
        assertTrue(shoppingTask.isTaskExecuted());
        assertEquals("Portrait Painting", paintingTask.getTaskName());
        assertEquals("Bedroom", ((PaintingTask) paintingTask).getWhatToPaint());
        assertTrue(paintingTask.isTaskExecuted());
        assertEquals("Back to Home", drivingTask.getTaskName());
        assertEquals("Home", ((DrivingTask) drivingTask).getWhere());
        assertTrue(drivingTask.isTaskExecuted());
    }
}
