package ru.mirea.task12.opt1;

import java.awt.Color;
import java.awt.Graphics;

public class RectangleShape extends Shape {
    private final int width;
    private final int height;

    public RectangleShape(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
