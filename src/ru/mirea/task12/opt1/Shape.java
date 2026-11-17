package ru.mirea.task12.opt1;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
    protected final Color color;
    protected final int x;
    protected final int y;

    protected Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void draw(Graphics g);
}
