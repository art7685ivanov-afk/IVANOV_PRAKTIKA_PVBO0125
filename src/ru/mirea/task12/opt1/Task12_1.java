package ru.mirea.task12.opt1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class Task12_1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("20 случайных фигур");
            ShapePanel panel = new ShapePanel();
            JButton refresh = new JButton("Перерисовать");
            refresh.addActionListener(e -> panel.regenerate());

            JPanel bottom = new JPanel();
            bottom.add(refresh);

            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);
            frame.add(bottom, BorderLayout.SOUTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(820, 620);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
