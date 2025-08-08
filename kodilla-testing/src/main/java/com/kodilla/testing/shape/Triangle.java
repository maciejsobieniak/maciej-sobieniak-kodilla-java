package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {

    private String shapeName;
    private double base;
    private double height;

    public Triangle(String shapeName, double base, double height) {
        this.shapeName = shapeName;
        this.base = base;
        this.height = height;
    }


    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return (base + height) / 2;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(base, triangle.base) == 0 && Double.compare(height, triangle.height) == 0 && Objects.equals(shapeName, triangle.shapeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapeName, base, height);
    }
}
