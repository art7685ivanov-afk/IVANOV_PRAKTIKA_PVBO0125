package ru.mirea.task2.opt6;

public class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getLength() {
        return 2 * Math.PI * radius;
    }

    public boolean equals(Circle other) {
        if (other == null) return false;
        return Double.compare(this.radius, other.radius) == 0
                && this.color.equals(other.color);
    }

    @Override
    public String toString() {
        return String.format("Circle{radius=%.2f, color='%s', area=%.4f, length=%.4f}",
                radius, color, getArea(), getLength());
    }
}