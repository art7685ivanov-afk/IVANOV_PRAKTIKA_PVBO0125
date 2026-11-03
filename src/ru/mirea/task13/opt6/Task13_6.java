package ru.mirea.task13.opt6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Задание 6. Цепочка слов.
 * <p>
 * В main считывается имя файла со словами, разделёнными пробелом.
 * В getLine() с помощью StringBuilder слова расставляются так, чтобы последняя
 * буква слова совпадала с первой буквой следующего (без учёта регистра),
 * и каждое слово участвовало ровно один раз.
 */
public class Task13_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла со словами (например, words.txt): ");

        String fileName = scanner.nextLine().trim();
        String[] words;

        try {
            String content = Files.readString(Path.of(fileName));
            words = content.trim().split("\\s+");
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл " + fileName + ": " + e.getMessage());
            System.out.println("Используются слова по умолчанию.");
            words = new String[]{"apple", "elephant", "tiger", "rabbit", "tree"};
        }

        String chain = getLine(words);
        System.out.println("Исходные слова: " + Arrays.toString(words));
        System.out.println("Цепочка: " + chain);
    }

    public static String getLine(String[] words) {
        boolean[] used = new boolean[words.length];
        StringBuilder chain = new StringBuilder();

        for (int start = 0; start < words.length; start++) {
            if (buildChain(words, used, start, chain, words.length)) {
                return chain.toString().trim();
            }
        }
        return "Невозможно расставить все слова в одну цепочку";
    }

    private static boolean buildChain(String[] words, boolean[] used, int index,
                                      StringBuilder chain, int total) {
        used[index] = true;
        int lengthBefore = chain.length();
        chain.append(words[index]).append(' ');

        if (countUsed(used) == total) {
            return true;
        }

        char lastLetter = Character.toLowerCase(words[index].charAt(words[index].length() - 1));
        for (int next = 0; next < words.length; next++) {
            if (!used[next]
                    && Character.toLowerCase(words[next].charAt(0)) == lastLetter
                    && buildChain(words, used, next, chain, total)) {
                return true;
            }
        }

        // Откат: слово не подошло
        chain.setLength(lengthBefore);
        used[index] = false;
        return false;
    }

    private static int countUsed(boolean[] used) {
        int count = 0;
        for (boolean flag : used) {
            if (flag) {
                count++;
            }
        }
        return count;
    }
}
