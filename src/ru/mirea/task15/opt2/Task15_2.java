package ru.mirea.task15.opt2;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Task15_2 {
    private static final String[] COUNTRIES = {"Australia", "China", "England", "Russia"};

    private final JComboBox<String> countryBox = new JComboBox<>(COUNTRIES);
    private final JTextArea infoArea = new JTextArea(8, 35);

    public Task15_2() {
        JFrame frame = new JFrame("Страны");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        top.add(new JLabel("Выберите страну:"));
        top.add(countryBox);

        infoArea.setEditable(false);
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        infoArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        countryBox.addActionListener(e -> showInfo());

        frame.add(top, BorderLayout.NORTH);
        frame.add(new JScrollPane(infoArea), BorderLayout.CENTER);
        frame.setSize(520, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        showInfo();
    }

    private void showInfo() {
        String country = (String) countryBox.getSelectedItem();
        String info = switch (country == null ? "" : country) {
            case "Australia" -> "Австралия — государство в Южном полушарии. Столица — Канберра.";
            case "China" -> "Китай — государство в Восточной Азии. Столица — Пекин.";
            case "England" -> "Англия — часть Соединённого Королевства. Столица — Лондон.";
            case "Russia" -> "Россия — государство в Восточной Европе и Северной Азии. Столица — Москва.";
            default -> "";
        };
        infoArea.setText(info);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task15_2::new);
    }
}
