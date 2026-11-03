package ru.mirea.task8.opt12;

import java.io.IOException;

/**
 * Задание 12. Вывести нечётные числа последовательности.
 * <p>
 * Последовательность натуральных чисел (одно число в строке) завершается нулём.
 * Нельзя использовать глобальные переменные и передавать параметры в рекурсивную
 * функцию: функция сама читает данные с клавиатуры и сразу выводит результат.
 * Основная программа состоит только из вызова этой функции.
 */
public class Task8_12 {

    /**
     * Побайтовое чтение целого числа, чтобы не буферизовать ввод и не терять
     * числа между рекурсивными вызовами (Scanner буферизует ввод целиком).
     */
    private static int readInt() {
        try {
            int symbol;
            do {
                symbol = System.in.read();
                if (symbol == -1) {
                    return 0;
                }
            } while (Character.isWhitespace(symbol));

            int sign = 1;
            if (symbol == '-') {
                sign = -1;
                symbol = System.in.read();
            }
            int value = 0;
            while (symbol >= '0' && symbol <= '9') {
                value = value * 10 + (symbol - '0');
                symbol = System.in.read();
            }
            return sign * value;
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка чтения с клавиатуры", e);
        }
    }

    public static void printOdd() {
        int value = readInt();

        // Базовый случай: конец последовательности
        if (value == 0) {
            return;
        }
        if (value % 2 != 0) {
            System.out.print(value + " ");
        }
        printOdd();
    }

    public static void main(String[] args) {
        printOdd();
        System.out.println();
    }
}
