package ru.mirea.task12.opt2;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.io.File;

public class Task12_2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String path = args.length > 0 ? args[0] : chooseFile();
            if (path == null) {
                return;
            }

            ImageIcon icon = new ImageIcon(path);
            if (icon.getIconWidth() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Не удалось открыть изображение: " + path,
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JFrame frame = new JFrame("Изображение: " + new File(path).getName());
            JLabel label = new JLabel(icon);
            JScrollPane scrollPane = new JScrollPane(label);
            frame.add(scrollPane);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(Math.min(icon.getIconWidth() + 40, 1000),
                    Math.min(icon.getIconHeight() + 80, 800));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static String chooseFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
}
