package ru.mirea.task2.opt10;

import java.util.Scanner;

public class HowMany {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите текст (слова через пробел):");
        String line = sc.nextLine();

        String trimmed = line.trim();

        int wordCount;
        if (trimmed.isEmpty()) {
            wordCount = 0;
        } else {
            String[] words = trimmed.split("\\s+");
            wordCount = words.length;
        }

        System.out.println("Вы ввели слов: " + wordCount);

        sc.close();
    }
}