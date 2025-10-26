package com.kodilla.good.patterns.factory.tasks;

public class PaintingTask implements Task {

    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean taskExecuted;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
        this.taskExecuted = false;
    }

    public String getWhatToPaint() {
        return whatToPaint;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing Painting Task: Painting " + whatToPaint + " with color " + color);
        taskExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecuted;
    }
}
