package ru.mirea.task16.opt2;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Task16_2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Районы Москвы");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            frame.add(createRegion("CENTER", "ЦАО", new Color(255, 220, 220),
                    "Добро пожаловать в ЦАО"), BorderLayout.CENTER);
            frame.add(createRegion("WEST", "ЗАО", new Color(220, 235, 255),
                    "Добро пожаловать в ЗАО"), BorderLayout.WEST);
            frame.add(createRegion("EAST", "ВАО", new Color(220, 255, 220),
                    "Добро пожаловать в ВАО"), BorderLayout.EAST);
            frame.add(createRegion("NORTH", "САО", new Color(255, 245, 210),
                    "Добро пожаловать в САО"), BorderLayout.NORTH);
            frame.add(createRegion("SOUTH", "ЮАО", new Color(235, 220, 255),
                    "Добро пожаловать ЮАО"), BorderLayout.SOUTH);

            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JLabel createRegion(String area, String title, Color color, String message) {
        JLabel label = new JLabel(area + " (" + title + ")", SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(color);
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        label.setPreferredSize(new Dimension(120, 80));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(label, message, title,
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return label;
    }
}
