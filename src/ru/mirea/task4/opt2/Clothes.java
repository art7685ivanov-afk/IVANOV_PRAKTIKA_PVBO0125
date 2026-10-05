package ru.mirea.task4.opt2;

public abstract class Clothes {
    protected Size size;
    protected double cost;
    protected String color;

    public Clothes(Size size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s [размер=%s (EU %d, %s), цена=%.2f, цвет=%s]",
                getClass().getSimpleName(),
                size.name(), size.getEuroSize(), size.getDescription(),
                cost, color);
    }
}