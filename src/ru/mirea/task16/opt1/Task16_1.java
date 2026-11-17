package ru.mirea.task16.opt1;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Random;

public class Task16_1 {
    private static final int MAX_ATTEMPTS = 3;
    private static final int MAX_NUMBER = 20;

    private final int target = new Random().nextInt(MAX_NUMBER + 1);
    private final JTextField input = new JTextField(5);
    private final JLabel attemptsLabel = new JLabel("Осталось попыток: " + MAX_ATTEMPTS);
    private final JFrame frame = new JFrame("Угадай число");
    private int attempts = MAX_ATTEMPTS;

    public Task16_1() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        top.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        top.add(new JLabel("Угадайте число от 0 до " + MAX_NUMBER + ":"));
        top.add(input);

        JButton checkButton = new JButton("Проверить");
        checkButton.addActionListener(e -> checkGuess());
        input.addActionListener(e -> checkGuess());

        JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER));
        center.add(checkButton);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottom.add(attemptsLabel);

        frame.add(top, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void checkGuess() {
        String text = input.getText().trim();
        int guess;
        try {
            guess = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame,
                    "Введите целое число.",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (guess < 0 || guess > MAX_NUMBER) {
            JOptionPane.showMessageDialog(frame,
                    "Число должно быть от 0 до " + MAX_NUMBER + ".",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (guess == target) {
            JOptionPane.showMessageDialog(frame,
                    "Поздравляем! Вы угадали число " + target + ".",
                    "Победа", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        attempts--;
        if (attempts == 0) {
            JOptionPane.showMessageDialog(frame,
                    "Попытки закончились. Было загадано число " + target + ".",
                    "Проигрыш", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

        String hint = guess < target ? "больше" : "меньше";
        attemptsLabel.setText("Осталось попыток: " + attempts);
        JOptionPane.showMessageDialog(frame,
                "Загаданное число " + hint + ".",
                "Подсказка", JOptionPane.INFORMATION_MESSAGE);
        input.setText("");
        input.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task16_1::new);
    }
}
