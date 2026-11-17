package ru.mirea.task12.opt1;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapePanel extends JPanel {
    private final List<Shape> shapes = new ArrayList<>();
    private final Random random = new Random();

    public ShapePanel() {
        setBackground(Color.WHITE);
        regenerate();
    }

    public final void regenerate() {
        shapes.clear();
        int width = Math.max(getWidth(), 700);
        int height = Math.max(getHeight(), 450);
        for (int i = 0; i < 20; i++) {
            Color color = new Color(random.nextInt(200), random.nextInt(200), random.nextInt(200));
            int size = 30 + random.nextInt(80);
            int x = random.nextInt(Math.max(1, width - size));
            int y = random.nextInt(Math.max(1, height - size));
            switch (random.nextInt(3)) {
                case 0 -> shapes.add(new Circle(color, x, y, Math.max(10, size / 2)));
                case 1 -> shapes.add(new RectangleShape(color, x, y, size, Math.max(10, size * 2 / 3)));
                default -> shapes.add(new Triangle(color, x, y, size));
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}
