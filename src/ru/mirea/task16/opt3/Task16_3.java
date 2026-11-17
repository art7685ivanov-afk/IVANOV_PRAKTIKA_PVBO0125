package ru.mirea.task16.opt3;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Font;

public class Task16_3 {
    private final JTextArea textArea = new JTextArea("Текст для изменения цвета и шрифта.", 10, 40);

    public Task16_3() {
        JFrame frame = new JFrame("JTextArea: цвет и шрифт");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(createMenuBar());

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        frame.add(new JScrollPane(textArea));
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu colorMenu = new JMenu("Цвет");
        addColorItem(colorMenu, "Синий", Color.BLUE);
        addColorItem(colorMenu, "Красный", Color.RED);
        addColorItem(colorMenu, "Черный", Color.BLACK);

        JMenu fontMenu = new JMenu("Шрифт");
        addFontItem(fontMenu, "Times New Roman");
        addFontItem(fontMenu, "MS Sans Serif");
        addFontItem(fontMenu, "Courier New");

        menuBar.add(colorMenu);
        menuBar.add(fontMenu);
        return menuBar;
    }

    private void addColorItem(JMenu menu, String title, Color color) {
        JMenuItem item = new JMenuItem(title);
        item.addActionListener(e -> textArea.setForeground(color));
        menu.add(item);
    }

    private void addFontItem(JMenu menu, String fontName) {
        JMenuItem item = new JMenuItem(fontName);
        item.addActionListener(e -> {
            Font current = textArea.getFont();
            textArea.setFont(new Font(fontName, current.getStyle(), current.getSize()));
        });
        menu.add(item);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task16_3::new);
    }
}
