package com.kodilla.good.patterns.factory.tasks;

public class TaskFactory {

    public static final String TASK_SHOPPING = "SHOPPING";
    public static final String TASK_PAINTING = "PAINTING";
    public static final String TASK_DRIVING = "DRIVING";

    public Task makeTask(final String taskType) {
        return switch (taskType) {
            case TASK_SHOPPING -> new ShoppingTask("Buying foods", "Bread", 1);
            case TASK_PAINTING -> new PaintingTask("Portrait Painting", "Red", "Bedroom");
            case TASK_DRIVING -> new DrivingTask("Back to Home", "Home", "Scooter");
            default -> null;
        };
    }
}
