package ru.mirea.task8.opt13;

import java.io.IOException;

/**
 * Задание 13. Вывести члены последовательности с нечётными номерами.
 * <p>
 * Последовательность натуральных чисел (одно число в строке) завершается нулём.
 * Нужно вывести первое, третье, пятое и т.д. введённые числа.
 * Нельзя использовать глобальные переменные и передавать параметры в функцию:
 * функция сама читает данные с клавиатуры и сразу выводит результат.
 */
public class Task8_13 {

    /** Побайтовое чтение целого числа без буферизации ввода. */
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

    /**
     * За один шаг читаются два числа: первое стоит на нечётной позиции
     * и выводится, второе (чётная позиция) пропускается.
     */
    public static void printOddPositions() {
        int oddValue = readInt();
        if (oddValue == 0) {
            return;
        }
        int evenValue = readInt();
        System.out.print(oddValue + " ");
        if (evenValue == 0) {
            return;
        }
        printOddPositions();
    }

    public static void main(String[] args) {
        printOddPositions();
        System.out.println();
    }
}
