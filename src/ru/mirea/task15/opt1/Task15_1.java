package ru.mirea.task15.opt1;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Task15_1 {
    private final JTextField firstField = new JTextField(10);
    private final JTextField secondField = new JTextField(10);
    private final JLabel resultLabel = new JLabel("Результат: ");

    public Task15_1() {
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("Первое число:"));
        inputPanel.add(firstField);
        inputPanel.add(new JLabel("Второе число:"));
        inputPanel.add(secondField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        String[] operations = {"+", "-", "*", "/"};
        for (String operation : operations) {
            JButton button = new JButton(operation);
            button.addActionListener(e -> calculate(operation));
            buttonPanel.add(button);
        }

        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        content.add(inputPanel, BorderLayout.NORTH);
        content.add(buttonPanel, BorderLayout.CENTER);
        content.add(resultLabel, BorderLayout.SOUTH);

        frame.add(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void calculate(String operation) {
        try {
            double first = Double.parseDouble(firstField.getText().trim().replace(',', '.'));
            double second = Double.parseDouble(secondField.getText().trim().replace(',', '.'));

            double result;
            switch (operation) {
                case "+" -> result = first + second;
                case "-" -> result = first - second;
                case "*" -> result = first * second;
                case "/" -> {
                    if (second == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Деление на ноль невозможно.",
                                "Ошибка", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = first / second;
                }
                default -> {
                    return;
                }
            }
            resultLabel.setText("Результат: " + format(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Введите корректные числа.",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String format(double value) {
        if (value == Math.rint(value) && !Double.isInfinite(value)) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task15_1::new);
    }
}
