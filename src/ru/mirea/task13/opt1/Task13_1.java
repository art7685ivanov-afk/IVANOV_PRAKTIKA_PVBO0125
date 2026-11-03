package ru.mirea.task13.opt1;

/**
 * Задание 1 на класс String.
 * <p>
 * Метод принимает произвольную строку и последовательно демонстрирует
 * возможности класса String: charAt, endsWith, startsWith, contains, indexOf,
 * replace, toUpperCase, toLowerCase, substring.
 */
public class Task13_1 {

    public static void analyze(String text) {
        System.out.println("Строка: " + text);
        System.out.println("Последний символ: " + text.charAt(text.length() - 1));
        System.out.println("Заканчивается на \"!!!\": " + text.endsWith("!!!"));
        System.out.println("Начинается с \"I like\": " + text.startsWith("I like"));
        System.out.println("Содержит \"Java\": " + text.contains("Java"));
        System.out.println("Позиция \"Java\": " + text.indexOf("Java"));
        System.out.println("Замена 'a' на 'o': " + text.replace('a', 'o'));
        System.out.println("Верхний регистр: " + text.toUpperCase());
        System.out.println("Нижний регистр: " + text.toLowerCase());
        System.out.println("Вырезать \"Java\": " + text.substring(7, 11));
    }

    public static void main(String[] args) {
        analyze("I like Java!!!");
    }
}
