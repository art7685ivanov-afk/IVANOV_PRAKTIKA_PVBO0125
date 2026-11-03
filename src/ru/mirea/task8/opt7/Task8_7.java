package ru.mirea.task8.opt7;

/**
 * Задание 7. Разложение на множители.
 * <p>
 * Дано натуральное число n > 1. Вывести все простые множители этого числа
 * в порядке неубывания с учётом кратности. Алгоритм рекурсивный.
 */
public class Task8_7 {

    /**
     * Базовый случай: n == 1 — все множители уже выведены.
     * Шаг рекурсии: если текущий делитель делит n, выводим его и делим число,
     * иначе пробуем следующий делитель.
     */
    public static void factorize(int n, int divisor) {
        if (n == 1) {
            return;
        }
        if (n % divisor == 0) {
            System.out.print(divisor + " ");
            factorize(n / divisor, divisor);
        } else {
            factorize(n, divisor + 1);
        }
    }

    public static void main(String[] args) {
        int n = 3960;
        System.out.print("Простые множители числа " + n + ": ");
        factorize(n, 2);
        System.out.println();
    }
}
