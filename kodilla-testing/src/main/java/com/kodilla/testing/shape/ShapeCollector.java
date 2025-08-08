package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    public boolean addFigure(Shape shape) {
        if (shape != null) {
            return shapes.add(shape);
        }
        return false;
    }

    public boolean removeFigure(int shapeIndex) {
        boolean result = false;
        if (shapeIndex >= 0 && shapeIndex < shapes.size()) {
            shapes.remove(shapeIndex);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int shapeIndex) {
        if  (shapeIndex >= 0 && shapeIndex < shapes.size()) {
            return shapes.get(shapeIndex);
        }
        return null;
    }

    public StringBuilder getFigures() {
        StringBuilder result = new StringBuilder();
        if  (shapes == null || shapes.isEmpty()) {
            return null;
        }
        int shapeIndex = 1;
        for (Shape shape : shapes) {
            if (shape != null) {
                result.append("Shape nr: " + shapeIndex + " - " + "Nazwa: " + shape.getShapeName() + " - " + "Pole: " + shape.getField() + "\n");
                shapeIndex++;
            }
        }
        return result;

    }

    public int getShapeCount() {
        return shapes.size();
    }

    public int getShapeIndex(Shape shape) {
        if (shape != null) {
            return shapes.indexOf(shape);
        }
        return 0;
    }
}
