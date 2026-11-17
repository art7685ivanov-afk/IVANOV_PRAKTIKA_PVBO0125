package ru.mirea.task15.opt4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class Task15_4 {
    private final JTextField display = new JTextField("0");
    private double accumulator;
    private String pendingOperation = "";
    private boolean startNewNumber = true;

    public Task15_4() {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));

        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Dialog", Font.BOLD, 24));
        frame.add(display, BorderLayout.NORTH);

        JPanel buttons = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] labels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };
        for (String label : labels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Dialog", Font.BOLD, 18));
            button.addActionListener(e -> handleButton(label));
            buttons.add(button);
        }

        frame.add(buttons, BorderLayout.CENTER);
        frame.setSize(320, 380);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void handleButton(String label) {
        if (label.matches("\\d")) {
            if (startNewNumber) {
                display.setText(label);
                startNewNumber = false;
            } else {
                display.setText(display.getText() + label);
            }
            return;
        }
        if (".".equals(label)) {
            if (startNewNumber) {
                display.setText("0.");
                startNewNumber = false;
            } else if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
            return;
        }
        if ("=".equals(label)) {
            calculate();
            return;
        }
        applyOperation(label);
    }

    private void applyOperation(String operation) {
        if (!pendingOperation.isEmpty() && !startNewNumber) {
            calculate();
        } else {
            accumulator = currentValue();
        }
        pendingOperation = operation;
        startNewNumber = true;
    }

    private void calculate() {
        double value = currentValue();
        double result;
        switch (pendingOperation) {
            case "+" -> result = accumulator + value;
            case "-" -> result = accumulator - value;
            case "*" -> result = accumulator * value;
            case "/" -> {
                if (value == 0) {
                    display.setText("Ошибка");
                    accumulator = 0;
                    pendingOperation = "";
                    startNewNumber = true;
                    return;
                }
                result = accumulator / value;
            }
            default -> {
                accumulator = value;
                startNewNumber = true;
                return;
            }
        }
        accumulator = result;
        display.setText(format(result));
        pendingOperation = "";
        startNewNumber = true;
    }

    private double currentValue() {
        try {
            return Double.parseDouble(display.getText().replace(',', '.'));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String format(double value) {
        if (value == Math.rint(value) && !Double.isInfinite(value)) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task15_4::new);
    }
}
