package ru.mirea.task1.opt3;

public class CommandLineArgs {
    public static void main(String[] args) {
        // Вывод количества переданных аргументов
        System.out.println("Количество аргументов: " + args.length);
        System.out.println("Аргументы командной строки:");

        // Вывод всех аргументов в цикле for
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }
}