package ru.mirea.task12.opt3;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task12_3 {
    private static final int DEMO_FRAME_SIZE = 120;
    private static final int DEMO_FRAME_COUNT = 12;

    public static void main(String[] args) {
        BufferedImage spriteSheet = null;
        int requestedFrames = 0;

        if (args.length > 0) {
            try {
                spriteSheet = ImageIO.read(new File(args[0]));
                if (args.length > 1) {
                    requestedFrames = Integer.parseInt(args[1]);
                }
            } catch (IOException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Не удалось прочитать файл или количество кадров: " + e.getMessage(),
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (spriteSheet == null) {
            spriteSheet = createDemoSpriteSheet();
        }

        List<BufferedImage> frames = sliceFrames(spriteSheet, requestedFrames);
        if (frames.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Не удалось выделить кадры из изображения.",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Анимация");
            frame.add(new AnimationPanel(frames));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static BufferedImage createDemoSpriteSheet() {
        BufferedImage sheet = new BufferedImage(
                DEMO_FRAME_SIZE * DEMO_FRAME_COUNT,
                DEMO_FRAME_SIZE,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = sheet.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < DEMO_FRAME_COUNT; i++) {
            int offsetX = i * DEMO_FRAME_SIZE;
            g.setColor(new Color(20, 20, 40));
            g.fillRect(offsetX, 0, DEMO_FRAME_SIZE, DEMO_FRAME_SIZE);

            double angle = 2 * Math.PI * i / DEMO_FRAME_COUNT;
            int centerX = offsetX + DEMO_FRAME_SIZE / 2;
            int centerY = DEMO_FRAME_SIZE / 2;
            int orbit = 35;
            int planetX = centerX + (int) (Math.cos(angle) * orbit);
            int planetY = centerY + (int) (Math.sin(angle) * orbit);

            g.setColor(Color.ORANGE);
            g.fillOval(planetX - 14, planetY - 14, 28, 28);
            g.setColor(Color.CYAN);
            g.fillOval(centerX - 6, centerY - 6, 12, 12);
        }
        g.dispose();
        return sheet;
    }

    private static List<BufferedImage> sliceFrames(BufferedImage sheet, int requestedFrames) {
        List<BufferedImage> frames = new ArrayList<>();
        int frameHeight = sheet.getHeight();
        if (frameHeight <= 0) {
            return frames;
        }

        int count = requestedFrames > 0
                ? requestedFrames
                : Math.max(1, sheet.getWidth() / frameHeight);
        int frameWidth = sheet.getWidth() / count;
        if (frameWidth <= 0) {
            return frames;
        }

        for (int i = 0; i < count; i++) {
            int x = i * frameWidth;
            if (x + frameWidth <= sheet.getWidth()) {
                frames.add(sheet.getSubimage(x, 0, frameWidth, frameHeight));
            }
        }
        return frames;
    }
}
