package ru.mirea.task16.opt4;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Task16_4 {
    private static final String CORRECT_SERVICE = "MIREA";
    private static final String CORRECT_USER = "student";
    private static final String CORRECT_PASSWORD = "java123";

    private final JTextField serviceField = new JTextField(20);
    private final JTextField userField = new JTextField(20);
    private final JPasswordField passwordField = new JPasswordField(20);
    private final JLabel statusLabel = new JLabel(" ");
    private final JFrame frame = new JFrame("Password application");

    public Task16_4() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        addRow(form, constraints, 0, "Service:", serviceField);
        addRow(form, constraints, 1, "User name:", userField);
        addRow(form, constraints, 2, "Password:", passwordField);

        JButton checkButton = new JButton("Проверить");
        checkButton.addActionListener(e -> checkPassword());
        passwordField.addActionListener(e -> checkPassword());

        JPanel bottom = new JPanel(new BorderLayout(10, 10));
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        bottom.add(checkButton, BorderLayout.WEST);
        bottom.add(statusLabel, BorderLayout.CENTER);

        frame.add(form, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addRow(JPanel panel, GridBagConstraints constraints,
                        int row, String label, JComponent field) {
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.weightx = 0;
        panel.add(new JLabel(label), constraints);

        constraints.gridx = 1;
        constraints.weightx = 1;
        panel.add(field, constraints);
    }

    private void checkPassword() {
        String service = serviceField.getText().trim();
        String user = userField.getText().trim();
        String password = new String(passwordField.getPassword());

        boolean correct = service.equalsIgnoreCase(CORRECT_SERVICE)
                && user.equalsIgnoreCase(CORRECT_USER)
                && password.equals(CORRECT_PASSWORD);

        if (correct) {
            statusLabel.setText("Доступ разрешён");
            statusLabel.setForeground(new Color(0, 128, 0));
        } else {
            statusLabel.setText("Неверные данные");
            statusLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task16_4::new);
    }
}
