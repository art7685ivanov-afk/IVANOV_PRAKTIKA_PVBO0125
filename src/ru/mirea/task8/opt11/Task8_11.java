package ru.mirea.task8.opt11;

import java.io.IOException;

/**
 * Задание 11. Количество единиц.
 * <p>
 * Дана последовательность натуральных чисел (одно число в строке),
 * завершающаяся двумя числами 0 подряд. Определить, сколько раз встречается 1.
 * <p>
 * Ограничения задания: нельзя использовать глобальные переменные
 * и параметры, передаваемые в рекурсивную функцию — функция сама читает
 * данные с клавиатуры.
 */
public class Task8_11 {

    /**
     * Чтение одного целого числа с клавиатуры побайтово.
     * <p>
     * Специально не используется Scanner: он буферизует ввод и при создании
     * нового экземпляра на каждом шаге рекурсии «съедал» бы лишние числа.
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

    /**
     * Рекурсивный подсчёт единиц. Параметров нет — данные читаются с клавиатуры.
     * Базовый случай: встретились два нуля подряд (конец последовательности).
     */
    public static int countOnes() {
        int value = readInt();

        if (value == 0) {
            // Возможно, это первый из двух завершающих нулей
            int next = readInt();
            if (next == 0) {
                return 0;
            }
            // Одиночный ноль в последовательности натуральных чисел невозможен,
            // поэтому считаем прочитанное значение обычным элементом
            return (next == 1 ? 1 : 0) + countOnes();
        }

        return (value == 1 ? 1 : 0) + countOnes();
    }

    public static void main(String[] args) {
        System.out.println("Введите последовательность (одно число в строке, конец — два нуля подряд):");
        System.out.println("Количество единиц: " + countOnes());
    }
}
