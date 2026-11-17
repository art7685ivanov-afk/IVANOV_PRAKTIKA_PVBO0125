package ru.mirea.task12.opt3;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

public class AnimationPanel extends JPanel {
    private final List<BufferedImage> frames;
    private final Timer timer;
    private int currentFrame;

    public AnimationPanel(List<BufferedImage> frames) {
        this.frames = frames;
        if (!frames.isEmpty()) {
            BufferedImage first = frames.get(0);
            setPreferredSize(new Dimension(first.getWidth(), first.getHeight()));
        }
        setBackground(Color.BLACK);
        timer = new Timer(100, e -> {
            if (!frames.isEmpty()) {
                currentFrame = (currentFrame + 1) % frames.size();
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!frames.isEmpty()) {
            g.drawImage(frames.get(currentFrame), 0, 0, null);
        }
    }
}
