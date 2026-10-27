package ru.mirea.task13.opt1;

public class Task13_1 {
    public static void main(String[] args) {
        String text = "I like Java!!!";

        System.out.println("Строка: " + text);
        System.out.println("Последний символ: " + text.charAt(text.length() - 1));
        System.out.println("Заканчивается на '!!!': " + text.endsWith("!!!"));
        System.out.println("Начинается с 'I like': " + text.startsWith("I like"));
        System.out.println("Содержит 'Java': " + text.contains("Java"));
        System.out.println("Позиция 'Java': " + text.indexOf("Java"));
        System.out.println("Замена a->o: " + text.replace('a', 'o'));
        System.out.println("Верхний регистр: " + text.toUpperCase());
        System.out.println("Нижний регистр: " + text.toLowerCase());
        System.out.println("Вырезать 'Java': " + text.substring(7, 11));
    }
}