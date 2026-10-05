package ru.mirea.task3.opt4form;

public class FormattingTask {
    public static void main(String[] args) {
        double x = 1000.0 / 3.0; // ≈ 333.33333...

        System.out.println("Без форматирования: " + x);

        // Разные спецификаторы формата
        System.out.printf("По умолчанию:        %f%n", x);
        System.out.printf("2 знака после точки: %.2f%n", x);
        System.out.printf("Ширина 8, точность 2: %8.2f%n", x);
        System.out.printf("Ширина 16, точность 2: %16.2f%n", x);
        System.out.printf("Слева (минус):       %-16.2f|%n", x);
        System.out.printf("Экспоненциальный:    %e%n", x);
        System.out.printf("Общий формат:        %g%n", x);

        // Пример из листинга 3.4
        double y = 11.635;
        System.out.printf("%nЗначение e = %.3f%n", Math.E);
        System.out.printf("exp(%.3f) = %.3f%n", y, Math.exp(y));
    }
}