package ru.mirea.task15.opt3;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Task15_3 {
    private final JTextArea textArea = new JTextArea("This is the area you can write text.");
    private final JFrame frame = new JFrame("Hello Swing");

    public Task15_3() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(createMenuBar());

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        button1.addActionListener(e -> textArea.append("\nButton 1"));
        button2.addActionListener(e -> textArea.append("\nButton 2"));

        JPanel buttons = new JPanel(new GridLayout(1, 2, 10, 10));
        buttons.add(button1);
        buttons.add(button2);
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.setLayout(new BorderLayout(10, 10));
        frame.add(buttons, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        JMenuItem saveItem = new JMenuItem("Сохранить");
        JMenuItem exitItem = new JMenuItem("Выйти");
        saveItem.addActionListener(e -> save());
        exitItem.addActionListener(e -> exit());
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Правка");
        JMenuItem copyItem = new JMenuItem("Копировать");
        JMenuItem cutItem = new JMenuItem("Вырезать");
        JMenuItem pasteItem = new JMenuItem("Вставить");
        copyItem.addActionListener(e -> textArea.copy());
        cutItem.addActionListener(e -> textArea.cut());
        pasteItem.addActionListener(e -> textArea.paste());
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        JMenu helpMenu = new JMenu("Справка");
        JMenuItem aboutItem = new JMenuItem("О программе");
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Программа демонстрирует работу с меню, кнопками и текстовым полем.",
                "Справка", JOptionPane.INFORMATION_MESSAGE));
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        return menuBar;
    }

    private void save() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(frame) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        try {
            Files.writeString(chooser.getSelectedFile().toPath(),
                    textArea.getText(), StandardCharsets.UTF_8);
            JOptionPane.showMessageDialog(frame,
                    "Файл сохранён.",
                    "Сообщение", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame,
                    "Не удалось сохранить файл: " + e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exit() {
        int answer = JOptionPane.showConfirmDialog(frame,
                "Выйти из программы?", "Подтверждение",
                JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task15_3::new);
    }
}
